package controller;

import model.User;
import view.ILoginGUI;

public class LoginController {

    private final ILoginGUI loginView;
    private final ILoginProvider loginProvider;
    public LoginController(ILoginGUI loginView) {
        this.loginProvider = new LoginProvider();
        this.loginView= loginView;
    }

    public void login() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();

        User user = loginProvider.login(username,password);
        if(user == null){
            loginView.showErrorMessage("Error: Invalid username/password!");
            return;
        }
        if (user.getType().equals("Admin")){
            loginView.showAdminView((user.getId()));
             //DataAccess.getInstance().initializeDB();
        }
        else if (user.getType().equals("Normal"))
            loginView.showUserView(user.getId());
    }
}
