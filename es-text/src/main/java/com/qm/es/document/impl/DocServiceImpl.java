package com.qm.es.document.impl;

import com.qm.es.bean.BulkBean;
import com.qm.es.bean.BulkBeanWithOption;
import com.qm.es.document.DocService;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.index.query.QueryBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DocServiceImpl implements DocService {
    @Override
    public void addDoc(String index, String type, String json) throws IOException {

    }

    @Override
    public void addDoc(String index, String type, String json, String id) throws IOException {

    }

    @Override
    public UpdateResponse update(String index, String type, Map<String, Object> values, String id) throws IOException {
        return null;
    }

    @Override
    public void deleteDocById(String index, String type, String id) throws Exception {

    }

    @Override
    public void bulkDeleteDoc(String index, String type, String id) throws Exception {

    }

    @Override
    public void bulkDelete(String[] indexs, String[] types, String[] ids) throws Exception {

    }

    @Override
    public void bulkDelte(List<BulkBean> beans) throws IOException {

    }

    @Override
    public void mGet(String index, String type) throws Exception {

    }

    @Override
    public void mGet(List<BulkBean> beans) throws Exception {

    }

    @Override
    public void bulkOption(List<BulkBeanWithOption> beanWithOptionList) throws IOException {

    }

    @Override
    public void deleteByQuery(String index, String type, QueryBuilder queryBuilder) throws Exception {

    }
}
