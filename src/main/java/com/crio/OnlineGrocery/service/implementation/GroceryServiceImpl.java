package com.crio.OnlineGrocery.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.OnlineGrocery.exception.ResourceNotFoundException;
import com.crio.OnlineGrocery.model.Grocery;
import com.crio.OnlineGrocery.repository.GroceryRepository;
import com.crio.OnlineGrocery.service.GroceryService;

@Service
public class GroceryServiceImpl implements GroceryService {

    @Autowired
    private GroceryRepository groceryRepository;

    @Override
    public List<Grocery> getAllGroceries() {
        return groceryRepository.findAll();
    }

    @Override
    public Grocery getGroceryById(Long id) {
        return groceryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grocery not found with id: " + id));
    }

    @Override
    public Grocery createGrocery(Grocery grocery) {
        return groceryRepository.save(grocery);
    }

    @Override
    public Grocery updateGrocery(Long id, Grocery groceryDetails) {
        Grocery grocery = getGroceryById(id);
        grocery.setName(groceryDetails.getName());
        grocery.setPrice(groceryDetails.getPrice());
        return groceryRepository.save(grocery);
    }

    @Override
    public void deleteGrocery(Long id) {
        Grocery grocery = getGroceryById(id);
        groceryRepository.delete(grocery);
    }
}