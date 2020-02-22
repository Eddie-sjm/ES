package com.qm.es.query;
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


/**
 * Created by jackiechan on 2020-02-21 16:01
 *
 * @Author jackiechan
 */
public interface AggregationQueryService {
    /**
     * 去重
     * @param index
     * @param type
     * @param field
     * @throws Exception
     */
    void cardinalityAggregator(String index, String type, String field) throws Exception;

    void dateRangeAggregator(String index, String type, String field) throws Exception;

    void histogramAggregator(String index, String type, String field, int interval) throws Exception;

    void dateHistogramInterval(String index, String type, String field) throws Exception;

    void extended_statsAggre(String index, String type, String field) throws Exception;

    void termsAggre(String index, String type) throws Exception;

    void geoDisatanceAggre(String index, String type) throws Exception;
}
