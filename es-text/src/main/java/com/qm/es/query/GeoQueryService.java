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


import org.elasticsearch.common.geo.GeoPoint;

import java.util.List;

/**
 * Created by jackiechan on 2020-02-21 14:59
 *
 * @Author jackiechan
 */
public interface GeoQueryService {
    /**
     *
     * @param index
     * @param type
     * @param lon 经度
     * @param lat 维度
     * @param distance 周围多远
     * @throws Exception
     */
    void geo_distanceQuery(String index,String type,double lon,double lat,int distance) throws Exception;

    /**
     * @param index
     * @param type
     * @param left   左上角的经度
     * @param top    左上角的维度
     * @param right  右下角的经度
     * @param bottom 右下角的维度
     * @throws Exception
     */
    void geo_bounding_boxQuery(String index, String type, double left, double top, double right, double bottom) throws Exception;

    /**
     * 多边形
     * @param index
     * @param type
     * @param geoPoints 代表多个经纬度的数据
     */
    void geo_polygonQuery(String index, String type, List<GeoPoint> geoPoints) throws Exception;
}
