package com.example.Item_Service.Service;

import com.example.Item_Service.Entity.Item;
import com.example.Item_Service.Repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    public List<Item> getAll() {
        return repository.findAll();
    }

    public Item getByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Item not found: " + name));
    }

    public Item save(Item item) {
        return repository.save(item);
    }

    public Item update(Long id, Item request) {
        Item existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found: " + id));

        existing.setName(request.getName());
        existing.setDescription(request.getDescription());
        existing.setPrice(request.getPrice());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}