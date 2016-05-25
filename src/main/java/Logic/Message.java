package Logic;

import java.util.Date;

public class Message {

    private String header;
    private String content;
    private Date sendDate;
    private String authorEmail;
    private String receiverEmail;
    private int message_id;

    public Message(String header, String content, Date sendDate, String authorEmail, String receiverEmail, int message_id) {
        this.header = header;
        this.content = content;
        this.sendDate = sendDate;
        this.authorEmail = authorEmail;
        this.receiverEmail = receiverEmail;
        this.message_id = message_id;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public Message() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getAuthor() {
        return authorEmail;
    }

    public void setAuthor(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getReceiver() {
        return receiverEmail;
    }

    public void setReceiver(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    @Override
    public String toString() {

        return message_id + " " + header + " " + content + " " + sendDate + " " + authorEmail+ " " + receiverEmail;

    }
}
