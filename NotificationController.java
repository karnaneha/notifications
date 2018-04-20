package asia.ait.sad.notifications;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class NotificationController {
    @Autowired
    NotificationService notificationService;
    @PostMapping(path = "/refresh_token", consumes = "/application/json",produces = "application/json")

    String refreshToken(
            @RequestBody String user_id,
            @RequestBody String Token)
    { System.out.println(user_id);        //boolean result = notificationService.refreshToken(user_id,token);
        //if(result)
            return "{ status: \"success\" }";
        //else
          //  return "{ status: \"failed\" }";

    }
    @Param("order_jwt") String order_jwt,
    @Param("user_id") String user_id,
    @Param("signature") String signature)
    {
        System.out.println(order_jwt);
        JSONObject orderJSON;
        String result = "";
        try {
            //User user = entityManager.find(User.class, "st119630");
            String parsedJWT= jwtService.verifyJWT(order_jwt);
            if( parsedJWT != null){
                orderJSON = new JSONObject(parsedJWT);
                Order orderObject = jsonService.jsonOrderToObject(orderJSON);
                System.out.println(orderObject.getProducts());
                result = orderService.processOrder(orderObject,user_id, signature);
                //type
                //int, boolean, real num
                //develop
                //type checking
                //instructions (usual)
                //assignment condition loop
                //function call (param basic type)
            }
            else{
            }
            //oauth authen filter
        }catch(JSONException e){
            e.printStackTrace();
            return "";
        }
        return result;
}
