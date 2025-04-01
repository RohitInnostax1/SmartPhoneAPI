package com.springrest.springrest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SmartPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long iphone;
    private Long samsung;


    public SmartPhone() {}

   
    public SmartPhone(Long id, String name, Long iphone, Long samsung) {
        this.id = id;
        this.name = name;
        this.iphone = iphone;
        this.samsung = samsung;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getIphone() { return iphone; }
    public void setIphone(Long iphone) { this.iphone = iphone; }

    public Long getSamsung() { return samsung; }
    public void setSamsung(Long samsung) { this.samsung = samsung; }
}
