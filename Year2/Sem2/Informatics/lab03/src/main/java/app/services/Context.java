package app.services;

import app.annotations.*;
import task1.PathScan;
import task2.annotations.Autowire;
import task2.annotations.Component;

import java.lang.reflect.Field;
import java.util.List;

@Component
public class Context {

    @Autowire
    public DBContext dbContext;

    public void compareEntities(String packageName) {
        dbContext.scanEntities();
        readClasses(packageName);
    }

    private void readClasses(String path) {

        List<Class<?>> classList = PathScan.find(path);

        for (Class<?> clazz : classList) {
            Entity entity = clazz.getAnnotation(Entity.class);
            if (entity != null) {
                String tableName = entity.name().equals("") ? clazz.getSimpleName() : entity.name();
                if (dbContext.tables.containsKey(tableName)) {
                    printValue(true, tableName);
                    for (Field field : clazz.getDeclaredFields()) {
                        String fieldName = "";
                        if (field.isAnnotationPresent(Column.class) || field.isAnnotationPresent(Id.class))
                            fieldName = field.getName();
                        else if (field.isAnnotationPresent(ManyToOne.class) ||
                                field.isAnnotationPresent(OneToMany.class) ||
                                field.isAnnotationPresent(OneToOne.class))
                            fieldName = field.getName() + "_id";
                        printValue(dbContext.tables.get(tableName).contains(fieldName), "\t" + fieldName);
                    }

                } else {
                    printValue(false, tableName);
                }
            }
        }
        System.out.println();
    }

    private void printValue(boolean found, String msg) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        System.out.println(
                found ? ANSI_GREEN + msg + ANSI_RESET : ANSI_RED + msg + ANSI_RESET
        );

    }
}