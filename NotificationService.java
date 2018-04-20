package asia.ait.sad.notifications;

import asia.ait.sad.account.Account;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;

@Service
public class NotificationService {
    @Autowired
    private EntityManager entityManager;

    public boolean sendNotification(String userId){
        return true;
    }



}

