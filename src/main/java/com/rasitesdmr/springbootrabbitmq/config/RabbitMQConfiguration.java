package com.rasitesdmr.springbootrabbitmq.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // Configuration sınıfı olduğunu belirtiyoruz.
public class RabbitMQConfiguration {

    @Value("${sr.rabbit.queue.name}") // Value : configuration dosyamızdaki değişkenleri enjekte ediyor.
    private String queueName;
    /*
        queueName :
       - Exchange'lerden consumer'lara gönderilen mesajların tutulduğu arabellektir.
    */
    @Value("${sr.rabbit.routing.name}")
    private String routingName;
/*
    routingName :
   - Exchange kuyruklar arasındaki ilişkinin tanımıdır.
   - Exchange, tanımlanan binding kuralını takip ederek mesajı uygun olan kuyruğa verir.
*/

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;
    /*
        exchangeName :
       - Producer tarafından iletilen mesajın exchange type ,binding ve routing key bilgilerini kullanarak
        kuyruklara iletilmesini sağlar.
       - İletim aşamasından hangi kuyruklara ileteceğini karar veren yapılarada exchange type
        (Topic,Direct,Fanout,Header) denir.
    */
    @Autowired
    private RabbitTemplate rabbitTemplate; // Rabbit kuyruğuna gidip gelmek için kullanacağız.

    @Bean
    public Queue queue() {     // Kuyruk oluşturuyoruz.
        return new Queue(queueName);
    }

    @Bean
    public DirectExchange directExchange() {   // Bunlardan (Topic,Direct,Fanout,Header) direct olanı üretiyoruz.
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding binding(final Queue queue, final DirectExchange directExchange) { // Exchange ve queue birbirine bağlanmasını sağlıyor.
        return BindingBuilder.bind(queue).to(directExchange).with(routingName); //  queue , directExchange bağla. routingName ile yönet.
    }

}
