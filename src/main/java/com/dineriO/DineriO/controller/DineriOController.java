package com.dineriO.DineriO.controller;

import com.dineriO.DineriO.model.Customer;
import com.dineriO.DineriO.model.Restaurant;
import com.dineriO.DineriO.model.Review;
import com.dineriO.DineriO.repository.CustomerRepository;
import com.dineriO.DineriO.repository.RestaurantRepository;
import com.dineriO.DineriO.repository.ReviewRepository;
import java.util.Collections;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class DineriOController {
    private final RestaurantRepository restaurantRepository;
    private final CustomerRepository customerRepository;

    private final ReviewRepository reviewRepository;
    public DineriOController(final RestaurantRepository restaurantRepository, final CustomerRepository customerRepository, final ReviewRepository reviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.customerRepository = customerRepository;
        this.reviewRepository = reviewRepository;
    }

    /*
     *
     * RESTAURANT PART
     *
     */
    @GetMapping("/restaurants")
    public Iterable<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/restaurant/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable("id") long id) {
        return this.restaurantRepository.findById(id);
    }

    @GetMapping("/restaurants/search")
    public List<Restaurant> searchRestaurants(@RequestParam(required = false)String name, @RequestParam(required = false) String address, @RequestParam(required = false) String phone, @RequestParam(required = false) String rate){

        if(Objects.nonNull(name)){
            if (Objects.nonNull(address) && Objects.nonNull(phone) && Objects.nonNull(rate)){
                return this.restaurantRepository.findRestaurantByNameAndAddressAndPhoneAndRating(name, address, phone, rate);
            }
            else if (Objects.nonNull(address) && Objects.nonNull(phone)){
                return this.restaurantRepository.findRestaurantByNameAndAddressAndPhone(name, address, phone);
            }
            else if (Objects.nonNull(address) && Objects.nonNull(rate)){
                return this.restaurantRepository.findRestaurantByNameAndAddressAndRating(name, address, rate);
            }
            else if (Objects.nonNull(phone) && Objects.nonNull(rate)){
                return this.restaurantRepository.findRestaurantByNameAndPhoneAndRating(name, phone, rate);
            }
            else if (Objects.nonNull(address)){
                return this.restaurantRepository.findRestaurantByNameAndAddress(name, address);
            }
            else if (Objects.nonNull(phone)){
                return this.restaurantRepository.findRestaurantByNameAndPhone(name, phone);
            }
            else if (Objects.nonNull(rate)){
                return this.restaurantRepository.findRestaurantByNameAndRating(name, rate);
            }
            else {
                return this.restaurantRepository.findRestaurantByName(name);
            }
        }else if (Objects.nonNull(address)){
            if (Objects.nonNull(phone) && Objects.nonNull(rate)){
                return this.restaurantRepository.findRestaurantByAddressAndPhoneAndRating(address, phone, rate);
            }
            else if (Objects.nonNull(phone)){
                return this.restaurantRepository.findRestaurantByAddressAndPhone(address, phone);
            }
            else if (Objects.nonNull(rate)){
                return this.restaurantRepository.findRestaurantByAddressAndRating(address, rate);
            }
            else {
                return this.restaurantRepository.findRestaurantByAddress(address);
            }
        } else if (Objects.nonNull(phone)){
            if (Objects.nonNull(rate)){
                return this.restaurantRepository.findRestaurantByPhoneAndRating(phone, rate);
            }
            else {
                return this.restaurantRepository.findRestaurantByPhone(phone);
            }
        } else if (Objects.nonNull(rate)){
            return this.restaurantRepository.findRestaurantByRating(rate);
        }else {
            return Collections.emptyList();
        }
    }

    @PostMapping("/restaurants")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return this.restaurantRepository.save(restaurant);
    }
    @PutMapping("/restaurant/{id}")
    public Restaurant updateRestaurant(@PathVariable(name = "id") long id, @RequestBody Restaurant restaurant){
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findById(id);
        if(restaurantOptional.isEmpty()){
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

        if(restaurant.getRating()!=null){
            restaurantToUpdate.setRating(restaurant.getRating());
        }

        return this.restaurantRepository.save(restaurantToUpdate);

    }

    @DeleteMapping("/restaurant/{id}")
    public Restaurant deleteRestaurant(@PathVariable ("id") long id){
        Optional <Restaurant> restaurantOptional = this.restaurantRepository.findById(id);
        if(restaurantOptional.isEmpty()){
            return null;
        }
        Restaurant restaurantToDelete = restaurantOptional.get();
        this.restaurantRepository.delete(restaurantToDelete);
        return restaurantToDelete;
    }

    /*
     *
     * CUSTOMER PART
     *
     */

    @GetMapping("/customers")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomerById(@PathVariable("id")long id){
        return this.customerRepository.findById(id);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer){
        return this.customerRepository.save(customer);
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable("id")long id, @RequestBody Customer customer){
        Optional<Customer> customerOptional = this.customerRepository.findById(id);

        if(customerOptional.isEmpty()){
            return null;
        }
        Customer customerToUpdate = customerOptional.get();

        if(customer.getId()!=null){
            customerToUpdate.setId(customer.getId());
        }

        if(customer.getUsername()!=null){
            customerToUpdate.setUsername(customer.getUsername());
        }

        if(customer.getCity()!=null){
            customerToUpdate.setCity(customer.getCity());
        }

        if(customer.getState()!=null){
            customerToUpdate.setState(customer.getState());
        }

        if(customer.getZip()!=null){
            customerToUpdate.setZip(customer.getZip());
        }

        if(customer.isHasEggAllergies()!=customerOptional.get().isHasEggAllergies()){
            customerToUpdate.setHasEggAllergies(customer.isHasEggAllergies());
        }

        if(customer.isHasPeanutAllergies()!=customerOptional.get().isHasPeanutAllergies()){
            customerToUpdate.setHasPeanutAllergies(customer.isHasPeanutAllergies());
        }

        if(customer.isHasDairyAllergies()!=customerOptional.get().isHasDairyAllergies()){
            customerToUpdate.setHasDairyAllergies(customer.isHasDairyAllergies());
        }
        return this.customerRepository.save(customerToUpdate);
    }

    @DeleteMapping("/customer/{id}")
    public Customer deleteCustomer(@PathVariable("id") long id){
        Optional <Customer> customerOptional = this.customerRepository.findById(id);
        if(customerOptional.isEmpty()){
            return null;
        }
        Customer customerToDelete = customerOptional.get();
        this.customerRepository.delete(customerToDelete);
        return customerToDelete;
    }


    /*
     *
     * REVIEW PART
     *
     */

    @GetMapping("/reviews")
    public Iterable<Review> getReviews(){
        return this.reviewRepository.findAll();
    }

    @GetMapping("/review/{id}")
    public Optional<Review> getReviewById(@PathVariable("id")long id){
        return  this.reviewRepository.findById(id);
    }

    @PostMapping("/reviews")
    public Review createReview(@RequestBody Review review){
        return this.reviewRepository.save(review);
    }

    @GetMapping("/reviews/search")
    public List<Review> searchReviews(@RequestParam(required = false)String username, @RequestParam(required = false) String commentary, @RequestParam(required = false) String rate, @RequestParam(required = false) String restaurant){
        if(Objects.nonNull(username)){
            if(Objects.nonNull(commentary)){
                if(Objects.nonNull(rate)){
                    if(Objects.nonNull(restaurant)){
                        return this.reviewRepository.findReviewByCustomerUsernameAndCommentaryAndRateAndRestaurant(username, commentary, rate, restaurant);
                    }
                    else {
                        return this.reviewRepository.findReviewByCustomerUsernameAndCommentaryAndRate(username, commentary, rate);
                    }
                }
                else if(Objects.nonNull(restaurant)){
                    return this.reviewRepository.findReviewByCustomerUsernameAndCommentaryAndRestaurant(username, commentary, restaurant);
                }
                else {
                    return this.reviewRepository.findReviewByCustomerUsernameAndCommentary(username, commentary);
                }
            }
            else if(Objects.nonNull(rate)){
                if(Objects.nonNull(restaurant)){
                    return this.reviewRepository.findReviewByCustomerUsernameAndRateAndRestaurant(username, rate, restaurant);
                }
                else {
                    return this.reviewRepository.findReviewByCustomerUsernameAndRate(username, rate);
                }
            }
            else if(Objects.nonNull(restaurant)){
                return this.reviewRepository.findReviewByCustomerUsernameAndRestaurant(username, restaurant);
            }
            else {
                return this.reviewRepository.findReviewByCustomerUsername(username);
            }
        }
        else if(Objects.nonNull(commentary)){
            if(Objects.nonNull(rate)){
                if(Objects.nonNull(restaurant)){
                    return this.reviewRepository.findReviewByCommentaryAndRateAndRestaurant(commentary, rate, restaurant);
                }
                else {
                    return this.reviewRepository.findReviewByCommentaryAndRate(commentary, rate);
                }
            }
            else if(Objects.nonNull(restaurant)){
                return this.reviewRepository.findReviewByCommentaryAndRestaurant(commentary, restaurant);
            }
            else {
                return this.reviewRepository.findReviewByCommentary(commentary);
            }
        }
        else if(Objects.nonNull(rate)){
            if(Objects.nonNull(restaurant)){
                return this.reviewRepository.findReviewByRateAndRestaurant(rate, restaurant);
            }
            else {
                return this.reviewRepository.findReviewByRate(rate);
            }
        }
        else if(Objects.nonNull(restaurant)){
            return this.reviewRepository.findReviewByRestaurant(restaurant);
        }
        else {
            return Collections.emptyList();
        }
    }

    @PutMapping("/review/{id}")
    public Review updateReview(@PathVariable("id")long id, @RequestBody Review review){
        Optional<Review> reviewOptional = this.reviewRepository.findById(id);

        if(reviewOptional.isEmpty()){
            return null;
        }

        Review reviewToUpdate = reviewOptional.get();

        if(review.getCustomerUsername()!=null){
            reviewToUpdate.setCustomerUsername(review.getCustomerUsername());
        }

        if(review.getCommentary()!=null){
            reviewToUpdate.setCommentary(reviewToUpdate.getCommentary());
        }

        if(review.getRate()!=null){
            reviewToUpdate.setRate(reviewToUpdate.getRate());
        }
        if(review.getRestaurant()!=null){
            reviewToUpdate.setRestaurant(reviewToUpdate.getRestaurant());
        }
        return this.reviewRepository.save(reviewToUpdate);
    }

    @DeleteMapping("/review/{id}")
    public Review deleteReview(@PathVariable("id")long id){
        Optional<Review> reviewOptional = this.reviewRepository.findById(id);
        if(reviewOptional.isEmpty()){
            return null;
        }
        Review reviewToDelete = reviewOptional.get();
        this.reviewRepository.delete(reviewToDelete);
        return reviewToDelete;
    }
}
