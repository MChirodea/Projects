package businessLayer.validators;
import java.util.regex.Pattern;

import model.Client;
/**
 * Class that validates phone number.
 * @author mchir
 *
 */
 public class ClientPhoneValidator implements Validator<Client> {
	 private static final String PHONE_PATTERN= "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
	 /**
	  * Method that validates if phone is valid format.
	  */
	public void validate(Client t) {
		Pattern pattern = Pattern.compile(PHONE_PATTERN);
		if (!pattern.matcher(t.getPhone()).matches()) {
			throw new IllegalArgumentException("Phone is not a valid phone!");

	}

}
}