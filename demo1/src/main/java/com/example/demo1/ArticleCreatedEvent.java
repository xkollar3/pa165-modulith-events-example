package com.example.demo1;

import java.util.UUID;

// redeclare event so we can use type
public record ArticleCreatedEvent(UUID id, String content) {
}
