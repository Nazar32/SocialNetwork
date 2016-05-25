package Logic.Proxy;

import Logic.*;
import Logic.Iterator.Iterator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProxyManagmentSystem implements AbstractManagmentSystem {

    private ManagmentSystem ms;
    private static ProxyManagmentSystem instance;

    public static ProxyManagmentSystem getInstance() {

        if (instance == null)  {

            instance = new ProxyManagmentSystem();
        }

        return instance;
    }


    public ArrayList<News> getNews() throws SQLException {

        return ms.getNews();
    }

    public void sendMessage(Message message) throws SQLException {

        ms.getDataStore().getInstance().insertMessage(message);
    }

    public  ArrayList<Message> getMessages() {

        return ms.getMessages();
    }

    public void updateMessages() throws SQLException {

        ms.setMessages(ms.getDataStore().getMessages());
    }

    public void addNews(News news_) {

        ms.addNews(news_);
    }

    public void addMessage(Message message) {

        ms.addMessage(message);
    }

    public ProxyManagmentSystem() {

        if (ms == null) {

            ms = new ManagmentSystem();
        }
    }

    public List<City> getCities() {

        return ms.getCities();
    }

    public Collection<User> getUsers() {

        return ms.getUsers();
    }

    public Collection<User> getUsersFromCity(City city) throws SQLException {

        Collection<User> usersByCity = ms.getDataStore().getUsersByCity(city);

        return usersByCity;
    }

    public City getCityByName(String name) {

        City city = null;

        for (City city1 : ms.getCities()) {

            if (city1.getName().equals(name)) {

                city = city1;
            }
        }

        return city;
    }

    public void insertUser(User user) throws SQLException {

        ms.getDataStore().insertUser(user);
    }

    public void updateUser(User user) throws SQLException {

        ms.getDataStore().updateUser(user);

    }

    public void deleteUser(User user) throws SQLException {

        ms.getDataStore().deleteUser(user);

    }

    public  User getUserByEmail(String email) {

        User user = null;

        for (User storeUser : ms.getUsers()) {

            if (storeUser.getEmail().equals(email)) {

                user = storeUser;
            }
        }

        return user;
    }

    public void deleteMessage(Message message) throws SQLException {

        ms.getDataStore().deleteMessage(message);
    }




}
