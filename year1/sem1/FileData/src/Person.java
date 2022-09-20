
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private boolean gender;  // true if Male
    private Date birthday;
    private String address;

    public Person(int id, String first_name, String last_name, String email, boolean gender, Date birthday, String address) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    public Person() {

    }

    Person firstName(String file_name) {
        setFirst_name(file_name);
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getByRowName(String where) {
        switch (where) {
            case "last_name":
                return this.getLast_name();
            case "first_name":
                return this.getFirst_name();
            case "gender":
                return gender ? "Male" : "Female";
            case "address":
                return this.getAddress();
            case "email":
                return this.getEmail();
            case "birthday":
                return new SimpleDateFormat("dd.MM.yyyy").format(birthday);
        }
        return null;
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

    public boolean isMale() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender=" + (gender ? "Male" : "Female") +
                ", birthday=" + new SimpleDateFormat("dd.MM.yyyy").format(birthday) +
                ", address='" + address + '\'' +
                '}';
    }


}
