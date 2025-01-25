package com.crio.OnlineGrocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.OnlineGrocery.model.Grocery;
import com.crio.OnlineGrocery.service.GroceryService;

@RestController
@RequestMapping("/api/grocery")

public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @GetMapping
    public List<Grocery> getAllGroceries() {
        return groceryService.getAllGroceries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grocery> getGroceryById(@PathVariable Long id) {
        Grocery grocery = groceryService.getGroceryById(id);
        return ResponseEntity.ok(grocery);
    }

    @PostMapping
    public Grocery createGrocery(@RequestBody Grocery groceryDetails) {
        return groceryService.createGrocery(groceryDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grocery> updateGrocery(@PathVariable Long id, @RequestBody Grocery groceryDetails) {
        Grocery updatedgrocery = groceryService.updateGrocery(id,groceryDetails);
        return ResponseEntity.ok(updatedgrocery);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrocery(@PathVariable Long id) {
        groceryService.deleteGrocery(id);
        return ResponseEntity.ok().build();
    }
    
}



