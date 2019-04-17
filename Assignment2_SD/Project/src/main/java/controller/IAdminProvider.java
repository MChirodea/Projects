package controller;

import model.Drug;
import model.User;

import java.util.List;

interface generalProvider{

    void create(Object obj);
    void delete(Object obj);
    void update(Object obj);


}

interface adminProvid{
     List<User> getUsers();
     List<Drug> getDrugs();


}

public interface IAdminProvider extends generalProvider, adminProvid {
}
