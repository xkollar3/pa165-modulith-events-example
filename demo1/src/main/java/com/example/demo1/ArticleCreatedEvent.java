package com.example.demo1;

import java.util.UUID;

public record ArticleCreatedEvent(UUID id, String content) {
}
