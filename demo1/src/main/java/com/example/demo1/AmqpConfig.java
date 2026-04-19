package com.example.demo1;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// config to bind to articles-exchange
@Configuration
public class AmqpConfig {

  @Bean
  TopicExchange articlesTopic() {
    return new TopicExchange("articles-exchange");
  }

  @Bean
  Queue articleQueue() {
    return new Queue("article-demo1-events");
  }

  @Bean
  Binding binding(Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue)
        .to(exchange)
        .with("article.created");
  }

  // required otherwise JSON conversion fails
  @Bean
  public MessageConverter messageConverter() {
    return new JacksonJsonMessageConverter();
  }

}
