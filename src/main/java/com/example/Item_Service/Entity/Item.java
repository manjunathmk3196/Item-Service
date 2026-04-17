package com.example.Item_Service.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Document
@Getter
@Setter
public class Item {
    @Id
    private String id;

    private String name;

    private String description;
    private double price;
}
