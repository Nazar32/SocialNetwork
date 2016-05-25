package Interface.State;

import Interface.UserPage;

public class NewsPageState implements State {
    @Override
    public void doAction(Context context , UserPage userPage) {

        userPage.showNews(true);
        userPage.showMessages(false);
        userPage.showSettings(false);
        userPage.currentPageL.setText("News");
        context.setCurrentState(this);
    }
}
