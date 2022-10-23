import com.fasterxml.jackson.databind.ObjectMapper;
import db.*;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Main {

    private static DB db;
    private static Random random;

    @SneakyThrows
    public static void main(String[] args) {

        db = new DB();
        random = new Random();
        int idClient = 2;
        int idTrip = 3;

        fillData();
        writeInJSON("Client.json", findClient(idClient));
        writeInJSON("Trip.json", findTrip(idTrip));
        writeInJSON("DataBase.json", db);

    }

    private static void fillData() {

        fillCar();
        fillDriver();
        fillClient();
        fillTrip();

    }

    private static void fillCar() {
        for (int i = 0; i < 20; i++) {
            db.getCarList().add(new Car("car" + i, "model" + i));
        }
    }

    private static void fillDriver() {
        int size = db.getCarList().size();
        for (int i = 0; i < 30; i++) {
            db.getDriverList().add(new Driver(i, "person" + i, "family" + i, ("+7" + i + "745" + i),
                    db.getCarList().get(random.nextInt(size - 1)),
                    random.nextInt(5),
                    random.nextInt(10)));
        }
    }

    private static void fillClient() {
        for (int i = 0; i < 20; i++) {
            db.getClientList().add(new Client(i, "Client" + i
                    , "Family" + i, "7" + i + "8327" + i + "52"
                    , i + " " + i + " 20" + i, random.nextInt(5)));
        }

    }

    private static void fillTrip() {
        int sizeClient = db.getClientList().size();
        int sizeDriver = db.getDriverList().size();
        for (int i = 0; i < 50; i++) {
            db.getTripList().add(new Trip(i, db.getClientList().get(random.nextInt(sizeClient - 1)),
                    db.getDriverList().get(random.nextInt(sizeDriver - 1))
                    , "Location" + random.nextInt(1000)
                    , "Location" + random.nextInt(10000)
                    , random.nextInt(3000)));
        }
    }

    public static Client findClient(Integer id) {
        for (Client client : db.getClientList()) {
            if (client.getId().equals(id)) {
                System.out.println("Client Found");
                return client;
            }
        }
        return null;
    }

    public static Trip findTrip(Integer id) {
        for (Trip trip : db.getTripList()) {
            if (trip.getId().equals(id)) {
                System.out.println("Trip Found");
                return trip;
            }
        }
        return null;
    }

    public static void writeInJSON(String fileName, Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(fileName), object);
            System.out.println(object.getClass().getName() +" Got mapped in the file : "+fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}