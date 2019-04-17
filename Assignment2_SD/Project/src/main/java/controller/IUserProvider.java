package controller;

import model.*;

import java.util.List;

interface userProvid{
    int buy(Long logID,Long id, int ammount);
    List<Drug> getDRUGS();
    void report(Long logID, String drug, Integer amount);
}


public interface IUserProvider extends userProvid{}

