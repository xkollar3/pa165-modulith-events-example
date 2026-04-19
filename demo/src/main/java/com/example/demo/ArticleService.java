package com.example.demo;

import java.util.UUID;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleService {

  private final ApplicationEventPublisher eventPublisher;

  // simply mock method here, just log and publish, in real world could also save
  // it into DB via repository
  @Transactional
  public UUID createArticle(String content) {
    UUID id = UUID.randomUUID();

    eventPublisher.publishEvent(new ArticleCreatedEvent(id, content));

    log.info("Created article with content: {}, id: {}", content, id);
    return id;
  }
}
