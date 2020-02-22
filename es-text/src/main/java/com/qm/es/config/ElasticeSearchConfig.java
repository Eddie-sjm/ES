package com.qm.es.config;


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


import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jackiechan on 2020-02-19 14:51
 *
 * @Author jackiechan
 */
@Configuration
public class ElasticeSearchConfig {


    private static final String SCHMEA = "http";//我们要使用的协议是 http,通过 http 来访问 es

    @Value("${spring.data.elasticsearch.host}")
    private String hosts;//集群的集群地址,多个以,分割
    @Value("${spring.data.elasticsearch.port}")
    private int port;
    @Value("${spring.data.elasticsearch.connectTimeOut}")
    private int connectTimeOut;
    @Value("${spring.data.elasticsearch.socketTimeOut}")
    private int socketTimeOut;
    @Value("${spring.data.elasticsearch.connectionRequestTimeOut}")
    private int connectionRequestTimeOut;
    @Value("${spring.data.elasticsearch.maxConnectNum}")
    private int maxConnectNum;
    @Value("${spring.data.elasticsearch.maxConnectPerRoute}")
    private int maxConnectPerRoute;


    /**
     * 创建我们的客户端对象
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(RestHighLevelClient.class)
    public RestHighLevelClient client() {
//        ArrayList<HttpHost> httpHostArrayList = new ArrayList<>();
//        String[] hostss = hosts.split(",");
//        for (String s : hostss) {//遍历我们的数组,创建 httphost 数组
//            HttpHost httpHost = new HttpHost(s, port);
//            httpHostArrayList.add(httpHost);
//        }
//        RestClientBuilder builder = RestClient.builder(httpHostArrayList.toArray(new HttpHost[0]));
        String[] hostss = hosts.split(",");
        HttpHost[] httpHosts = null;
        if (hostss != null) {//如果我们的服务器不为空,那么有多少 ip 就创建一个多大的数组
            httpHosts = new HttpHost[hostss.length];
        }
        for (int i = 0; i < hostss.length; i++) { //将我们的服务器 ip 和端口转成对象,放入到集合中
            HttpHost httpHost = new HttpHost(hostss[i], port);
            httpHosts[i] = httpHost;
        }
        RestClientBuilder builder = RestClient.builder(httpHosts);//根据服务器地址数组来生成一个构造器

        setConnectionTimeOutConfig(builder);//设置超时操作
        setMutConnectionConfig(builder);//设置异步相关操作

        RestHighLevelClient levelClient = new RestHighLevelClient(builder);
        return levelClient;

    }

    /**
     * 配置连接的时间一些相关信息
     * @param builder
     */
    public void setConnectionTimeOutConfig(RestClientBuilder builder) {
        builder.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
            @Override
            public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder builder) {
                builder.setConnectTimeout(connectTimeOut);
                builder.setSocketTimeout(socketTimeOut);
                builder.setConnectionRequestTimeout(connectionRequestTimeOut);
                return builder;
            }
        });
    }

    /**
     * 异步的连接数配置
     * @param builder
     */
    public void setMutConnectionConfig(RestClientBuilder builder) {

        builder.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
            @Override
            public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpAsyncClientBuilder) {
                httpAsyncClientBuilder.setMaxConnTotal(maxConnectNum);
                httpAsyncClientBuilder.setMaxConnPerRoute(maxConnectPerRoute);
                return httpAsyncClientBuilder;
            }
        });
    }





}
