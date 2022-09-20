package utils;

import lombok.Data;

import java.io.IOException;
import java.nio.file.*;

@Data
public class Pages {

    public static String WELCOME_PAGE;
    public static String LOGIN_PAGE;
    public static String SIGNUP_PAGE;
    public static String PROFILE_PAGE;
    public static String GAME_PAGE;
    public static String ERROR_PAGE;
    public static String STYLE_CSS;
    public static String IMAGE_BG;


    private static final String path = "src/main/resources/html/";

    public static void readPages() {
        try {
            WELCOME_PAGE = Files.readString(Paths.get(path + "welcome.html"));
            LOGIN_PAGE = Files.readString(Paths.get(path + "login.html"));
            SIGNUP_PAGE = Files.readString(Paths.get(path + "signup.html"));
            PROFILE_PAGE = Files.readString(Paths.get(path + "profile.html"));
            GAME_PAGE = Files.readString(Paths.get(path + "game.html"));
            ERROR_PAGE = Files.readString(Paths.get(path + "error.html"));
            STYLE_CSS = Files.readString(Paths.get(path + "style.css"));
            //IMAGE_BG = Files.readString(Paths.get(path + "bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPage(String path) {
        return switch (path) {
            case "", "/" -> WELCOME_PAGE;
            case "/login" -> LOGIN_PAGE;
            case "/signup" -> SIGNUP_PAGE;
            case "/profile" -> PROFILE_PAGE;
            case "/game" -> GAME_PAGE;
            case "/404" -> ERROR_PAGE;
            case "/style.css" -> STYLE_CSS;
            case "/bg.jpg" -> IMAGE_BG;
            default -> null;
        };
    }
}
