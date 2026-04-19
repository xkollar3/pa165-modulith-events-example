package com.example.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {

  @Bean
  Queue articleQueue() {
    return new Queue("articles");
  }

  @Bean
  TopicExchange exchange() {
    return new TopicExchange("articles-exchange");
  }

  @Bean
  Binding binding(Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue)
        .to(exchange)
        .with("article.created");
  }
}
