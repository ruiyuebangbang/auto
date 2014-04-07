package com.autoboys.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.autoboys.domain.*;

public class ProductDAOImpl implements ProductDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	/**
	 * Used to save or update a product.
	 */
	public void saveOrUpdateProduct(Product product) {
		try {
			session.saveOrUpdate(product);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a product.
	 */
	
	public void deleteProduct(Long productId) {
		try {
			Product product = (Product) session.get(Product.class, productId);
			session.delete(product);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the products.
	 */
	@SuppressWarnings("unchecked")
	public List<Product> listProduct() {
		List<Product> courses = null;
		try {
			courses = session.createQuery("from Product").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * Used to list a single product by Id.
	 */
	
	public Product listProductById(Long productId) {
		Product product = null;
		try {
			product = (Product) session.get(Product.class, productId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

}
