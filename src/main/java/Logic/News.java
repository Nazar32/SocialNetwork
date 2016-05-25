package Logic;

import java.util.ArrayList;
import java.util.Date;

public class News {

    private String authorEmail;
    private String header;
    private String content;
    private Date creationDate;
    private int news_id;


    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public News(String author, String header, String content, Date creationDate, int news_id) {

        this.authorEmail = author;
        this.header = header;
        this.content = content;
        this.creationDate = creationDate;
        this.news_id = news_id;
    }

    public News() {
    }



    public String getAuthor() {
        return authorEmail;
    }

    public void setAuthor(String author) {
        this.authorEmail = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return news_id + " " + header + " " + content + " " + creationDate + " " + authorEmail;
    }

}
