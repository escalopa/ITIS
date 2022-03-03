package app;

import dto.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Queries {

    public static List<Car> getAllCars(Connection conn) {
        Statement statement;
        List<Car> lstCar = new ArrayList<>();

        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(
                    "SELECT car_id,  model_name FROM car");

            while (rs.next()) {
                //получение данных из очередной строки результата;
                lstCar.add(new Car(rs.getLong("car_id"),
                        rs.getString("model_name")));
            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstCar;
    }

    public static Car getCar(Connection conn, Long id) {
        PreparedStatement statement;
        Car car = null;
        try {
            statement = conn.prepareStatement("SELECT car_id,  model_name FROM car where car_id = ? ");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();


            if (rs.next()) {
                //получение данных из очередной строки результата;
                car = new Car(rs.getLong("car_id"),
                        rs.getString("model_name"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public static boolean insertCar(Connection conn, String model_name) {
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement("INSERT  INTO  car(model_name) VALUES(?)");
            statement.setString(1, model_name);
            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean update(Connection conn, Long id, String model_name) {
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement("UPDATE car SET model_name = ? where car_id = ?");
            statement.setString(1, model_name);
            statement.setLong(2, id);
            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteCar(Connection conn, Long id) {
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement("DELETE  FROM  car where car_id = ?");
            statement.setLong(1, id);
            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
