package webApp;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Data
public class HttpRequest {

    private final Map<String, String> headers;

    private Session session;

    private String method;

    private String path;

    private String httpVersion;

    private String body;

    public String getHeader(String key) {
        return headers.get(key);
    }

    public void setHeader(String key, String value) {
        headers.put(key, value);
    }

    public Map<String, String> getCookies() {
        HashMap<String, String> cookies = new HashMap<>();
        String cookieString = getHeader("Cookie");
        if (cookieString != null) {
            Arrays.stream(cookieString.split(";"))
                    .forEach(entry -> {
                        String[] kvPair = entry.trim().split("=");
                        cookies.put(kvPair[0], kvPair[1]);
                    });
        }
        return cookies;
    }


    HttpRequest(InputStream is) throws IOException {
        headers = new HashMap<>();
        parseValues(is);
    }

    private void parseValues(InputStream is) throws IOException {


        // gather characters until a line is formed
        StringBuilder lineBuilder = new StringBuilder();

        // read first line
        int token = is.read();
        char tokenCharacter = (char) token;
        while (token != -1 && tokenCharacter != '\n') {
            if (tokenCharacter == '\r') {
                // gather the data and set values
                String firstLine = lineBuilder.toString();
                setMethodAndPath(firstLine);
                lineBuilder = new StringBuilder();
            } else {
                lineBuilder.append(tokenCharacter);
            }
            // update with new character
            token = is.read();
            tokenCharacter = (char) token;
        }

        // read headers
        boolean carriage = false;
        int lineCharCount = 0;
        token = is.read();
        tokenCharacter = (char) token;

        while (token != -1) {
            if (tokenCharacter != '\r' && tokenCharacter != '\n') {
                lineCharCount++;
                lineBuilder.append(tokenCharacter);
            } else if (tokenCharacter == '\r') {
                carriage = true;
            } else {
                if (carriage && lineCharCount == 0) {
                    // an empty line
                    break;
                } else if (carriage && lineCharCount > 0) {
                    carriage = false;
                    lineCharCount = 0;
                    String line = lineBuilder.toString();
                    setHeader(line);
                    lineBuilder.setLength(0);
                }
            }
            token = is.read();
            tokenCharacter = (char) token;
        }

        // read body
        if (headers.containsKey("Content-Length")) {
            while (is.available() != 0) {
                lineBuilder.append((char) is.read());
            }
            if (lineBuilder.length() != 0) body = lineBuilder.toString();
        }
    }

    private void setMethodAndPath(String firstLine) {
        String[] arr = firstLine.split(" ");
        method = arr[0];
        path = arr[1];
        httpVersion = arr[2];
    }

    private void setHeader(String line) {
        String[] arr = line.split(":");
        setHeader(arr[0].trim(), arr[1].trim());
    }
}
