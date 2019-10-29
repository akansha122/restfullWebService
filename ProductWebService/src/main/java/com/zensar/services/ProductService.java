package com.zensar.services;

import java.util.List;

import com.zensar.entities.Product;

/**
 * @author Akansha Shah
 * @Creation_date 4th Oct 2019 10.23AM
 * @Modification_date 4th Oct 2019 11.38AM
 * @version 1.0
 * @Copyright Zensar Technologies. All rights reserved
 * @description It is an service interface used in business layer.
 */
public interface ProductService {

	List<Product> findAllProducts();
    Product findProductById(int productId);
    void addProduct(Product product);
    void updateProduct(Product product);
    void removeProduct(Product product);
    List<Product> findProductsByPriceRange(float minPrice, float maxPrice);
    List<Product> findProductByName(String productName);
    List<Product> findProductByBrand(String brand);
    long getProductCount();
}
