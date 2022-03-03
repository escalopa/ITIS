package OldProject;
import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocket; //сокет для общения
    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
    // мы узнаем что хочет сказать клиент?
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try {
            try {
                // адрес - локальный хост, порт - 4004, такой же как у сервера
                clientSocket = new Socket("127.0.0.1", 10000); // этой строкой мы запрашиваем
                //  у сервера доступ на соединение
                reader = new BufferedReader(new InputStreamReader(System.in));
                // читать соообщения с сервера
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // писать туда же
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                System.out.println("Guess the number that the server created(form 1 to 10)\nYou only have 3 chances ");
                // если соединение произошло и потоки успешно созданы - мы можем
                //  работать дальше и предложить клиенту что то ввести
                // если нет - вылетит исключение
                for (int i = 0; i < 3; i++) {
                    String word = reader.readLine(); // ждём пока клиент что-нибудь
                    System.out.println("Input was : "+word);
                    // не напишет в консоль
                    out.write(word+"\n"); // отправляем сообщение на сервер
                    out.flush();
                    String serverWord = in.readLine(); // ждём, что скажет сервер
                    System.out.println("Server's reply: "+serverWord);
                    if (serverWord.equals("Matches")) {
                        System.out.println("Correct answer");
                        break;
                    } else
                        System.out.println("Wrong answer  ,"+ (2-i) +" chances left");
                }
            } finally { // в любом случае необходимо закрыть сокет и потоки
                System.out.println("Client session closed successfully...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
