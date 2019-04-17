package model;
/**
 * Class in which an order is stored.
 * @author Mihai
 *
 */
public class Order {
	private int idClient;
	private int idProduct;
	private int idOrder;
	private int idStock;
	private int quantity;

/**
 * Constructor for Order
 * @param idOrder
 * @param idProduct
 * @param idStock
 * @param idClient
 * @param quantity
 */
	public Order(int idOrder, int idProduct, int idStock, int idClient, int quantity){
		super();
		this.idClient = idClient;
		this.idProduct = idProduct;
		this.idStock = idProduct;
		this.idOrder = idOrder;
		this.quantity = quantity;
	}
/**
 * Constructor 2	
 * @param idProduct
 * @param idClient
 * @param quantity
 */
public Order( int idProduct, int idClient, int quantity){
		this.quantity = quantity;
		this.idClient = idClient;
		this.idProduct = idProduct;
		this.idStock = idProduct;
	}
/**
 * Method that returns ID.
 * @return id
 */
public int getId() {
	return this.idClient;
}
/**
 * Method that sets id.
 * @param id
 */
public void setId(int id) {
	this.idClient = id;
}
/**
 * Method that gets the stock id.
 * @return
 */
public int getIdS() {
	return this.idStock;
}
/**
 * Method that sets the stock id.
 * @param id
 */
public void setIdS(int id) {
	this.idStock = id;
}
/**
 * Method that gets the id of the product.
 * @return id
 */
public int getIdP() {
	return this.idProduct;
}
/**
 * Method that returns the product id.
 * @param id
 */
public void setIdP(int id) {
	this.idProduct = id;
}
/**
 * Method that returns the order id
 * @return id
 */
public int getIdO() {
	return this.idOrder;
}
/**
 * Method that sets the order id.
 * @param id
 */
public void setIdO(int id) {
	this.idOrder = id;
}
/**
 * Method that returns the quantity.
 * @return quantity
 */
public int getQuantity() {
	return this.quantity;
}
/**
 * Method that sets the quantity.
 * @param q
 */
public void setQuantity(int q) {
	this.quantity = q;
}
}
