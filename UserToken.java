package asia.ait.sad.notifications;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;

@Entity

public class UserToken implements Serializable{
    @Id
    private String userId; // user_id from User table

    private String token;
    private Instant latest;
    public UserToken(){

    }

    public UserToken(String userId, String token) {
        this.userId = userId;
        this.token = token;
        this.latest = Instant.now();
    }


    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getCreated() {return latest; }
}
