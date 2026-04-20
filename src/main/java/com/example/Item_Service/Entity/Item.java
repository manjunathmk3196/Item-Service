package com.example.Item_Service.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Document
@Getter
@Setter
@Schema(description = "Item entity representing a product in the inventory")
public class Item {
    @Id
    @Schema(description = "Unique identifier for the item", example = "507f1f77bcf86cd799439011")
    private String id;

    @Schema(description = "Name of the item", example = "MacBook Pro 16", required = true)
    private String name;

    @Schema(description = "Detailed description of the item", example = "High-performance laptop with M3 Pro chip")
    private String description;

    @Schema(description = "Price of the item in USD", example = "2499.99", required = true)
    private double price;
}
