package DataBase;

import Logic.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import res.R;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataStore implements AbstractCitiesStore, AbstractMessagesStore, AbstractUsersStore, AbstractNewsStore{


    private  Connection connection;
    private static DataStore ourInstance;
    public  static DataStore getInstance()  {

        try {
            if (ourInstance == null)
                ourInstance = new DataStore();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ourInstance;
    }

    private DataStore() throws Exception {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/social_network";
            connection = (Connection) DriverManager.getConnection(url, "root", "root");
        }

        catch (ClassNotFoundException e) {
            throw new Exception(e);
        }

        catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public ArrayList<City> getCities() throws SQLException {

        ArrayList<City> cities = new ArrayList<City>();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = (Statement) connection.createStatement();
            rs = (ResultSet) stmt.executeQuery("SELECT city_id, name FROM cities");

            while (rs.next()) {
                City city = new City();
                city.setCity_id(rs.getInt(1));
                city.setName(rs.getString(2));
                cities.add(city);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return cities;
    }

    public ArrayList<User> getUsers() throws SQLException {

        ArrayList<User> users = new ArrayList<User>();

        Statement statement = null;
        ResultSet resultSet = null;

        try {

            statement = (Statement) connection.createStatement();
            resultSet = (ResultSet) statement.executeQuery("SELECT user_id, city_id, firstName, surname, patronymic, eMail, age, sex, password " +
                                                            " FROM users");
            while (resultSet.next()) {
                User user = new User();
                user.setUser_id(resultSet.getInt(1));
                user.setCity_id(resultSet.getInt(2));
                user.setFirstName(resultSet.getString(3));
                user.setSurname(resultSet.getString(4));
                user.setPatronymic(resultSet.getString(5));
                user.setEmail(resultSet.getString(6));
                user.setAge(resultSet.getInt(7));
                user.setSex(resultSet.getString(8).charAt(0));
                user.setPassword(resultSet.getString(9));
                users.add(user);

            }
        }
        finally {

            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }
        }

        return users;
    }

    public ArrayList<User> getUsersByCity(City city) throws SQLException {

        ArrayList<User> foundUsers = new ArrayList<User>();

        Statement statement = null;
        ResultSet resultSet = null;

        try {

            statement = (Statement) connection.createStatement();
            resultSet = (ResultSet) statement.executeQuery("SELECT user_id, city_id, firstName, surname, patronymic, eMail, age, sex, password FROM users");

            while (resultSet.next()) {
                if (resultSet.getInt(2) == city.getCity_id()) {

                    User user = new User();
                    user.setUser_id(resultSet.getInt(1));
                    user.setCity_id(resultSet.getInt(2));
                    user.setFirstName(resultSet.getString(3));
                    user.setSurname(resultSet.getString(4));
                    user.setPatronymic(resultSet.getString(5));
                    user.setEmail(resultSet.getString(6));
                    user.setAge(resultSet.getInt(7));
                    user.setSex(resultSet.getString(8).charAt(0));
                    user.setPassword(resultSet.getString(9));
                    foundUsers.add(user);

                }
            }
        }
        finally {

            if (statement != null) {
                statement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }

        return foundUsers;
    }

    public void insertUser(User user) throws SQLException {

        PreparedStatement statement = null;

        try {
            statement = (PreparedStatement) connection.prepareStatement(
                    "INSERT INTO users " +
                            "(city_id, firstName, surname, patronymic, eMail, age, sex, password) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, user.getCity_id());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getSurname());
            statement.setString(4, user.getPatronymic());
            statement.setString(5, user.getEmail());
            statement.setInt(6, user.getAge());
            statement.setString(7, new String( new char[] {user.getSex()}));
            statement.setString(8, user.getPassword());
            statement.execute();
        }

        finally {

            if (statement != null) {
                statement.close();
            }
        }

    }

    public void insertNews(News news) throws SQLException {

        PreparedStatement statement = null;

        try {
            statement = (PreparedStatement) connection.prepareStatement(
                    "INSERT INTO news " +
                            "(header, content, authorEmail, creationDate) " +
                            "VALUES (?, ?, ?, ?)");
            statement.setString(1, news.getHeader());
            statement.setString(2, news.getContent());
            statement.setString(3, news.getAuthor());
            statement.setString(4, R.formatDate(news.getCreationDate()));
            statement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                statement.close();
            }
        }

    }

    public ArrayList<News> getNews() throws SQLException {

        ArrayList<News> newses = new ArrayList<>();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = (Statement) connection.createStatement();
            rs = (ResultSet) stmt.executeQuery("SELECT news_id, header, content, authorEmail, creationDate FROM news");

            while (rs.next()) {
                News news = new News();
                news.setNews_id(rs.getInt(1));
                news.setHeader(rs.getString(2));
                news.setContent(rs.getString(3));
                news.setAuthor(rs.getString(4));
                news.setCreationDate(R.parseDate(rs.getString(5)));
                newses.add(news);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return newses;
    }

    public ArrayList<Message> getMessages() throws SQLException {

        ArrayList<Message> messages = new ArrayList<>();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = (Statement) connection.createStatement();
            rs = (ResultSet) stmt.executeQuery("SELECT message_id, header, content, sendDate, authorEmail, receiverEmail FROM messages");

            while (rs.next()) {
                Message message = new Message();
                message.setMessage_id(rs.getInt(1));
                message.setHeader(rs.getString(2));
                message.setContent(rs.getString(3));
                message.setSendDate(R.parseDate(rs.getString(4)));
                message.setAuthor(rs.getString(5));
                message.setReceiver(rs.getString(6));
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return messages;


    }

    public void insertMessage(Message message) throws SQLException {

        PreparedStatement statement = null;

        try {
            statement = (PreparedStatement) connection.prepareStatement(
                    "INSERT INTO messages " +
                            "(header, content, sendDate, authorEmail, receiverEmail) " +
                            "VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, message.getHeader());
            statement.setString(2, message.getContent());
            statement.setString(3, R.formatDate(message.getSendDate()));
            statement.setString(4, message.getAuthor());
            statement.setString(5, message.getReceiver());
            statement.execute();

        }

        catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                statement.close();
            }
        }

    }

    public void updateUser(User user) throws SQLException {

        PreparedStatement statement = null;

        try {

            statement = (PreparedStatement) connection.prepareStatement(
                    "UPDATE users SET " +
                            "firstName=?, surname=?, patronymic=?, eMail=?, age=?, sex=?, password=?, city_id=? " +
                            "WHERE user_id=?"
            );

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getPatronymic());
            statement.setString(4, user.getEmail());
            statement.setInt(5, user.getAge());
            statement.setString(6, new String (new char[]{user.getSex()}));
            statement.setString(7, user.getPassword());
            statement.setInt(8, user.getCity_id());
            statement.setInt(9, user.getUser_id());
            statement.execute();

        }

        finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public void deleteUser(User user) throws SQLException {

        PreparedStatement statement = null;

        try {

            statement = (PreparedStatement) connection.prepareStatement(
                    "DELETE FROM users WHERE user_id=?");
            statement.setInt(1, user.getUser_id());
            statement.execute();
        }
        finally {
            if (statement != null) {
                statement.close();
            }
        }

    }

    public void deleteNews(News news) throws SQLException {

        PreparedStatement statement = null;

        try {

            statement = (PreparedStatement) connection.prepareStatement(
                    "DELETE FROM news WHERE news_id=?");
            statement.setInt(1, news.getNews_id());
            statement.execute();
        }
        finally {
            if (statement != null) {
                statement.close();
            }
        }

    }

    public void deleteMessage(Message message) throws SQLException {

        PreparedStatement statement = null;

        try {

            statement = (PreparedStatement) connection.prepareStatement(
                    "DELETE FROM messages WHERE message_id=?");
            statement.setInt(1, message.getMessage_id());
            statement.execute();
        }
        finally {
            if (statement != null) {
                statement.close();
            }
        }

    }




}
