package Logic;

import DataBase.DataStore;
import Logic.Iterator.Container;
import Logic.Iterator.Iterator;
import Logic.Proxy.AbstractManagmentSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ManagmentSystem implements Container, AbstractManagmentSystem {

    private static List<City> cities;
    private static Collection<User> users;
    private static final DataStore dataStore = DataStore.getInstance();
    //private static ManagmentSystem ourInstance;
    private static ArrayList<Message> messages = new ArrayList<>();
    private static ArrayList<News> news = new ArrayList<>();

    public ArrayList<News> getNews() throws SQLException {

        return news;
    }

    public void sendMessage(Message message) throws SQLException {

        dataStore.getInstance().insertMessage(message);
    }

    public  ArrayList<Message> getMessages() {

        return messages;
    }

    public void updateMessages() throws SQLException {

        messages = dataStore.getMessages();
    }

    public void addNews(News news_) {

        news.add(news_);
    }

    public void addMessage(Message message) {

        messages.add(message);
    }

    public ManagmentSystem() {

        try {

            users = dataStore.getUsers();
            cities = dataStore.getCities();
            messages = dataStore.getMessages();
            news = dataStore.getNews();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<City> getCities() {

        return cities;
    }

    public Collection<User> getUsers() {

        return users;
    }

    public Collection<User> getUsersFromCity(City city) throws SQLException {

        Collection<User> usersByCity = dataStore.getUsersByCity(city);

        return usersByCity;
    }

    public City getCityByName(String name) {

        City city = null;

        for (City city1 : cities) {

            if (city1.getName().equals(name)) {

                city = city1;
            }
        }

        return city;
    }

    public void insertUser(User user) throws SQLException {

        dataStore.insertUser(user);
    }

    public void updateUser(User user) throws SQLException {

        dataStore.updateUser(user);

    }

    public void deleteUser(User user) throws SQLException {

        dataStore.deleteUser(user);

    }

    public  User getUserByEmail(String email) {

        User user = null;

        for (User storeUser : users) {

            if (storeUser.getEmail().equals(email)) {

                user = storeUser;
            }
        }

        return user;
    }

    public void deleteMessage(Message message) throws SQLException {

        dataStore.deleteMessage(message);
    }

    @Override
    public Iterator getIterator() {

        return new UserIterator();
    }

    public User getUserByIndex(int index) {

        int count = 0;
        Iterator iterator = getIterator();

        while (count++ < index) {

            iterator.next();
        }

        return ((User) iterator.next());
    }


    public static void main(String[] args) throws SQLException {


    }


    public static class UserIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {

            return index < users.size();
        }

        @Override
        public Object next() {

            if (hasNext()) {

               return users.toArray()[index++];
            }

            return null;
        }
    }


    public static DataStore getDataStore() {
        return dataStore;
    }

    public static void setCities(List<City> cities) {
        ManagmentSystem.cities = cities;
    }

    public static void setUsers(Collection<User> users) {
        ManagmentSystem.users = users;
    }

    public static void setMessages(ArrayList<Message> messages) {
        ManagmentSystem.messages = messages;
    }

    public static void setNews(ArrayList<News> news) {
        ManagmentSystem.news = news;
    }
}
