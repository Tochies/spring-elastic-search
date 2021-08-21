package com.tochie.springelasticsearch.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.env.Environment;
import org.springframework.beans.factory.annotation.Configurable;
import org.elasticsearch.node.Node;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@ComponentScan
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.tochie.springelasticsearch.repository")
public class ElasticConfiguration {

    @Bean
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration
                = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

    public ElasticsearchOperations elasticsearchOperations(){

        return new ElasticsearchRestTemplate(client());

    }
}
