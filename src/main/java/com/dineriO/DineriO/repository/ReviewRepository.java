package com.dineriO.DineriO.repository;

import com.dineriO.DineriO.model.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository <Review, Long> {
    List<Review> findReviewByCustomerUsername(String username);

    List<Review> findReviewByCommentary(String commentary);
    List<Review> findReviewByRate(String rate);


    List<Review> findReviewByCustomerUsernameAndCommentaryAndRateAndRestaurant(String username, String commentary, String rate, String restaurant);

    List<Review> findReviewByCustomerUsernameAndCommentaryAndRate(String username, String commentary, String rate);

    List<Review> findReviewByCustomerUsernameAndCommentaryAndRestaurant(String username, String commentary, String restaurant);

    List<Review> findReviewByCustomerUsernameAndCommentary(String username, String commentary);

    List<Review> findReviewByCustomerUsernameAndRateAndRestaurant(String username, String rate, String restaurant);

    List<Review> findReviewByCustomerUsernameAndRate(String username, String rate);

    List<Review> findReviewByCustomerUsernameAndRestaurant(String username, String restaurant);

    List<Review> findReviewByCommentaryAndRateAndRestaurant(String commentary, String rate, String restaurant);

    List<Review> findReviewByCommentaryAndRate(String commentary, String rate);

    List<Review> findReviewByCommentaryAndRestaurant(String commentary, String restaurant);

    List<Review> findReviewByRateAndRestaurant(String rate, String restaurant);

    List<Review> findReviewByRestaurant(String restaurant);

}
