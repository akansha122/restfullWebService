package com.zensar.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import com.zensar.dao.ProductDao;
import com.zensar.dao.ProductDaoImpl;
import com.zensar.entities.Product;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	public ProductServiceImpl() {

		productDao = new ProductDaoImpl();
	}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAll();
	}

	@Override
	public Product findProductById(int productId) {
		// TODO Auto-generated method stub
		return productDao.getById(productId);
	}

	@Override
	public void addProduct(Product product) {
		productDao.insert(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
	}

	@Override
	public void removeProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.delete(product);
	}

	@Override
	public List<Product> findProductsByPriceRange(float minPrice, float maxPrice) {

		List<Product> products = productDao.getAll();
		List<Product> product1 = new ArrayList();
		for (Product product : products) {
			if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
				product1.add(product);
			}
		}
		return product1;
	}

	@Override
	public List<Product> findProductByName(String productName) {
		// TODO Auto-generated method stub
		List<Product> products = productDao.getAll();
		List<Product> product1 = new ArrayList();
		for (Product product : products) {
			if (product.getName().equals(productName)) {
				product1.add(product);
			}
		}

		return product1;
	}

	@Override
	public List<Product> findProductByBrand(String brand) {
		// TODO Auto-generated method stub
		List<Product> products = productDao.getAll();
		List<Product> product1 = new ArrayList();
		for (Product product : products) {
			if (product.getName().equals(brand)) {
				product1.add(product);
			}
		}

		return product1;
	}

	@Override
	public long getProductCount() {

		return findAllProducts().size();
	}

}
