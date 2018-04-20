package asia.ait.sad.notifications.request;

import java.util.List;

public class ReqData {
    private String userId;
    private List<ReqNotification> notifications;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<ReqNotification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<ReqNotification> notifications) {
        this.notifications = notifications;
    }
}
