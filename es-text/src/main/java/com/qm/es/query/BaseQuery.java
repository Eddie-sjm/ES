package com.qianfeng.elasticsearch.query;
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


import org.elasticsearch.index.query.Operator;

/**
 * Created by jackiechan on 2020-02-20 11:13
 *
 * @Author jackiechan
 */
public interface BaseQuery {
    /**
     * term 查询
     *
     * @param index
     * @param type
     * @param fieldName 条件列
     * @param value     条件的值
     */
    void termQuery(String index, String type, String fieldName, String value) throws Exception;

    void termsQuery(String index, String type, String fieldName, String... value) throws Exception;

    /**
     * 查询所有
     * @param index
     * @param type
     * @throws Exception
     */
    void queryAll(String index, String type) throws Exception;

    /**
     * 根据条件列和关键字查询
     * @param index
     * @param type
     * @param field
     * @param keyword
     * @throws Exception
     */
    void queryMatch(String index, String type,  String keyword,String field) throws Exception;

    /**
     * @param index
     * @param type
     * @param field
     * @param keyword
     * @param operator 选项,比如 and or
     */
    void queryMatchWithOperate(String index, String type, String field, String keyword, Operator operator)throws Exception;

    /**
     * @param index
     * @param type
     * @param keyword 关键词
     * @param fields  通过哪些列搜索
     */
    void queryMatchMulti(String index, String type, String keyword, String... fields)throws Exception;

    /**
     * 近似查询
     *
     * @param index
     * @param type
     * @param keyword
     * @param field
     * @throws Exception
     */
    void queryMatchPhrase(String index, String type, String keyword, String field) throws Exception;

    /**
     * 根据 id 查询数据
     * @param index
     * @param type
     * @param ids
     * @throws Exception
     */
    void idsQuery(String index, String type, String... ids) throws Exception;

    /**
     * 前缀查询
     *
     * @param index
     * @param type
     * @param field
     * @param prefixValue
     * @throws Exception
     */
    void prefixQuery(String index, String type, String field, String prefixValue) throws Exception;

    /**
     * 模糊匹配
     *
     * @param index
     * @param type
     * @param field
     * @param keyword
     * @throws Exception
     */
    void fuzzyQuery(String index, String type, String field, String keyword) throws Exception;

    /**
     * 通配符查询
     * @param index
     * @param type
     * @param field
     * @param wildcardValue
     * @throws Exception
     */
    void wildCardQuery(String index, String type, String field, String wildcardValue) throws Exception;

    /**
     * 正则表达式查询
     *
     * @param index
     * @param type
     * @param field
     * @param regex
     * @throws Exception
     */
    void regexQuery(String index, String type, String field, String regex) throws Exception;

    /**
     * 范围查询
     *
     * @param index
     * @param type
     * @param field
     * @param from
     * @param to
     * @throws Exception
     */
    void rangeQuery(String index, String type, String field, int from, int to) throws Exception;

    /**
     * 滚动查询
     * @param index
     * @param type
     * @throws Exception
     */
    void scrollQuery(String index, String type) throws Exception;
}
