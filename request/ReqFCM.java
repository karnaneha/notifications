package asia.ait.sad.notifications.request;

public class ReqFCM {
    private ReqData data;
    private String to;

    public ReqData getData() {
        return data;
    }

    public void setData(ReqData data) {
        this.data = data;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public ReqFCM() {
    }
}
