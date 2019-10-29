package com.zensar.dao;

import java.util.List;

import com.zensar.entities.Product;

/**
 * @author Akansha Shah
 * @Creation_date 4th oct 2019 9.56AM
 * @Modification_date 4th oct 2019 9.56AM
 * @version 1.0
 * @Copyright Zensar Technologies. All rights reserved
 * @description It is an dao interface used in persistent layer.
 */
public interface ProductDao {

	List<Product> getAll();
	Product getById(int productId);
	void insert(Product product);
	void update(Product product);
	void delete(Product product);
    
}
