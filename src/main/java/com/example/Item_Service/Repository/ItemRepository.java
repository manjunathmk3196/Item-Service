package com.example.Item_Service.Repository;

import com.example.Item_Service.Entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ItemRepository extends MongoRepository<Item, String> {
    Optional<Item> findByName(String name);
}