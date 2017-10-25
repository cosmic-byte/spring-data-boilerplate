
package com.springdata.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

@Configuration
@EnableElasticsearchRepositories(basePackages = {"com.springdata.dto","com.springdata.elasticrepo"})
public class ElasticSearchConfig {

    Settings esSettings = Settings.settingsBuilder()
            .put("cluster.name", "your_cluster_name")
            .build();

    @Bean
    public Client client() throws Exception {

         return TransportClient.builder()
                 .settings(esSettings)
                 .build()
                 .addTransportAddress(new InetSocketTransportAddress(
                         InetAddress.getByName("localhost"), 9300));
    }


    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }

}

