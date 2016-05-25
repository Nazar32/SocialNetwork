package Logic.Proxy;

import Logic.City;
import Logic.Message;
import Logic.News;
import Logic.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

 public interface AbstractManagmentSystem {

     ArrayList<News> getNews() throws SQLException ;

     void sendMessage(Message message) throws SQLException ;

     ArrayList<Message> getMessages();

     void updateMessages() throws SQLException ;

     void addNews(News news_) ;

     void addMessage(Message message) ;
    
     List<City> getCities() ;

     Collection<User> getUsers() ;

     Collection<User> getUsersFromCity(City city) throws SQLException;

     City getCityByName(String name) ;

     void insertUser(User user) throws SQLException ;

     void updateUser(User user) throws SQLException ;

     void deleteUser(User user) throws SQLException ;

      User getUserByEmail(String email) ;

     void deleteMessage(Message message) throws SQLException ;
}
