package model;
/**
 * Class that stores the product info.
 * @author mchir
 *
 */
public class Product {
	private int idProduct;
	private int price;
	private String name;
	private int stock;

	/**
	 * Constructor
	 * @param id
	 * @param price
	 * @param name
	 * @param stock
	 */
	public Product(int id, int price, String name, int stock){
		super();
		this.idProduct = id;
		this.name = name;
		this.stock = stock;
		this.price = price;
		
	}
	/**
	 * Constructor 2
	 * @param price
	 * @param name
	 * @param stock
	 */
	public Product(int price, String name, int stock){
		super();
		this.price = price;
		this.name = name;
		this.stock = stock;
	}
	
	/**
	 * Constructor 3
	 * @param id
	 * @param name
	 */
	public Product(int id, String name){
		super();
		this.name = name;
		this.idProduct = id;
		this.stock = 0;
	}
	/**
	 * Method that gets id
	 * @return
	 */
	public int getId() {
		return this.idProduct;
	}
	/**
	 * Method that sets the id.
	 * @param id
	 */
	public void setId(int id) {
		this.idProduct = id;
	}
	/**
	 * Method that gets the price
	 * @return price
	 */
	public int getPrice() {
		return this.price;
	}
	/**
	 * Method that sets the price.
	 * @param pr
	 */
	public void setPrice(int pr) {
		this.price = pr;;
	}
	/**
	 * Method that gets the name
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
    /**
     * Method that sets the name.
     * @param name
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method that gets the stock.
	 * @return stock.
	 */
	public int getStock() {
		return this.stock;
	}
	/**
	 * Method that sets the stock.
	 * @param stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

}
