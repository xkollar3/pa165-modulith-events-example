package com.example.demo;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// configure single exchange, not really 100% neccessary but this bean declaration will automatically create the exchange in RabbitMQ
// why its not neccessary: Spring modulith will take care of routing and this object is never referenced
@Configuration
public class AmqpConfig {

  @Bean
  TopicExchange exchange() {
    return new TopicExchange("articles-exchange");
  }
}
