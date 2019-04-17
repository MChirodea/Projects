package controller;

import org.junit.jupiter.api.Test;
import view.ILoginGUI;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginControllerTests {
    @Test
    public void givenAdminUsernameAndPassword_login_showAdminView() {
        ILoginGUI loginView = mock(ILoginGUI.class);
        when(loginView.getUsername()).thenReturn("admin");
        when(loginView.getPassword()).thenReturn("admin");

        LoginController controller = new LoginController(loginView);

        controller.login();

        verify(loginView).showAdminView(new Long(6));
    }

    @Test
    public void givenRegularUsernameAndPassword_login_showRegularView() {
        ILoginGUI loginView = mock(ILoginGUI.class);
        when(loginView.getUsername()).thenReturn("user");
        when(loginView.getPassword()).thenReturn("user");

        LoginController controller = new LoginController(loginView);

        controller.login();

        verify(loginView).showUserView(new Long(5));
    }

    @Test
    public void givenInvalidUsernameAndPassword_login_showErrorMessage() {
        ILoginGUI loginView = mock(ILoginGUI.class);
        when(loginView.getUsername()).thenReturn("notanusername");
        when(loginView.getPassword()).thenReturn("nope");

        LoginController controller = new LoginController(loginView);

        controller.login();

        verify(loginView).showErrorMessage("Error: Invalid username/password!");
    }

    @Test
    public void givenInvalidUsernameAndPassword_login_showErrorMessage2() {
        TestLoginView loginView = new TestLoginView("notanusername", "nope");

        LoginController controller = new LoginController( loginView);

        controller.login();

        assertEquals(loginView.shownErrorMessage, "Error: Invalid username/password!");
    }

    class TestLoginView implements ILoginGUI
    {
        private final String username;
        private final String password;

        TestLoginView(String username, String password)
        {
            this.username = username;
            this.password = password;
        }
        @Override
        public void showAdminView(Long logID) {

        }

        @Override
        public void showUserView(Long logID) {

        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public String getPassword() {
            return password;
        }

        public String shownErrorMessage;
        @Override
        public void showErrorMessage(String message) {
            shownErrorMessage = message;
        }
    }
}
