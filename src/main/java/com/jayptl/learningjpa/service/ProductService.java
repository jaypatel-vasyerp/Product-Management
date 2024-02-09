package com.jayptl.learningjpa.service;

import java.util.List;

import com.jayptl.learningjpa.dto.ProductDto;
import com.jayptl.learningjpa.model.Product;

public interface ProductService {

    Product addNewProduct(ProductDto product);

    Product getProductById(long id);

    List<Product> getAllProducts();

    Product updateProduct(ProductDto product);

    List<Product> getProductsByCategory(String category);

    String deleteProductById(long id);

}
