import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountMD {

    public static void CountParagraphs(String filename) throws IOException {

        BufferedReader data= new BufferedReader(new FileReader(filename));
        int check1=0;
        int count=0 ;

        String str,str2="";


        while ((str=data.readLine()) != null){
            if (str.startsWith("#")){
                check1=0;
            }
            if((!str.equals(""))&& str2.startsWith("#")){
                check1++;
            }
            else if (str.equals("") && !(str2.equals(""))){
                check1++;
            }
            if (check1==2){
                check1=1;
                count++;
            }
            str2=str;
        }
         check1++;
            if (check1==2){
                count++;
            }

        System.out.println("Number of paragraphs are equal : "+count);

    }

}
