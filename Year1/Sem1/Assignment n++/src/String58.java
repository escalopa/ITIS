import javax.swing.text.html.HTMLDocument;
import java.util.Scanner;

public class String58 {

    //Хелали Ахмед
    public static String Get_File_Name(String location)
    {
        int slash_location=0;
        int dot_location=0;
        for (int i = 0; i <location.length() ; i++)
        {
            if (Character.toString(location.charAt(i)) .equals("\\") )
                slash_location = i;
            if (location.charAt(i) == '.')
                dot_location = i;
        }
        location=location.substring(slash_location+1,dot_location);
        return location;
    }
    public static void main(String[] args) {

        //Addresses added by developer
        String address1="C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2020.2.2\\bin\\idea.exe";
        String address2="D:\\programming\\Code\\Matlab\\aproject\\src\\aproject.exe";
        String address3="D:\\KFU\\график.xlsx";

        //Addresses added by the user
        String address4;
        Scanner scan=  new Scanner(System.in);
        address4=scan.nextLine();


        //Print the String and the File name
        System.out.println(address1);
        System.out.println(Get_File_Name(address1));
        System.out.println(address2);
        System.out.println(Get_File_Name(address2));
        System.out.println(address3);
        System.out.println(Get_File_Name(address3));
        System.out.println(address4);
        System.out.println(Get_File_Name(address4));

        }
    }

