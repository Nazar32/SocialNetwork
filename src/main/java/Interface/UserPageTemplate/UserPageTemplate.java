package Interface.UserPageTemplate;

import javax.swing.*;
import java.sql.SQLException;

public abstract class UserPageTemplate extends JFrame {

    final void createUserPage() throws SQLException {

        initializeMessages();
        initializeNews();
        initializeSettings();
    }

    public abstract void initializeMessages() ;
    public abstract void initializeNews() throws SQLException;
    public abstract void initializeSettings() ;

}
