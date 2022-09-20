
import java.io.*;

public class Test {
    public static void main(String[] args) {
        String filename = "src/main/java/ru/kpfu/classwork/Lesson_18/test.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))){
            String line = bufferedReader.readLine();

            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/ru/kpfu/classwork/Lesson_19/test2.txt"));
            bw.append("test").append("asdf");
            bw.newLine();
            bw.write("test");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("src/main/java/ru/kpfu/classwork/Lesson_19/test3.txt"))));
            PrintWriter pw2 = new PrintWriter(System.out);

            pw2.println("asdf");
            pw2.close();

            pw.append(new StringBuffer("asd")).append(new StringBuilder("asdf"));
            pw.println(new StringBuffer("asdfas").toString());
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
