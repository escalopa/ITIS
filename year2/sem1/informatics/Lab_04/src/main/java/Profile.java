import constants.PATHS;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/profile")
public class Profile extends HttpServlet {

    Map<String, String> mapCookie;
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {


       mapCookie = Arrays.stream(req.getCookies()).takeWhile
                (c -> c.getName().equals("firstname") || c.getName().equals("lastname")).collect(Collectors.toMap(Cookie::getName, Cookie::getValue));

        System.out.println(mapCookie);
        req.setAttribute("firstname", mapCookie.get("firstname"));
        req.setAttribute("lastname", mapCookie.get("lastname"));
        req.getRequestDispatcher(PATHS.profile).forward(req, resp);
    }
}
