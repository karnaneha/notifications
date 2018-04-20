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
    String id;

    private String user_id; // user_id from User table

    private String token;
    private Instant latest;
    public UserToken(){

    }

    public UserToken(String id, String user_id, String token) {
        this.id = id;
        this.user_id = user_id;
        this.token = token;
        this.latest = Instant.now();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getCreated() {return latest; }
}
