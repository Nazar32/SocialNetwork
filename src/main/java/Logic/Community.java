package Logic;

import java.util.ArrayList;
import java.util.List;

public class Community {

    private String name;
    private User owner;
    private ArrayList<User> subscribers = new ArrayList<>();
    private ArrayList<News> news = new ArrayList<>();

    public ArrayList<News> getNews() {
        return news;
    }


    public void addNews(News news_) {

        news.add(news_);
    }

    public void setNews(ArrayList<News> news) {
        this.news = news;
    }

    public Community() {
    }

    public void addSubsriber(User user) {

        subscribers.add(user);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public ArrayList<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(ArrayList<User> subscribers) {
        this.subscribers = subscribers;
    }

    public Community(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }

    public void attach(User user) {

        subscribers.add(user);
    }

    public void notifyAllObservers(){
        for (User observer : subscribers) {
            observer.update();
        }
    }
}
