package asia.ait.sad.notifications;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
            System.out.println(userId);
            System.out.println(token);
        } catch (JSONException e) {
            e.printStackTrace();
            return "{ status: 'failed' }";
        }

        return "{ status: 'success' }";
    }

}
