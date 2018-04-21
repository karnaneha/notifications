package asia.ait.sad.notifications;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @PostMapping(path="/refresh_token",
            consumes = "application/json", produces = "application/json")
    String refreshToken(
            @RequestBody String json)
    {
        try {
            JSONObject request = new JSONObject(json);
            String userId = request.get("userId").toString();
            String token = request.get("token").toString();

            notificationService.storeToken(userId, token);

        } catch (JSONException e) {
            e.printStackTrace();
            return "{ \"success\": 0 }";
        }

        return "{ \"success\": 1 }";
    }

    @PostMapping(path="/testnotification",
            consumes = "application/json", produces = "application/json")
    String testNotification(
            @RequestBody String json)
    {
        System.out.println("here");
        try {
            JSONObject request = new JSONObject(json);
            String userId = request.get("userId").toString();
            String title = request.get("title").toString();
            String message = request.get("message").toString();

            notificationService.sendNotification(userId, title, message);
        } catch (JSONException e) {
            e.printStackTrace();
            return "{ \"success\": 0 }";
        } catch (Exception e) {
            e.printStackTrace();
            return "{ \"success\": 0 }";
        }

        return "{ \"success\": 1 }";
    }

}
