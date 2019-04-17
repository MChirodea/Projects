package controller;

import model.User;

public interface ILoginProvider {
    User login(String usern, String password);
}
