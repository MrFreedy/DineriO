package com.dineriO.DineriO.controller;

import com.dineriO.DineriO.model.Restaurant;
import com.dineriO.DineriO.repository.DineriORepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DineriOController {
    private final DineriORepository dineriORepository;

    public DineriOController(final DineriORepository dineriORepository) {
        this.dineriORepository = dineriORepository;
    }

    @GetMapping("/restaurants")
    public Iterable<Restaurant> getRestaurants() {
        return dineriORepository.findAll();
    }

    @GetMapping("/restaurant/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable("id") int id) {
        return this.dineriORepository.findById(id);
    }

    @PostMapping("/restaurants")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant newRestaurant = this.dineriORepository.save(restaurant);
        return newRestaurant;
    }
    @PutMapping("/restaurant/{id}")
    public Restaurant updateRestaurant(@PathVariable(name = "id") int id, @RequestBody Restaurant restaurant){
        Optional<Restaurant> restaurantOptional = this.dineriORepository.findById(id);
        if(!restaurantOptional.isPresent()){
            return null;
        }

        Restaurant restaurantToUpdate = restaurantOptional.get();
        if(restaurant.getName()!=null){
            restaurantToUpdate.setName(restaurant.getName());
        }

        if(restaurant.getAddress()!=null){
            restaurantToUpdate.setAddress(restaurant.getAddress());
        }

        if(restaurant.getPhone()!=null){
            restaurantToUpdate.setPhone(restaurant.getPhone());
        }

        Restaurant updatedRestaurant = this.dineriORepository.save(restaurantToUpdate);
        return updatedRestaurant;

    }

    @DeleteMapping("/restaurant/{id}")
    public Restaurant deleteRestaurant(@PathVariable ("id") int id){
        Optional <Restaurant> restaurantOptional = this.dineriORepository.findById(id);
        if(!restaurantOptional.isPresent()){
            return null;
        }
        Restaurant restaurantToDelete = restaurantOptional.get();
        this.dineriORepository.delete(restaurantToDelete);
        return restaurantToDelete;
    }
}
