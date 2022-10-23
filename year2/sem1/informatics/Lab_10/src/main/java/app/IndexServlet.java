package app;

import dao.DriverViews;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        Connection conn = DbWork.getConnection();

       try {
           Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(
                    "SELECT driver_id, name, model FROM driver d JOIN car c on c.car_id=d.car_id");

           List<DriverViews> lstDriver = new ArrayList<>();

            while(rs.next()){
                //получение данных из очередной строки результата;
                lstDriver.add(new DriverViews(rs.getLong("driver_id"),
                        rs.getString("name"),rs.getString("model")));

            }
            rs.close();
            statement.close();

           request.setAttribute("lstDriver", lstDriver);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            request.getRequestDispatcher("index.ftlh").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
