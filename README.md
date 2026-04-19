# Spring modulith event externalization example

- project demonstrates event externalization with using spring modulith and postgres to simulate the transactional outbox pattern
- events are sent to rabbit exchanges declared by producing side
- consuming side creates queues and binds to exchanges for events it requires

## Demo service
- demo is the publishing service, it publishes events to rabbitmq
- AmqpConfig declares topology, for now there is articles-exchange
- ArticleCreatedEvent is publishes with articles.created routing key

## Demo1
- demo1 is the consuming service
- demo1 AmqpConfig declares a article-demo1-events queue and binds it to articles exchange via article.created routing key

## Runing the demo
- start pg and rabbit in docker
```
docker compose up
```

- start both services
```
cd demo && mvn spring-boot:run
cd demo1 && mvn spring-boot:run
```

- call demo service backend for example via curl
```
curl -s -X POST http://localhost:8080/api/articles \
    -H "Content-Type: application/json" \
    -d '{"content": "Hello World"}'
```

## Additional info
- outbox is implement via event_publication table, spring automatically initializes schema see @demo/application.properties

