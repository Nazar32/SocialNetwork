package Interface.State;

import Interface.UserPage;
import Logic.Proxy.ProxyManagmentSystem;

import java.sql.SQLException;

public class UpdateMessagesState implements State{

    @Override
    public void doAction(Context context, UserPage userPage) {


        try {
            ProxyManagmentSystem.getInstance().updateMessages();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }


        userPage.updateMessages();
        context.setCurrentState(this);
    }
}
