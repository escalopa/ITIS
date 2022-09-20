
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class PersonCSVDAO implements PersonDAO {

    public final int MAX_ROWS = 1000;

    private Person[] people;
    private int length;
    private String separator = ",";
    private String[] header;

    private String filename;

    public PersonCSVDAO(String filename) {
        this.filename = filename;
         people = new Person[MAX_ROWS];
    }

    public String getFilename() {
        return filename;
    }

    public Person[] getPeople() {
        return people;
    }

    @Override
    public boolean create(Person person) {
        if (length >= MAX_ROWS && person != null) return false;

        people[length] = person;
        person.setId(getLastId());
        length++;
        return true ;
    }

    public Person create() throws Exception {
        Person newOne = new Person();
        if (create(newOne)) {
            return newOne;
        } else {
            throw new Exception("Something wrong.");
        }
    }

    private int getLastId() {
        return 1 + people[length - 1].getId();
    }

    public boolean save() {
        return saveAs(filename);
    }

    public boolean saveAs(String filename) {
        this.filename = filename;

        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            pw.println("SEP=" + separator);

            String s = "";
//            for (int i = 0; i < header.length; i++) {
//                s = header[i] + (i < header.length - 1 ? separator : "");
//            }
            s = String.join(separator, header);
            pw.println(s);
            s = "";
            for (int i = 0; i < length; i++) {
                s = people[i].getId() + separator +
                        people[i].getFirst_name() + separator +
                        people[i].getLast_name() + separator +
                        (people[i].isMale() ? "Male" : "Female") + separator +
                        new SimpleDateFormat("dd.MM.yyyy").format(people[i].getBirthday()) + separator +
                        (people[i].getAddress() != null ? people[i].getAddress() : "");
                pw.println(s);
            }
            pw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }



    public Person[] readAll() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.filename));
            String line = null;
            int k = 0;
            while ((line = br.readLine()) != null) {
                if (line.matches("^SEP=.$") && k == 0) {
                    separator = line.substring(line.length() - 1);
                    k++;
                    continue;
                }
                if (line.startsWith("id") && k <= 1) {
                    header = line.split(separator);
                    k++;
                    continue;
                }

                String[] row = line.split(separator, -1);

                people[length] = new Person(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4].equals("Male"),
                        new SimpleDateFormat("dd.MM.yyyy").parse(row[5]), row[6]);
                length++;
                k++;
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        Person[] result = new Person[length];
        result = Arrays.copyOf(people, length);

        return result;
    }

    @Override
    public Person read(int id) throws Exception {
        for (Person person : people) {
            if (person.getId() == id)
                return person;
        }
        throw new Exception("Person not found");
    }

    boolean is_header_exists(String where) {
        for (String current : header) {
            if (current.equals(where)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Person[] findBy(String what, String where) throws Exception {
        if (!is_header_exists(where)) throw new Exception("Header not found!");
        int counter = 0;

        for (int i = 0; i < length; i++) {
            if (people[i].getByRowName(where).equals(what)) {
                counter++;
            }
        }
        Person[] founded = new Person[counter];
        int k = 0;
        for (int i = 0; i < length; i++) {
            if (people[i].getByRowName(where).equals(what)) {
                founded[k] = people[i];
                k++;
            }
        }

        return founded;
    }

    @Override
    public boolean delete(int id) {
         return false;
    }

}

/*
* 1 2 3 4 5
* [2 3 4 5 null]
* 1 -1 3 4 5
* [3 null 4 5 null]
* 1 -1 3 -1 5
* [3 null 5]
* */