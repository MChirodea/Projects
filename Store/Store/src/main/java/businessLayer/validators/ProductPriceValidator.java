package businessLayer.validators;

import model.Product;
/**
 * Class that validates the price of the product.
 * @author mchir
 *
 */
public class ProductPriceValidator implements Validator<Product> {
	private static final int MIN_PRICE = 1;
	private static final int MAX_PRICE = 99999;
	/**
	 * Method that validaes the price.
	 */
	public void validate(Product t) {

		if (t.getPrice() < MIN_PRICE || t.getPrice()> MAX_PRICE) {
			throw new IllegalArgumentException("The price range is not respected!");
		}

	}

}
