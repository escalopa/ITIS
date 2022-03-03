package restapi;

import app.Queries;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Car;
import app.DbWork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/car")
public class CarByIdRESTServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("request.getContextPath():" + request.getContextPath());
        System.out.println("request.getPathInfo():" + request.getPathInfo());
        System.out.println("request.getServletPath():" + request.getServletPath());

        Long id;

        id = getId(request, response);
        Connection conn = DbWork.getConnection();

        try {

            Car car = Queries.getCar(conn, id);
            response.setHeader("Content-Type", "application/json");

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), car);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = DbWork.getConnection();
        Long id = getId(req,resp);
        String model_name = req.getParameter("model_name");
        if (model_name != null) {
            Queries.update(conn, id, model_name);
        }
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = DbWork.getConnection();
        String model_name = req.getParameter("model_name");
        if (model_name != null) {
            Queries.insertCar(conn, model_name);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = DbWork.getConnection();

        try {
            Long id = getId(req, resp);
            if (id != null) {
                Queries.deleteCar(conn, id);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Long getId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String car_id = req.getParameter("car_id");
        System.out.println(car_id);
        if (car_id == null) {
            car_id = req.getPathInfo() != null ? req.getPathInfo().substring(1) : null;
        }

        if (car_id != null) {
            try {
                return Long.parseLong(car_id);
            } catch (NumberFormatException e) {
                resp.sendError(500, "Неверный id");
            }
        } else {
            resp.sendError(500, "Неверный id");
        }
        return null;
    }
}
