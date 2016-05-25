package DataBase;

import Logic.News;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AbstractNewsStore {

    public void deleteNews(News news) throws SQLException;

    public void insertNews(News news) throws SQLException ;

    public ArrayList<News> getNews() throws SQLException ;
}
