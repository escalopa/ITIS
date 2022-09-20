import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Test extends SecondControlWork implements Measurable {

    public static void main(String[] args) throws IOException {

        String filename = "D:\\programming\\Code\\Java\\CW 2\\src\\MOCK_DATA.csv";
        Users data = new Users(filename);
        findUsers(data,"country","Japan","newMOck_Data.csv");

        // Этот метод находит любой тип пользователей в зависимости от категории (gender,country)

        User person1=data.users[0];
        User person2=data.users[data.users.length-1];

        System.out.println(Measurable.getAverage(data.users));
        System.out.println(Measurable.getMaximum(data.users)); //70;Terencio;Lindelof;tlindelof1x@craigslist.org;Male;$499556.91;Russia;Senior Developer
        System.out.println(Measurable.getMinimum(data.users)); //288;Truda;Petrushanko;tpetrushanko7z@studiopress.com;Female;$1494.02;Philippines;Food Chemist

        System.out.println(person1.isGreaterThan(person2));     //false person1.money=370969.08 ,person2.money=484943.19
        System.out.println(person2.isGreaterThan(person1));     //true  person1.money=370969.08 ,person2.money=484943.19



    }
    public static void findUsers(Users users,String category,String findMe,String newFileName) throws IOException{
        User[] answer=new User[0];
        for (int i = 0; i <users.users.length ; i++) {
            if(users.isThere(i,category,findMe)){
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] =users.users[i];
            }
        }

        Users temp=new Users();
        temp.header=users.header;
        temp.users=answer;
        temp.saveAs(newFileName);

        //System.out.println("Data found and saved Successfully");
    }

    @Override
    public double getMeasure() {
        return 0;
    }

    @Override
    public boolean isGreaterThan(Measurable other) {
        return false;
    }
}
