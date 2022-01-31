package com.example.Some_Coffee_BackEnd.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {

        return productRepository.findAll();
    }

    public Product getProduct(String id) {
        Long productId = Long.parseLong(id);
        return productRepository.findById(productId).orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        Long productId = Long.parseLong(id);
        productRepository.deleteById(productId);
    }

    public void updateProduct(String id, Product data) {
        Long productId = Long.parseLong(id);
        Product product = productRepository.findById(productId).orElse(null);


        if (product != null) {
            product.setName(data.getName());
            product.setPrice(data.getPrice());
            product.setCost(data.getCost());
            product.setCategory(data.getCategory());
            productRepository.save(product);
        }
    }

}
