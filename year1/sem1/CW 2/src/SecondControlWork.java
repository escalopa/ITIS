import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Студент %surname% %initials% Хелали ахмед эхабелдин абдаллах
 * Группа %group% 11-013
 * Высшая школа информационных технологий и систем
 * Казанский (Приволжский) федеральный университет
 * <p>
 * Контрольная работа №2.
 */

public class SecondControlWork {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        System.out.println("Удачи!");

    }
}


/**
 * 1. Считать файл csv в массив, каждая строка (кроме первой) которого является объектом типа User (см. задание 2).
 * Реализовать методы load, save, saveAs.
 * Реализовать метод getUserById, получающий объект типа User, по id (id != номер строки).
 */
class Users {

    public  String filename;
    public  String[] header;
    public  User[] users = new User[0];

    Users(){

    }

    Users(String filename) throws FileNotFoundException {
        this.filename = filename;
        load();
    }

    public void load() throws FileNotFoundException {
        this.filename = filename;
        FileReader fr = new FileReader(filename);
        Scanner scanner = new Scanner(fr);

        header = scanner.nextLine().split(";");
        String[] employer;

        while (scanner.hasNext()) {

            employer = scanner.nextLine().split(";");
            users = Arrays.copyOf(users, users.length + 1);
            users[users.length - 1] = new User(Integer.parseInt(employer[0]), employer[1], employer[2]
                    , employer[3], employer[4].startsWith("M")? Gender.Male : Gender.Female
                    , Double.parseDouble(employer[5].substring(1)), employer[6], employer[7]);
        }
        scanner.close();
        //System.out.println("File read and data saved Successfully");
    }

    public void save() throws IOException {
        saveAs(this.filename);
    }

    public void saveAs(String newFilename) throws IOException {
        String line = String.join(";", header);
        PrintWriter printWriter = new PrintWriter(new File(newFilename));
        printWriter.println(line);
        for (User user : users) {
            printWriter.println(user.toString());
        }
        printWriter.close();
    }

    public User getUserById(int id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == id) {
                return users[i];
            }
        }
        return null;
    }

    public int getColByName(String headerName) {
        for (int i = 0; i < header.length; i++) {
            if (header[i].equals(headerName)) {
                return i;
            }
        }
        return -1;
    }

    public User findUsersWithParam(String haystack, String needle) { //(см. задание 4.).
        int location = getColByName(haystack);
        if (location == -1)  return null;

        for (User user : users) {
            String clone = users.toString().split(";")[location];
            if (clone.equals(needle)) {
                return user;
            }
        }
        return null;
    }

    public boolean isThere(int row,String colName, String findMe) {

        int location=getColByName(colName);
        if (location==-1)return false;
        String clone = users[row].toString().split(";")[location];
        return clone.equals(findMe);

    }
}

/**
 * 2. Создать класс юзер, с полями из CSV файла. Все геттеры/сеттеры + toString. Пол через Enum.
 * 3. В первой строке файла содержатся заголовки таблицы.
 * Создать метод, позволяющий получить номер столбца, по его названию, например, getColByName("name").
 * 4. Создать boolean метод, возвращающий true если пара название/номер столбца и значение соответствует введенным.
 * Используя его, создать метод в тестовом классе, который получит строки по названию опрделенной должности/стране,
 * и сохранит его в другой файл csv.
 */
class User implements Measurable {

    // id;first_name;last_name;email;gender;money;country;job
    // getters&setter
    // toString()

    int id;
    String first_name;
    String last_name;
    String email;
    Gender gender;
    double money;
    String country;
    String job;


    @Override
    public String toString() {
        return
                (
                getId() + ";" +
                getFirst_name() + ";" +
                getLast_name() + ";" +
                getEmail() + ";" +
                getGender() + ";" +
                "$"+getMoney() + ";" +
                getCountry() + ";" +
                getJob()
        )
                ;
    }

    public User(int id, String first_name, String last_name, String email, Gender gender, double money, String country, String job) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender= gender;
        this.money = money;
        this.country = country;
        this.job = job;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }


    @Override
    public double getMeasure() {
        return this.getMoney();
    }

    @Override
    public boolean isGreaterThan(Measurable other) {
        return this.getMoney()>other.getMeasure();
    }
}

enum Gender {
    Male, Female
}

/**
 * 5. Имплементировать класс User, от интерфейса Measurable.
 * Реализовать метод getMeasure().
 * Реализовать статичные и дефолтные методы в интерфейсе.
 * Добавить в main-е выполнение этих методов.
 */
interface Measurable {
    double getMeasure();

    static double getAverage(Measurable[] list) {
        double average=0;
        for (Measurable measurable : list) {
            average += measurable.getMeasure();
        }
        return (average/list.length);
    }

    static double getMaximum(Measurable[] list) {
        double max = list[0].getMeasure();
        for (Measurable measurable : list) {
            if (max < measurable.getMeasure()) {
                max = measurable.getMeasure();
            }
        }
        return max;
    }

    static double getMinimum(Measurable[] list) {
        double min = list[0].getMeasure();
        for (Measurable measurable : list) {
            if (min > measurable.getMeasure()) {
                min = measurable.getMeasure();
            }
        }
        return min;
    }

    default boolean isGreaterThan(Measurable other) {
        return this.getMeasure()>other.getMeasure();
    }
}
