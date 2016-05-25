package Interface.State;

import Interface.SignIn;
import Interface.UserPage;

public class ExitState implements State {

    @Override
    public void doAction(Context context, UserPage userPage) {

        userPage.dispose();
        new SignIn();

    }
}
