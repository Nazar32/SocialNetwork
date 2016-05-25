package DataBase;

import Logic.City;
import Logic.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AbstractUsersStore {

    public ArrayList<User> getUsers() throws SQLException;

    public ArrayList<User> getUsersByCity(City city) throws SQLException;

    public void insertUser(User user) throws SQLException;
    public void updateUser(User user) throws SQLException ;

    public void deleteUser(User user) throws SQLException ;
}
