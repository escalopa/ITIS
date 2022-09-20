    import java.util.Scanner;

public class String59 {

    //Хелали Ахмед
    public static String Get_extension(String location) {
        char element;
        for (int i = location.length()-1; i > 0; i--) {
            element = location.charAt(i);
            if ((element >= 'a' && element <= 'z') || (element >= 'A' && element <= 'Z') ||(element>='0' && element<='9' ))
            {
                continue;
            }else return location.substring(i);
        }
        return location;
    }

    public static void main(String[] args) {

        //Addresses added by developer
        String address1="C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2020.2.2\\bin\\idea.exe";
        String address2="D:\\programming\\Code\\Matlab\\aproject\\src\\aproject.exe";
        String address3="D:\\KFU\\график.xlsx";
        String address4="D:\\Login.txt";
        String address5="D:\\folders\\music\\song.mp3";
        String address6="D:\\folders\\replays\\game.mp4";


        System.out.println(address1);
        System.out.println(Get_extension(address1));
        System.out.println(address2);
        System.out.println(Get_extension(address2));
        System.out.println(address3);
        System.out.println(Get_extension(address3));
        System.out.println(address4);
        System.out.println(Get_extension(address4));
        System.out.println(address5);
        System.out.println(Get_extension(address5));
        System.out.println(address6);
        System.out.println(Get_extension(address6));
    }
}
