package businessLayer.validators;
/**
 * Abstract Class
 * @author mchir
 *
 * @param <T>
 */
public interface Validator<T> {
	/**
	 * Abstract method.
	 * @param t
	 */
	public void validate(T t);
}
