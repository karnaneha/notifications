package asia.ait.sad.notifications.request;

import java.util.List;

public class ReqData {
    private List<ReqNotification> notifications;

    public List<ReqNotification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<ReqNotification> notifications) {
        this.notifications = notifications;
    }

    public ReqData() {
    }
}
