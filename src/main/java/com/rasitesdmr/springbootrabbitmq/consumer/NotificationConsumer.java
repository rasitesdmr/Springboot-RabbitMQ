package com.rasitesdmr.springbootrabbitmq.consumer;

import com.rasitesdmr.springbootrabbitmq.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    /*
    - Bu class kuyruktan (queue) bildirimleri (notification) dinliyor.

    - Bir mesaj geldiğinde RabbitListener tetiklensin.
    - queues = "rasitesdmr-queue" bu kuyruktan dinlesin
     */

    // TODO queues = "rasitesdmr-queue" elimizle yazmak yerine @PropertiesSource ile app.properties'den otomatik çek.
    @RabbitListener(queues = "rasitesdmr-queue")
    public void handleMessage(Notification notification) {  // Kuyruktan (queue) gelen mesajları dinliyoruz.
        System.out.println("Mesaj alındı");
        System.out.println(notification.toString()); // ALdığı notification'ları ekrana yazdırıyoruz.
    }
}
