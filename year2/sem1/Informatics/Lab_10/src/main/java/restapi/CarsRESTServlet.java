package restapi;

import app.DbWork;
import app.Queries;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Car;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet("/cars")
public class CarsRESTServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        Connection conn = DbWork.getConnection();

        List<Car> lstCar = Queries.getAllCars(conn);
        try {

            response.setHeader("Content-Type", "application/json");

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), lstCar);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
