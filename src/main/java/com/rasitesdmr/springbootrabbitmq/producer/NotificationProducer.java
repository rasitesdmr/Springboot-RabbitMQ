package com.rasitesdmr.springbootrabbitmq.producer;

import com.rasitesdmr.springbootrabbitmq.model.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /*
       - Bu class'da kuyruğa sürekli yazılacak veriyi gönderme işlemini yapacak.
       - Mesajı oluşturan, gönderen ve sağlayan taraftır.
       - Prodecur sadece gerektiğninde çalışır.
     */

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate;  // Sunucuya bunun üzerinden gidiyoruz.


    public void sendToQueue(Notification notification) {    // Bu metot aldığı bildirimi (notification) kuyruğa (queue) atacak.
        logger.info("Gönderilen bildirimin ID : " + notification.getId());
        logger.info("Mesaj : " + notification.getMessage());
        rabbitTemplate.convertAndSend(exchangeName, routingName, notification);  // convertAndSend : Objeyi donüştür ve gönder.
    }

    @PostConstruct
    public void init() {

        Notification notification1 = new Notification();        // Notification nesnesi yaratalım.
        notification1.setId(UUID.randomUUID().toString()); // random id üretsin.
        notification1.setCrateAt(new Date());
        notification1.setMessage("Lütfen öğrenmekten vazgeçmeyin.");
        notification1.setSeen(Boolean.FALSE);
        sendToQueue(notification1);

        Notification notification2 = new Notification();
        notification2.setId(UUID.randomUUID().toString());
        notification2.setCrateAt(new Date());
        notification2.setMessage("notification2");
        notification2.setSeen(Boolean.FALSE);
        sendToQueue(notification2);

        Notification notification3 = new Notification();
        notification3.setId(UUID.randomUUID().toString());
        notification3.setCrateAt(new Date());
        notification3.setMessage("notification3");
        notification3.setSeen(Boolean.FALSE);
        sendToQueue(notification3);


    }

}
