package com.example.demo1;

import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ArticleCreationPolicy {

  @RabbitListener(queues = "articles")
  public void handle(ArticleCreatedEvent event) {
    log.info("Article was created, id: {}, content: {}", event.id(), event.content());
  }

}
