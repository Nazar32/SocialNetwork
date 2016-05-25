package Interface.State;

import Interface.UserPage;

public class MessagesPageState implements State {

    @Override
    public void doAction(Context context, UserPage userPage) {

        userPage.showMessages(true);
        userPage.showSettings(false);
        userPage.showNews(false);
        userPage.currentPageL.setText("Messages");
        context.setCurrentState(this);
    }
}
