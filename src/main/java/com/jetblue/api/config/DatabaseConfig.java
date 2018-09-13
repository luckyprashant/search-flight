package com.jetblue.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jetblue.api.constant.AppConstant;
import com.microsoft.azure.cosmosdb.ConnectionPolicy;
import com.microsoft.azure.cosmosdb.ConsistencyLevel;
import com.microsoft.azure.cosmosdb.rx.AsyncDocumentClient;
import com.microsoft.azure.spring.data.cosmosdb.config.DocumentDBConfig;
import com.microsoft.azure.spring.data.cosmosdb.repository.config.EnableDocumentDbRepositories;

@Configuration
@EnableDocumentDbRepositories(basePackages={"com.jetblue.api"})
public class DatabaseConfig {

	@Value("${azure.documentdb.uri}")
    private String uri;

    @Value("${azure.documentdb.key}")
    private String key;

    @Value("${azure.documentdb.database}")
    private String dbName;

    public DocumentDBConfig getConfig() {
        return DocumentDBConfig.builder(uri, key, dbName).build();
    }
    
    @Bean(name="cosmosDbClient")
    public AsyncDocumentClient cosmosDbClient() {
		return new AsyncDocumentClient.Builder()
				.withServiceEndpoint(AppConstant.HOST)
				.withMasterKeyOrResourceToken(AppConstant.MASTER_KEY)
				.withConnectionPolicy(ConnectionPolicy.GetDefault())
				.withConsistencyLevel(ConsistencyLevel.Session)
				.build();

	}
}
