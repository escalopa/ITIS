
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class TestPerson extends PersonCSVDAO {
    public TestPerson(String filename) {
        super(filename);
    }

    public static void main(String[] args) {
        String filename = "src/main/java/ru/kpfu/classwork/Lesson_19/MOCK_DATA.csv";


        for (Person person : dao.readAll()) {
            System.out.println(person);
        }

        try {
            Person pers = dao.read(5);
            System.out.println(pers);
            pers.setFirst_name("Ivan");

            for (Person person : dao.getPeople()) {
                System.out.println(person);
            }
            Person petr = new Person(0, "Petr", "Alekseevich", "pa@ya.ru", true,
                    new SimpleDateFormat("dd.MM.yyyy").parse("24.11.2000"), "Kaz");
            dao.create(petr);
            dao.create(petr);
            dao.create(petr);
            petr.setFirst_name("Ivano");
//            Person petr2 = dao.create();
//            petr2.setFirst_name("Petr");
//            petr2.setLast_name("Petr");
//            petr2.setEmail("Petr");
//            Person petr3 = dao.create();
//            petr2.setFirst_name("Petr");
//            petr2.setLast_name("Petr");
//            petr2.setEmail("Petr");

            dao.saveAs("src/main/java/ru/kpfu/classwork/Lesson_19/MOCK_DATA2.csv");

            System.out.println("Search in first_name:");
            System.out.println(Arrays.toString(dao.findBy("Dew", "first_name")));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
