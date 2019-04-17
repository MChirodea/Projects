package model;
/**
 * Class in which Client data is stored.
 * @author Mihai
 *@version
 *
 */
public class Client {
		private int idClient;
		private String name;
		private String email;
		private String phoneNr;
		private String address;
	/**
	 * Constructor for class
	 * @see Client	
	 * @param id
	 * @param name
	 * @param email
	 * @param phoneNr
	 * @param address
	 * 
	 */
		public Client(int id, String name, String email, String phoneNr,String address){
			super();
			this.idClient = id;
			this.name = name;
			this.email = email;
			this.phoneNr = phoneNr;
			this.address = address;
		}
		/**
		 * Constructor 2
		 * @see Client
		 * @param name
		 * @param email
		 * @param phoneNr
		 * @param address
		 */
		public Client(String name, String email, String phoneNr,String address){
			super();
			this.name = name;
			this.email = email;
			this.phoneNr = phoneNr;
			this.address = address;
		}
		/**
		 * Method which returns the client id.
		 * @param none 
		 * @return client
		 */
		public int getId() {
			return this.idClient;
		}

		/**
		 * Method that returns the name of the client.
		 * @param none
		 * @return name
		 */
		public String getName() {
			return this.name;
		}
		/**
		 * Method that returns the email.
		 * @param none
		 * @return
		 */
		public String getEmail() {
			return this.email;
		}
		/**
		 * Method that returns the phone.
		 * @param none
		 * @return phone
		 */
		public String getPhone() {
			return this.phoneNr;
		}
		
		/**
		 * Method that returns the adress
		 * @param none
		 * @return address
		 */
		public String getAddress() {
			return this.address;
		}
		/**
		 * Method that sets the email.
		 * @param email
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		/**Method that sets the id.
		 * @param id
		 */
		public void setId(int id) {
			this.idClient = id;
		}
		/**
		 * Method that sets the name.
		 * @param name
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * Method that sets address.
		 * @param address
		 */
		public void setAddress(String address) {
			this.address = address;
		}
		/**
		 * Method that sets phone.
		 * @param phoneNr
		 */
		public void setPhone(String phoneNr) {
			this.phoneNr = phoneNr;
		}


}
