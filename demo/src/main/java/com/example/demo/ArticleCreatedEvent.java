package com.example.demo;

import java.util.UUID;

import org.springframework.modulith.events.Externalized;

@Externalized("articles-exchange::article.created")
public record ArticleCreatedEvent(UUID id, String content) {
}
