package com.example.Item_Service.Controller;

import com.example.Item_Service.Entity.Item;
import com.example.Item_Service.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @GetMapping
    public List<Item> getAll() {
        return service.getAll();
    }

    @GetMapping("/{name}")
    public Item getByName(@PathVariable String name) {
        return service.getByName(name);
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        return service.save(item);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable String id, @RequestBody Item item) {
        return service.update(id, item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
