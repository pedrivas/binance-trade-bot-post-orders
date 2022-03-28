package com.post.orders.config;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqsConfig {

    @Bean
    public AmazonSQS queueMessagingTemplate(AmazonSQSAsync amazonSQSAsync) {
        return AmazonSQSClientBuilder/*AmazonSQSAsyncClientBuilder*/
                .standard()
                .withRegion("sa-east-1")
                .build();
    }

}