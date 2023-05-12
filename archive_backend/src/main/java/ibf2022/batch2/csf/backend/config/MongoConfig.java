package ibf2022.batch2.csf.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {

    @Value("${mongo.url}")
    private String mongoUrl;
    @Bean
    public MongoTemplate createMongoTemplate(){
        // create mongo client
        MongoClient client = MongoClients.create(mongoUrl);
        
        // create template and pass in database
        MongoTemplate template = new MongoTemplate(client, "Assess");
        return template;
    }
}