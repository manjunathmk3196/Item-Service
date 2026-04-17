package com.example.Item_Service.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private double price;
}
