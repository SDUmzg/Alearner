package com.alearner;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.ElasticSearchDruidDataSourceFactory;
import com.floragunn.searchguard.ssl.SearchGuardSSLPlugin;
import org.elasticsearch.action.ActionResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import org.nlpcn.es4sql.SearchDao;
import org.nlpcn.es4sql.exception.SqlParseException;
import org.nlpcn.es4sql.query.SqlElasticRequestBuilder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.alibaba.druid.pool.DruidDataSourceFactory.PROP_CONNECTIONPROPERTIES;


/**
 * Created by mzg on 2018/10/31.
 */
public class ApplicationTest {
    @Test
    public void testJDBC() throws Exception {
        Properties properties = new Properties();
        properties.put("url", "jdbc:elasticsearch://114.115.144.19:9300/");
        properties.put(PROP_CONNECTIONPROPERTIES, "client.transport.ignore_cluster_name=true;xpack.security.user=elastic:mzg...8535933570");
        DruidDataSource dds = (DruidDataSource) ElasticSearchDruidDataSourceFactory.createDataSource(properties);

        Connection connection = dds.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from megacorp");
        ResultSet resultSet = ps.executeQuery();
        List<String> result = new ArrayList<String>();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("first_name") + "," + resultSet.getInt("age") + "," + resultSet.getString("last_name"));
        }
        ps.close();
        connection.close();
        dds.close();
    }


    @Test
    public void testSGJDBC(){
        Settings settings = Settings.builder()
                .put("path.home", ".")
                .put("http.enabled", true)
//                .put("cluster.name", "elasticsearch")
                .put("searchguard.ssl.transport.keystore_filepath", "E:\\IdeaProjects\\Alearner\\es-sql\\src\\main\\resources\\conf\\testJdbc-keystore.jks")
                .put("searchguard.ssl.transport.keystore_password", "kspass")
                .put("searchguard.ssl.transport.truststore_filepath", "E:\\IdeaProjects\\Alearner\\es-sql\\src\\main\\resources\\conf\\truststore.jks")
                .put("searchguard.ssl.transport.truststore_password", "tspass")
                .put("searchguard.ssl.transport.enforce_hostname_verification", false)
                .put("client.transport.ignore_cluster_name",true)
                .build();

        TransportAddress transportAddress;
        try {
            transportAddress = new TransportAddress(InetAddress.getByName("*****"),9300);
            TransportClient client = new PreBuiltTransportClient(settings,SearchGuardSSLPlugin.class)
                    .addTransportAddress(transportAddress);


            SearchDao searchDao = new SearchDao(client);
            SqlElasticRequestBuilder requestBuilder = searchDao.explain("select * from megacorp").explain();

            // explain
            System.out.println(requestBuilder.explain());

            ActionResponse response = requestBuilder.get();
            // execute
            System.out.println(response);

            System.out.println();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }catch (SqlParseException e1) {
            e1.printStackTrace();
        } catch (SQLFeatureNotSupportedException e2) {
            e2.printStackTrace();
        }


    }






}