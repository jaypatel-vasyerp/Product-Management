package com.jayptl.learningjpa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayptl.learningjpa.dto.ProductDto;
import com.jayptl.learningjpa.exception.EntityNotFoundException;
import com.jayptl.learningjpa.model.Category;
import com.jayptl.learningjpa.model.Product;
import com.jayptl.learningjpa.repository.CategoryRepository;
import com.jayptl.learningjpa.repository.ProductRepository;
import com.jayptl.learningjpa.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product addNewProduct(ProductDto productDto) {
        Product product = new Product();
        Category category = new Category();

        if (productRepository.existsById(productDto.getId())) {
            updateProduct(productDto);
        }

        product.setProductName(productDto.getProductName());
        product.setProductDescription(productDto.getProductDescription());
        product.setPrice(productDto.getPrice());

        if (!categoryRepository.findCategoryByCategoryName(productDto.getCategory()).isEmpty()) {
            category = categoryRepository.findCategoryByCategoryName(productDto.getCategory()).get();
        }

        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " not exists"));
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(ProductDto product) {
        Product updatedProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new EntityNotFoundException("Product with id " + product.getId() + " not exists"));
        Category category = new Category();

        if (product.getProductName() != null && !product.getProductName().isEmpty()) {
            updatedProduct.setProductName(product.getProductName());
        }

        if (product.getProductDescription() != null && !product.getProductDescription().isEmpty()) {
            updatedProduct.setProductDescription(product.getProductDescription());
        }

        if (product.getPrice() != 0) {
            updatedProduct.setPrice(product.getPrice());
        }

        if (product.getCategory() != "") {
            if (!categoryRepository.findCategoryByCategoryName(product.getCategory()).isEmpty()) {
                category = categoryRepository.findCategoryByCategoryName(product.getCategory()).get();
            }
        }
        updatedProduct.setCategory(category);
        return productRepository.save(updatedProduct);
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        List<Product> products = new ArrayList<Product>();

        if (categoryName != null && !categoryName.isEmpty()) {
            Category category = categoryRepository.findCategoryByCategoryName(categoryName)
                    .orElseThrow(
                            () -> new EntityNotFoundException("Category with name: " + categoryName + " not exists"));
            products = productRepository.getProductsByCategoryId(category.getId());
        }
        return products;
    }

    @Override
    public String deleteProductById(long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "Deleted";
        }
        throw new EntityNotFoundException("Product with id " + id + " not exists.");
    }

}
