import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static java.lang.System.out;

public class DataBase {

    /**
     * -- 01.  Для датасета по производителям машин вывести континент с максимальным количеством стран
     * -- 02.  Вывести всех производителей из определенного континента (например, Европы)
     * -- 03.  Для каждой страны подсчитать количество моделей
     * -- 04.  Вывести производителей, которые производили машины до 1990 года
     * -- 05.  Вывести среднее количество лошадиных сил по a) Maker b) Model
     * -- 06.  makers in each country
     **/

    public static void main(String[] args) throws IOException {

        String pathCarsName = "car-names.csv";
        String pathCarsData = "cars-data.csv";
        String pathModelList = "model-list.csv";
        String pathCarMakers = "car-makers.csv";
        String pathCountries = "countries.csv";
        String pathContinents = "continents.csv";

        //Read Files to start solving tasks
        CarDataBase carDataBase = new CarDataBase(pathCarsName, pathCarsData, pathModelList, pathCarMakers, pathCountries, pathContinents);

        //Line Separator
        out.println("Task 1:");

        //Tasks 1
        String continent = CarsDataFunctions.continentWithMaxNumberOFCarManufactures(carDataBase);
        out.print(continent);

        //Line Separator
        out.println("\nTask 2:");

        //Tasks 2
        List<String> continentManufactures = CarsDataFunctions.continentManufactures(carDataBase, "europe");
        continentManufactures.forEach(e -> out.print(e + " "));

        //Line Separator
        out.println("\nTask 3:");
        //Task 3
        HashMap<String, Integer> modelsByCountry = CarsDataFunctions.modelsOfEachCountry(carDataBase);
        modelsByCountry.entrySet().forEach(e -> out.print(e + " "));

        //Line Separator
        out.println("\nTask 4:");

        //Task 4
        List<String> manufacturesBefore = CarsDataFunctions.manufacturesBefore(carDataBase, 1971);
        manufacturesBefore.forEach(e -> out.print(e + " "));

        //Line Separator
        out.println("\nTask 5A:");

        //Task 5 A
        HashMap<String,Integer> averageHPByMaker = CarsDataFunctions.averageHPByMaker(carDataBase);
        averageHPByMaker.entrySet().forEach(e -> out.print(e+" "));

        //Line Separator
        out.println("\nTask 5B:");

        //Task 5 B
        HashMap<String,Integer> averageHPByModel = CarsDataFunctions.averageHPByModel(carDataBase);
        averageHPByModel.entrySet().forEach(e -> out.print(e+" "));

        //Line Separator
        out.println("\nTask 6:");

        //Task 6 
        HashMap<String,Integer> makersInCountry = CarsDataFunctions.makersInAllCountry(carDataBase);
        makersInCountry.entrySet().forEach(e -> out.print(e+" "));

    }
}
