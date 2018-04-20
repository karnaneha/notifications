package asia.ait.sad.notifications.request;

public class ReqNotification {
    private long id;
    private String title;
    private String message;
    private String sound;
    private String priority;

    public ReqNotification() {
        sound = "default";
        priority = "high";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
