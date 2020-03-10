package first.response;

import org.springframework.http.HttpStatus;

public class Response {
    private HttpStatus statusCode;
    private String statusMsg;

    public Response(HttpStatus statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    @Override
    public String toString() {
        return "Response: " +
                "statusCode=" + statusCode +
                ", statusMsg='" + statusMsg;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
}
