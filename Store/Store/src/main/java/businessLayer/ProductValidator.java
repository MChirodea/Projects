package businessLayer;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import businessLayer.validators.ProductPriceValidator;
import businessLayer.validators.Validator;

import dataAccessLayer.ProductDAO;
import model.Product;

/**
 * Class that Validates Product.
 * @author mchir
 *
 */
public class ProductValidator {

	private List<Validator<Product>> validators;

	public ProductValidator() {
		validators = new ArrayList<Validator<Product>>();
		validators.add(new ProductPriceValidator());
	}
	/**
	 * Method that validates before findbyID.
	 * @param id
	 * @return
	 */
	public Product findClientById(int id) {
		Product st = ProductDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The client with id =" + id + " was not found!");
		}
		return st;
	}
	/**
	 * Method that validates before insert.
	 * @param pr
	 * @return
	 */
	public int insertProduct(Product pr) {
		for (Validator<Product> v : validators) {
			v.validate(pr);
		}
		return ProductDAO.insert(pr);
	}
	/**
	 * Methods that validates before edit.
	 * @param pr
	 * @return
	 */
	public int editProduct(Product pr) {
		for (Validator<Product> v : validators) {
			v.validate(pr);
		}
		return ProductDAO.update(pr);
	}
}
