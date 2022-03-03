import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class CarDataBase {

    public static class CarName {

        public CarName(CarsData carsData, Model model, String make) {
            this.carsData = carsData;
            this.model = model;
            this.make = make;
        }

        public CarsData getCarsData() {
            return carsData;
        }

        public Model getModel() {
            return model;
        }

        CarsData carsData;
        Model model;
        String make;
    }

    public static class CarsData {

        public CarsData(int ID, double MPG, int cylinder, double eDisplay, int hoursPower, int weight, double acceleration, int year) {
            this.ID = ID;
            this.MPG = MPG;
            this.cylinder = cylinder;
            this.eDisplay = eDisplay;
            this.hoursPower = hoursPower;
            this.weight = weight;
            this.acceleration = acceleration;
            this.year = year;
        }

        public int getHoursPower() {
            return hoursPower;
        }

        public int getYear() {
            return year;
        }

        int ID;
        double MPG;
        int cylinder;
        double eDisplay;
        int hoursPower;
        int weight;
        double acceleration;
        int year;

        public int getID() {
            return this.ID;
        }
    }

    public static class Model {

        public Model(int modelID, CarMaker maker, String model) {
            this.modelID = modelID;
            this.maker = maker;
            this.model = model;
        }

        public CarMaker getMaker() {
            return maker;
        }

        public String getModel() {
            return model;
        }

        int modelID;
        CarMaker maker;
        String model;

    }

    public static class CarMaker {

        public CarMaker(int ID, String maker, String fullName, Country country) {
            this.ID = ID;
            this.maker = maker;
            this.fullName = fullName;
            this.country = country;
        }

        public int getID() {
            return ID;
        }

        public String getMakerName() {
            return maker;
        }

        public Country getCountry() {
            return country;
        }

        int ID;
        String maker;
        String fullName;
        Country country;
    }

    public static class Country {

        public Country(int countryID, String countryName, Continent continent) {
            this.countryID = countryID;
            this.countryName = countryName;
            this.continent = continent;
        }

        public int getCountryID() {
            return countryID;
        }

        public String getCountryName() {
            return countryName;
        }

        public Continent getContinent() {
            return continent;
        }

        int countryID;
        String countryName;
        Continent continent;
    }

    public static class Continent {
        public Continent(String input) {
            inputs = input.split(",");
            this.continentID = Integer.parseInt(inputs[0]);
            this.continent = inputs[1];
        }

        public String getContinentName() {
            return continent;
        }

        public int getContinentID() {
            return continentID;
        }

        int continentID;
        String continent;

    }

    List<CarsData> carsDataList = new LinkedList<>();
    List<CarName> carNamesList = new LinkedList<>();
    List<Model> modelsLists = new LinkedList<>();
    List<CarMaker> carMakersList = new LinkedList<>();
    List<Country> countriesList = new LinkedList<>();
    List<Continent> continentsList = new LinkedList<>();

    private static String[] inputs;

    private Continent getContinentByIDFromList(int id) {
        for (Continent continent : continentsList) {
            if (continent.getContinentID() == id)
                return continent;
        }
        return null;
    }

    private Country getCountryByIDFromList(int id) {
        for (Country country : countriesList) {
            if (country.getCountryID() == id)
                return country;
        }
        return null;
    }

    private CarMaker getMakerByIDFromList(int id) {
        for (CarMaker carMaker : carMakersList) {
            if (carMaker.getID() == id)
                return carMaker;
        }
        return null;
    }

    private Model getModelByNameFromList(String name) {
        for (Model model : modelsLists) {
            if (model.getModel().equals(name))
                return model;
        }
        return null;
    }

    private CarsData getCarDataByIDFromList(int id) {
        for (CarsData carsData : carsDataList) {
            if (carsData.getID() == id)
                return carsData;
        }
        return null;
    }


    public CarDataBase(String carsNamePath, String carsDataPath, String modelListsPath, String carMakersPath, String countriesListPath, String continentsListPath) throws IOException {

        BufferedReader bufferedReader;
        String lineOfData;

        bufferedReader = new BufferedReader(new FileReader(continentsListPath));
        bufferedReader.readLine();
        while ((lineOfData = bufferedReader.readLine()) != null) {
            continentsList.add(new Continent(lineOfData));
        }
        bufferedReader.close();


        bufferedReader = new BufferedReader(new FileReader(countriesListPath));
        bufferedReader.readLine();
        while ((lineOfData = bufferedReader.readLine()) != null) {
            inputs = lineOfData.split(",");
            Continent continent = getContinentByIDFromList(Integer.parseInt(inputs[2]));
            countriesList.add(new Country(Integer.parseInt(inputs[0]), inputs[1], continent));
        }
        bufferedReader.close();


        bufferedReader = new BufferedReader(new FileReader(carMakersPath));
        bufferedReader.readLine();
        while ((lineOfData = bufferedReader.readLine()) != null) {
            inputs = lineOfData.split(",");
            //System.out.println(inputs[3]);
            Country country;
            if (inputs[3].equals("null")) continue;
            else
                country = getCountryByIDFromList(Integer.parseInt(inputs[3]));
            carMakersList.add(new CarMaker(Integer.parseInt(inputs[0]), inputs[1], inputs[2], country));
        }
        bufferedReader.close();


        bufferedReader = new BufferedReader(new FileReader(modelListsPath));
        bufferedReader.readLine();
        while ((lineOfData = bufferedReader.readLine()) != null) {
            inputs = lineOfData.split(",");
            CarMaker carMaker = getMakerByIDFromList(Integer.parseInt(inputs[1]));
            modelsLists.add(new Model(Integer.parseInt(inputs[0]), carMaker, inputs[2]));
        }
        bufferedReader.close();


        bufferedReader = new BufferedReader(new FileReader(carsDataPath));
        bufferedReader.readLine();
        while ((lineOfData = bufferedReader.readLine()) != null) {
            inputs = lineOfData.split(",");
            carsDataList.add(new CarsData(Integer.parseInt(inputs[0]), inputs[1].equals("null") ? 0 : Double.parseDouble(inputs[1]),
                    Integer.parseInt(inputs[2]), Double.parseDouble(inputs[3]), inputs[4].equals("null") ? 0 : Integer.parseInt(inputs[4]),
                    Integer.parseInt(inputs[5]), Double.parseDouble(inputs[6]), Integer.parseInt(inputs[7])));
        }
        bufferedReader.close();

        bufferedReader = new BufferedReader(new FileReader(carsNamePath));
        bufferedReader.readLine();
        while ((lineOfData = bufferedReader.readLine()) != null) {
            inputs = lineOfData.split(",");
            CarsData carsData = getCarDataByIDFromList(Integer.parseInt(inputs[0]));
            Model model = getModelByNameFromList(inputs[1]);
            carNamesList.add(new CarName(carsData, model, inputs[2]));
        }

        bufferedReader.close();
    }
}
