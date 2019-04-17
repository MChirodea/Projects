package view;



interface loginProvider{
        String getUsername();
        String getPassword();
}

interface viewProvider{
        void showAdminView(Long logID);
        void showUserView(Long logID);
        void showErrorMessage(String message);
}
public interface ILoginGUI extends loginProvider, viewProvider   {
}
