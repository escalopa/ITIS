import DB.DbWork;
import constants.PATHS;
import helpers.ProfileLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher(PATHS.login).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        ResultSet resultSet = DbWork.accountAuthentication(username, password);

        try {
            if (resultSet == null || !resultSet.next()) {
                doGet(req, resp);
            } else {
                out.println("Account found");
                ProfileLoader.loadProfile(req, resp, resultSet.getString("username"),resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}