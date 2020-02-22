package com.qm.es.document;
//
//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易  
//          佛曰:  
//                  写字楼里写字间，写字间里程序员；  
//                  程序人员写程序，又拿程序换酒钱。  
//                  酒醒只在网上坐，酒醉还来网下眠；  
//                  酒醉酒醒日复日，网上网下年复年。  
//                  但愿老死电脑间，不愿鞠躬老板前；  
//                  奔驰宝马贵者趣，公交自行程序员。  
//                  别人笑我忒疯癫，我笑自己命太贱；
import com.qm.es.bean.BulkBean;
import com.qm.es.bean.BulkBeanWithOption;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.index.query.QueryBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by jackiechan on 2020-02-19 16:10
 *
 * @Author jackiechan
 */
public interface DocService {
    /**
     * 不带 id 添加数据
     *
     * @param index
     * @param type
     * @param json
     * @throws IOException
     */
    void addDoc(String index, String type, String json) throws IOException;

    /**
     * 带 id 添加数据
     *
     * @param index
     * @param type
     * @param json
     * @param id
     * @throws IOException
     */
    void addDoc(String index, String type, String json, String id) throws IOException;

    /**
     * 根据 id 局部更新部分内容
     *
     * @param index
     * @param type
     * @param values
     * @param id
     * @return
     */
    UpdateResponse update(String index, String type, Map<String, Object> values, String id) throws IOException;

    void deleteDocById(String index, String type, String id) throws Exception;

    void bulkDeleteDoc(String index, String type, String id) throws Exception;

    /**
     * 演示批量删除
     * @param indexs
     * @param types
     * @param ids
     * @throws Exception
     */
    void bulkDelete(String[] indexs, String[] types, String[] ids) throws Exception;


    void bulkDelte(List<BulkBean> beans) throws IOException;
    /**
     * 批量查询,此处仅仅是为了演示,只写了查询某个 index 下的某个 type, id 我们在测试的时候自己随便写的,实际开发中应该传递数量保持一致的三个数组或者是封装有着三个参数的对象集合
     * @param index
     * @param type
     * @throws Exception
     */
    void mGet(String index, String type) throws Exception;

    /**
     * 演示封装参数的批量查询
     * @param beans
     * @throws Exception
     */
    void mGet(List<BulkBean> beans) throws Exception;

    /**
     * 真的各种不同操作的情况下
     *
     * @param beanWithOptionList
     */
    void bulkOption(List<BulkBeanWithOption> beanWithOptionList) throws IOException;

    /**
     * 因为我们的查询方式有很多,所以我们并不知道当前到底是根据哪种查询来做的删除,所以此处我们仅模拟一种
     */
    void deleteByQuery(String index, String type, QueryBuilder queryBuilder) throws Exception;
}
