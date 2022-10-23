package webApp;

import handlers.MainHandler;
import lombok.Data;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class HttpResponse {

    private static final String NEW_LINE = "\r\n";

    //Header and Cookies
    private Map<String, String> header;
    private HashMap<String, String> cookies;

    //Content
    private String title = "HTTP/1.1 200 OK";
    private String body;

    //Stream to output
    private final OutputStream outputStream;

    public void createCookie(String key,String value,int expiryInSeconds){cookies.put(key,value+"; Max-Age="+expiryInSeconds);}

    public HttpResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
        this.cookies = new HashMap<>();
        this.header = new HashMap<>();
    }

    public void send() throws IOException {
        addContentLengthHeader();
        StringBuilder resp = new StringBuilder();

        resp.append(title).append(NEW_LINE);
        header.forEach((k,v) -> resp.append(k).append(": ").append(v).append(NEW_LINE));
        cookies.forEach((k,v) -> resp.append("Set-Cookie: ")
                .append(k).append("=").append(v).append("; HttpOnly").append(NEW_LINE));
        resp.append(NEW_LINE);

        // body
        if(body != null) {
            resp.append(body);
        }
        outputStream.write(resp.toString().getBytes());
        outputStream.flush();
    }

    public void addContentType(String type) {
        header.put("Content-type",type);
    }

    private void addContentLengthHeader() {
        if (body != null){
            header.put("Content-Length",""+body.length());
        }
    }
}
