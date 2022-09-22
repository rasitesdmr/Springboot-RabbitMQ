package com.rasitesdmr.springbootrabbitmq.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class Notification implements Serializable {
    /*
        Serializable :
        - Bir nesnenin durumunu bir bayt akışına yazma mekanizmasıdır.
        - Platformdan bağımsızdır.
    */
    private String id;        // Bildirimin id'si.
    private Date crateAt;   // Oluşturma tarihi.
    private Boolean seen;   // Görüldüyse : true , Görülmediyse : false.
    private String message; // mesajın kendisi.


    /*

    Bu class'da bir bildirimi (notification) kuyruğa (queue) atacağız.

    */

}
