import DB.DbWork;
import constants.PATHS;
import helpers.ProfileLoader;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/signup")
public class Signup extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher(PATHS.signup).forward(req, resp);
        System.out.println("Loaded Signup GET ");
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        System.out.println("Loaded Signup POST");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String password = req.getParameter("password");

        forwardTo(req, resp, username, email, firstname, lastname, password);

    }

    private void forwardTo(HttpServletRequest req, HttpServletResponse resp, String username, String email, String firstname, String lastname, String password) throws SQLException, ServletException, IOException {

        if (!DbWork.accountExists(email) && !DbWork.usernameExists(username)) {
            try {
                DbWork.createAccount(username, firstname, lastname, email, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ProfileLoader.loadProfile(req, resp, username, password);
        } else
            doGet(req, resp);
    }
}
