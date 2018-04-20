package asia.ait.sad.notifications;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void storeToken(String userId, String token) {
        UserToken userToken = entityManager.find(UserToken.class, userId);

        if(userToken == null) {
            userToken = new UserToken();
            userToken.setUserId(userId);
        }

        userToken.setToken(token);
        userToken.setTimestamp(new Date());
        entityManager.persist(userToken);
    }

    @Transactional
    public void sendNotification(String userId, String title, String message) throws Exception{
        // grab the user from usertoken table
        UserToken userToken = entityManager.find(UserToken.class, userId);
        // if the user is not found, throw exception
        if (userToken == null)
            throw new Exception("User does not exist");

        // build the notification
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setTitle(title);
        notification.setMessage(message);
        notification.setDate(new Date());
        entityManager.persist(notification);
        entityManager.flush();

        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(notification);

        JSONObject jsonRequest = GFCMHelper.notificationsToJSON(notificationList, userToken.getToken());

        boolean success = GFCMHelper.sendNotification(jsonRequest);

        notification.setFailed(!success);

        entityManager.persist(notification);
    }
}

