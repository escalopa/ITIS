package app;

import app.services.Context;
import task2.annotations.Autowire;

public class MainApplication {

    @Autowire
    public static Context context;

    public static void main(String[] args) {
        new task2.Context(MainApplication.class.getPackageName());
        context.compareEntities(MainApplication.class.getPackageName());
    }
}
