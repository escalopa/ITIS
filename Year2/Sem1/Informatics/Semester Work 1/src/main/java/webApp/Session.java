package webApp;

import lombok.Data;

import java.util.Objects;

@Data
public class Session {

    private String username;
    private String password;

    public Session(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return username.equals(session.username) && password.equals(session.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    public static Session fromString(String urlEncoded) {
        // keys
        String key1 = "username", key2 = "password";
        // values
        String val1 = "", val2 = "";
        // pointers
        String currKey = "", currValue ;
        System.out.println(urlEncoded);
        StringBuilder currString = new StringBuilder();
        for (char c : (urlEncoded + "&").toCharArray()) {
            if (c == '=') {
                currKey = currString.toString();
                currString = new StringBuilder();
            } else if (c == '&') {
                currValue = currString.toString();
                currString = new StringBuilder();
                if (currKey.equals(key1)) {
                    val1 = currValue;
                } else if (currKey.equals(key2)) {
                    val2 = currValue;
                }
            } else {
                currString.append(c);
            }
        }
        return new Session(val1, val2);
    }
}
