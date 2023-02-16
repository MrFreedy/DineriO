package com.dineriO.DineriO.repository;

import com.dineriO.DineriO.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository <Restaurant, Long> {

    List<Restaurant> findRestaurantByName(String name);

    List<Restaurant> findRestaurantByAddress(String address);

    List<Restaurant> findRestaurantByPhone(String phone);

    List<Restaurant> findRestaurantByRating(String rate);

    List<Restaurant> findRestaurantByNameAndAddressAndRating(String name, String address, String rate);

    List<Restaurant> findRestaurantByNameAndAddressAndPhoneAndRating(String name, String address, String phone, String rate);

    List<Restaurant> findRestaurantByNameAndAddressAndPhone(String name, String address, String phone);


    List<Restaurant> findRestaurantByNameAndPhoneAndRating(String name, String phone, String rate);

    List<Restaurant> findRestaurantByNameAndAddress(String name, String address);

    List<Restaurant> findRestaurantByNameAndPhone(String name, String phone);

    List<Restaurant> findRestaurantByNameAndRating(String name, String rate);

    List<Restaurant> findRestaurantByAddressAndPhoneAndRating(String address, String phone, String rate);

    List<Restaurant> findRestaurantByAddressAndPhone(String address, String phone);

    List<Restaurant> findRestaurantByAddressAndRating(String address, String rate);

    List<Restaurant> findRestaurantByPhoneAndRating(String phone, String rate);
}
