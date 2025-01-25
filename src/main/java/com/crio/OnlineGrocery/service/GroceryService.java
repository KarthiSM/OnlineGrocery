package com.crio.OnlineGrocery.service;

import java.util.List;

import com.crio.OnlineGrocery.model.Grocery;

public interface GroceryService {
    List<Grocery> getAllGroceries();
    Grocery getGroceryById(Long id);
    Grocery createGrocery(Grocery grocery);
    Grocery updateGrocery(Long id, Grocery groceryDetails);
    void deleteGrocery(Long id);
}
