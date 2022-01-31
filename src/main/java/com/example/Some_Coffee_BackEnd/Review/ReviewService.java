package com.example.Some_Coffee_BackEnd.Review;

import com.example.Some_Coffee_BackEnd.Product.ProductRepository;
import com.example.Some_Coffee_BackEnd.User.User;
import com.example.Some_Coffee_BackEnd.User.UserRepository;
import com.example.Some_Coffee_BackEnd.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public Review getReview(String id) {
        Long reviewId = Long.parseLong(id);
        return reviewRepository.findById(reviewId).orElse(null);
    }

    public Review addReview(Review review, Long productId,  Long userId) {
        Product product = (Product) productRepository.findById(productId).orElse(null);
        review.setProduct(product);
        User user = (User) userRepository.findById(userId).orElse(null);
        review.setUser(user);
        return reviewRepository.save(review);
    }

    public void deleteReview(String id) {
        Long reviewId = Long.parseLong(id);
        reviewRepository.deleteById(reviewId);
    }

    public void updateReview(String id, Review data) {
        Long reviewId = Long.parseLong(id);
        Review review = reviewRepository.findById(reviewId).orElse(null);


        if (review != null) {
            review.setReviewDate(data.getReviewDate());
            review.setComment(data.getComment());
            review.setRate(data.getRate());

            reviewRepository.save(review);
        }

    }


}
