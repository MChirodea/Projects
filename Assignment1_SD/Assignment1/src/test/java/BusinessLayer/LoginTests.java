package BusinessLayer;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LoginTests {

    @Test
    @DisplayName("Succesfull Login")
    void testSLogin() {
        //try {
            //Statement st = DAO.getInstance().getCon().createStatement();
            //st.executeUpdate("drop table if exists users");
            //st.executeUpdate("create table users (id integer, user string, password string)");
            //st.executeUpdate("insert into users values(1, 'Mijai', '123')");
            Login creds = new Login();
            creds.setUser("Mijai");
            creds.setPassword("123");
            assertEquals(1,creds.login(), "login should be succesfull");
        //} catch (ClassNotFoundException e) {
        //    e.printStackTrace();
       // } catch (SQLException e) {
         //   e.printStackTrace();
        //}
    }

    @Test
    @DisplayName("Unsuccessful Login")
    void testUSLogin() {
        //try {
        //Statement st = DAO.getInstance().getCon().createStatement();
        //st.executeUpdate("drop table if exists users");
        //st.executeUpdate("create table users (id integer, user string, password string)");
        //st.executeUpdate("insert into users values(1, 'Mijai', '123')");
        Login creds = new Login();
        creds.setUser("Mijai11");
        creds.setPassword("123");
        assertEquals(0,creds.login(), "login should be not be successful");
        //} catch (ClassNotFoundException e) {
        //    e.printStackTrace();
        // } catch (SQLException e) {
        //   e.printStackTrace();
        //}
    }

}
