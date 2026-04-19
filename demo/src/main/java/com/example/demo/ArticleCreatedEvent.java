package com.example.demo;

import java.util.UUID;

import org.springframework.modulith.events.Externalized;

// @Externalized enables the externalization, spring modulith framework will not send the object to MQ if its not marked
// the contents on the annotation dictate spring to send it to articles-exchange with routing key: article.created
@Externalized("articles-exchange::article.created")
public record ArticleCreatedEvent(UUID id, String content) {
}
