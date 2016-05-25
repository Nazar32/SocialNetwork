package Interface.State;

import Interface.UserPage;

import java.sql.SQLException;

public class DeleteMessageState implements State {
    @Override
    public void doAction(Context context, UserPage userPage) {

        try {
            userPage.deleteMessage();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
