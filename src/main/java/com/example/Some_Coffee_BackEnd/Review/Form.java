package com.example.Some_Coffee_BackEnd.Review;

public class Form {

    private Review review;
    private Long userId;
    private Long productId;

    public Form() {
    }

    public Form(Review review, Long userId, Long productId) {
        this.review = review;
        this.userId = userId;
        this.productId = productId;
    }

    public Review getReview() {
        return review;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProductId() {
        return productId;
    }

}
