package asia.ait.sad.notifications;

import asia.ait.sad.notifications.request.ReqData;
import asia.ait.sad.notifications.request.ReqFCM;
import asia.ait.sad.notifications.request.ReqNotification;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class GFCMHelper {
    static String FCMURL = "https://fcm.googleapis.com/fcm/send";

    // Should this authorization key be hard coded?
    static String AUTHORIZATION = "key=AAAAyko5Jpk:APA91bFhSQo3EXePvzDomdncqzfAlytCiZYyfnmKIwLm93xQOg_1I0UiTp-5d61oSpDnJuoTeAJzZpEpQVT_3JDlp3yU90TFeQ_fpF6L9IbiwNV5d7he3m9_uCVgkFf5UeqxQw_0AOlB";

    public static ReqFCM notificationsToReqFCM(List<Notification> notificationList, String token) {

        // Build a list of notification requests
        List<ReqNotification> reqNotificationList = new ArrayList<>();

        for (Notification notification :
                notificationList) {
            ReqNotification reqNotification = new ReqNotification();
            reqNotification.setId(notification.getId());
            reqNotification.setUserId(notification.getUserId());
            reqNotification.setTitle(notification.getTitle());
            reqNotification.setMessage(notification.getMessage());
            reqNotificationList.add(reqNotification);
        }

        // Build the data list

        ReqData data = new ReqData();
        data.setNotifications(reqNotificationList);

        // Build the actual request
        ReqFCM fcm = new ReqFCM();
        fcm.setData(data);
        fcm.setTo(token);


        return fcm;
    }

    public static boolean sendNotification(ReqFCM fcm) {
        // Rest template
        RestTemplate restTemplate = new RestTemplate();

        // Build the http header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", GFCMHelper.AUTHORIZATION);

        Gson gson = new Gson();

        // Build the rest request
        HttpEntity<String> entity = new HttpEntity<String>(gson.toJson(fcm),headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
                GFCMHelper.FCMURL,
                entity,
                String.class);


        System.out.println("RESULT FROM THE REQUEST" + response.getBody());
        boolean result = true;

        // only accept 200 OK
        if (response.getStatusCodeValue() != 200) result = false;

        try {
            JSONObject jsonObjectResponse = new JSONObject(response.getBody());
            // if FCM returns false, then the message has not been sent
            if (jsonObjectResponse.getInt("success") == 0) result = false;
        } catch (JSONException e) {
            // What if the problem is with json and not with the response code?
            result = false;
            e.printStackTrace();
        }

        return result;
    }

}
