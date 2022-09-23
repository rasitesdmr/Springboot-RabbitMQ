# 🎯 RabbitMQ ?

<img src="https://github.com/rasitesdmr/Springboot-RabbitMQ/blob/master/image/rb1.png">

## 📌 docker-compose.yaml

```yaml
docker-compose up --build -d
```

```yaml
docker-compose down -v
```

## 📌 RabbitMQ Maven Dependencies

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```

```xml

<dependency>
    <groupId>org.springframework.amqp</groupId>
    <artifactId>spring-rabbit-test</artifactId>
    <scope>test</scope>
</dependency>
```

## 📌 RabbitMQ Service

* http://localhost:15672

<img src="https://github.com/rasitesdmr/Springboot-RabbitMQ/blob/master/image/rb2.png">

## 📌 Articles I Read

* https://www.baeldung.com/java-rabbitmq-exchanges-queues-bindings
* https://medium.com/multinetinventiv/rabbitmq-ve-net-core-834a8d3ded94
* https://www.borakasmer.com/rabbitmq-nedir/
* https://www.cloudamqp.com/blog/part1-rabbitmq-for-beginners-what-is-rabbitmq.html
* https://www.cloudamqp.com/blog/part3-rabbitmq-for-beginners_the-management-interface.html
* https://www.cloudamqp.com/blog/part4-rabbitmq-for-beginners-exchanges-routing-keys-bindings.html
* https://www.gencayyildiz.com/blog/rabbitmq-nedir-ne-amaca-hizmet-etmektedir/