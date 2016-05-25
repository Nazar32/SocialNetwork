package DataBase;

import Logic.Message;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AbstractMessagesStore {

    public ArrayList<Message> getMessages() throws SQLException;

    public void insertMessage(Message message) throws SQLException ;

    public void deleteMessage(Message message) throws SQLException;
}
