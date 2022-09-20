import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CarsDataFunctions {

    /**
     * -- 01.  Для датасета по производителям машин вывести континент с максимальным количеством стран
     * -- 02.  Вывести всех производителей из определенного континента (например, Европы)
     * -- 03.  Для каждой страны подсчитать количество моделей
     * -- 04.  Вывести производителей, которые производили машины до 1990 года
     * -- 05.  Вывести среднее количество лошадиных сил по a) Maker b) Model
     **/
    //Task 1
    public static String continentWithMaxNumberOFCarManufactures(CarDataBase carDataBase) {
        StringBuilder theContinent = new StringBuilder();
        HashMap<String, Integer> maxManufacture = new HashMap<>();
        int countOfCountries = 0;
        for (CarDataBase.CarMaker carMaker : carDataBase.carMakersList) {
            String continent = carMaker.country.continent.getContinentName();
            if (maxManufacture.containsKey(continent)) {
                maxManufacture.put(continent, maxManufacture.get(continent) + 1);
            } else {
                maxManufacture.put(continent, 1);
            }
            int count = maxManufacture.get(continent) + 1;

            if (count > countOfCountries) {
                theContinent = new StringBuilder(continent);
                countOfCountries = count;
            } else if (count == countOfCountries) {
                theContinent.append(" ").append(continent);
            }
        }
        return theContinent.toString();
    }

    //Task 2
    public static List<String> continentManufactures(CarDataBase carDataBase, String continent) {
        List<String> manufactures = new LinkedList<>();
        for (CarDataBase.CarMaker carMaker : carDataBase.carMakersList) {
            //System.out.println(carMaker.getCountry().getContinent().getContinentName()+ " " + continent + " " + carMaker.getCountry().getContinent().getContinentName().equals(continent));
            if (carMaker.getCountry().getContinent().getContinentName().replaceAll("^'|'$", "").equals(continent)) {
                manufactures.add(carMaker.getMakerName());
            }
        }
        return manufactures;
    }

    //Task 3
    public static HashMap<String, Integer> modelsOfEachCountry(CarDataBase carDataBase) {
        HashMap<String, Integer> countriesModels = new HashMap<>();
        for (CarDataBase.Model model : carDataBase.modelsLists) {
            CarDataBase.CarMaker carMaker = model.getMaker();
            if (carMaker == null) continue;
            String country = carMaker.getCountry().getCountryName();
            if (countriesModels.containsKey(country))
                countriesModels.put(country, countriesModels.get(country) + 1);
            else
                countriesModels.put(country, 1);
        }
        return countriesModels;
    }

    //Task 4
    public static List<String> manufacturesBefore(CarDataBase carDataBase, int date) {
        List<String> manufactures = new LinkedList<>();
        for (CarDataBase.CarName carName : carDataBase.carNamesList) {
            if (carName.getCarsData().getYear() < date) {
                if (carName.getModel() == null || carName.getModel().getMaker() == null) continue;
                manufactures.add(carName.getModel().getMaker().getMakerName());
            }
        }
        return manufactures.stream().distinct().collect(Collectors.toList());
    }

    //Task 5A
    public static HashMap<String, Integer> averageHPByMaker(CarDataBase carDataBase) {
        HashMap<String, Integer> makerAverage = new HashMap<>();
        HashMap<String,Integer> makersAccessed = new HashMap<>();
        for (CarDataBase.CarName carName : carDataBase.carNamesList){
            int value = carName.getCarsData().getHoursPower();
            if (carName.getModel() == null || carName.getModel().getMaker() == null) continue;
            CarDataBase.CarMaker carMaker = carName.getModel().getMaker();
            if (makerAverage.containsKey(carMaker.getMakerName())){
                makerAverage.put(carMaker.getMakerName(), makerAverage.get(carMaker.getMakerName()) + value);
                makersAccessed.put(carMaker.getMakerName(),makersAccessed.get(carMaker.getMakerName())+1);
            }
            else{
                makerAverage.put(carMaker.getMakerName(), value);
                makersAccessed.put(carMaker.getMakerName(),1);
            }
        }
        for (String key: makersAccessed.keySet()) {
            makerAverage.put(key,(makerAverage.get(key)/makersAccessed.get(key)));
        }
        return makerAverage;
    }

    //Task 5B
    public static HashMap<String, Integer> averageHPByModel(CarDataBase carDataBase) {
        HashMap<String, Integer> modelAverage = new HashMap<>();
        HashMap<String,Integer> modelsAccessed = new HashMap<>();
        for (CarDataBase.CarName carName : carDataBase.carNamesList){
            int value = carName.getCarsData().getHoursPower();
            if (carName.getModel() == null ) continue;
            CarDataBase.Model model = carName.getModel();
            if (modelAverage.containsKey(model.getModel())){
                modelAverage.put(model.getModel(), modelAverage.get(model.getModel()) + value);
                modelsAccessed.put(model.getModel(),modelsAccessed.get(model.getModel())+1);
            }
            else{
                modelAverage.put(model.getModel(), value);
                modelsAccessed.put(model.getModel(),1);
            }
        }
        for (String key: modelsAccessed.keySet()) {
            modelAverage.put(key,(modelAverage.get(key)/modelsAccessed.get(key)));
        }
        return modelAverage;
    }

    //Task 6
    public static HashMap<String,Integer> makersInAllCountry(CarDataBase carDataBase){
        HashMap<String,Integer> makersCountry = new HashMap<>();
        for (CarDataBase.CarMaker maker : carDataBase.carMakersList) {
            if (maker == null) continue;
            String country = maker.getCountry().getCountryName();
            if (makersCountry.containsKey(country))
            makersCountry.put(country, makersCountry.get(country) + 1);
            else
            makersCountry.put(country, 1);
        }
        return makersCountry;
    }

}
