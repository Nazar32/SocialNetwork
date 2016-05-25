package Interface.State;

import Interface.UserPage;

public class SettingsPageState implements State {
    @Override
    public void doAction(Context context , UserPage userPage) {


        userPage.showMessages(false);
        userPage.showNews(false);
        userPage.showSettings(true);
        userPage.currentPageL.setText("Settings");
        context.setCurrentState(this);
    }
}
