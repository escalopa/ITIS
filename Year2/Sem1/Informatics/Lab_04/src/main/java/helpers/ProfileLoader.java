package helpers;

import DB.DbWork;
import constants.PATHS;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileLoader {

    public static void loadProfile(HttpServletRequest req, HttpServletResponse resp, String username, String password) {

        ResultSet resultSet = DbWork.accountAuthentication(username, password);
        setCookies(req, resp, resultSet);
        try {
            req.getRequestDispatcher(PATHS.profile).forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void setCookies(HttpServletRequest req, HttpServletResponse resp, ResultSet resultSet) {

        try {
            resultSet.next();
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");

            if (firstName != null || lastName != null) {
                Cookie firstNameCookie = new Cookie("firstname", firstName);
                firstNameCookie.setMaxAge(1800);
                Cookie lastNameCookie = new Cookie("lastname", lastName);
                lastNameCookie.setMaxAge(1800);
                resp.addCookie(firstNameCookie);
                resp.addCookie(lastNameCookie);

                req.setAttribute("firstname", resultSet.getString("first_name"));
                req.setAttribute("lastname", resultSet.getString("last_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
