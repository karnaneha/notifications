package asia.ait.sad.notifications.request;

import java.util.Date;

public class ReqNotification {
    private long id;
    private String userId;
    private String title;
    private String message;
    private String sound;
    private String priority;
    private boolean read;
    private Date date;

    public ReqNotification() {
        sound = "default";
        priority = "high";
        read = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSound() {
        return sound;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
