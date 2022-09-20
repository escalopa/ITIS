import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    public static void main(String[] args) {
        String email_re = "(?i)^((?![_\\-.])[a-z0-9_\\-.]+)@([^_\\-.][a-z0-9_\\-.]+)$";
        String emails = "Asf.asf@int.kpfu.ru";

        Pattern pattern = Pattern.compile(email_re, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emails);
    }
}
