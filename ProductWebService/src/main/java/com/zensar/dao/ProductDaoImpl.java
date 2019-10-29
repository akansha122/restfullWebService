package com.zensar.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

/**
 * @author Akansha Shah
 * @Creation_date 4th Oct 2019 10.23AM
 * @Modification_date 4th Oct 2019 10.23AM
 * @version 1.0
 * @Copyright Zensar Technologies. All rights reserved
 * @description It is an dao class used in persistent layer.
 */
public class ProductDaoImpl implements ProductDao {
	private Session session;

	public ProductDaoImpl() {

		Configuration configuration = new Configuration().configure();
		SessionFactory factory = configuration.buildSessionFactory();
		session = factory.openSession();
	}

	@Override
	public List<Product> getAll() {
		return session.createQuery("From Product").getResultList();
	}

	@Override
	public Product getById(int productId) {
		return session.get(Product.class, productId);
	}

	@Override
	public void insert(Product product) {
		Transaction transaction1 = session.beginTransaction();
		session.save(product);
		transaction1.commit();

	}

	@Override
	public void update(Product product) {
		Transaction transaction2 = session.beginTransaction();
		session.update(product);
		transaction2.commit();
	}

	@Override
	public void delete(Product product) {
		Transaction transaction3 = session.beginTransaction();
		session.delete(product);
		transaction3.commit();
	}
}
