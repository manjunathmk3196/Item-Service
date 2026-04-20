package com.example.Item_Service.Controller;

import com.example.Item_Service.Entity.Item;
import com.example.Item_Service.Service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
@Tag(name = "Item Management", description = "APIs for managing items in the inventory")
public class ItemController {

    private final ItemService service;

    @GetMapping
    @Operation(summary = "Get all items", description = "Retrieve a list of all items in the inventory")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved all items"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<Item> getAll() {
        return service.getAll();
    }

    @GetMapping("/{name}")
    @Operation(summary = "Get item by name", description = "Retrieve a specific item by its name")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the item"),
        @ApiResponse(responseCode = "404", description = "Item not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public Item getByName(@PathVariable String name) {
        return service.getByName(name);
    }

    @PostMapping
    @Operation(summary = "Create new item", description = "Add a new item to the inventory")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Item created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request data"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public Item create(@RequestBody Item item) {
        return service.save(item);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update item", description = "Update an existing item by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Item updated successfully"),
        @ApiResponse(responseCode = "404", description = "Item not found"),
        @ApiResponse(responseCode = "400", description = "Invalid request data"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public Item update(@PathVariable String id, @RequestBody Item item) {
        return service.update(id, item);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete item", description = "Remove an item from the inventory by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Item deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Item not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public void delete(@PathVariable String id) {
        service.delete(id);
    }


}
