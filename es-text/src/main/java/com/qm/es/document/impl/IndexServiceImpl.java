package com.qm.es.document.impl;

import com.qm.es.document.IndexService;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {

    private  final static Logger LOGGER = LoggerFactory.getLogger(IndexServiceImpl.class);

    @Autowired
    private RestHighLevelClient client;

    @Override
    public void createIndex(String index, String type, CreateIndexRequest request) throws Exception {
        LOGGER.error("source:{}",request.toString());
        if(!existsIndex(index)){
            CreateIndexResponse response = client.indices()
                    .create(request, RequestOptions.DEFAULT);
            LOGGER.error("创建索引{}的结果是{}",index,response.isAcknowledged());
        }else {
            LOGGER.error("索引已经存在{}",index);
        }
    }

    @Override
    public void deleteIndex(String index) throws Exception {
        if(existsIndex(index)){
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(index);
            AcknowledgedResponse response = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
            LOGGER.error("删除索引{}的结果是{}",index, response.isAcknowledged());
        }else {
            LOGGER.error("索引不存在{},无法删除",index);
        }
    }

    @Override
    public boolean existsIndex(String index) throws Exception {
        GetIndexRequest getIndexRequest = new GetIndexRequest();
        getIndexRequest.indices(index);
        boolean exists = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        return exists;
    }
}
