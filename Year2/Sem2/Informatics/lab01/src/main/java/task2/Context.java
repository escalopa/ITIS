package task2;

import task1.PathScan;
import task2.annotations.Autowire;
import task2.annotations.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

public class Context {


    private final HashMap<String, Object> objectsMap;


    public Context(String path) {
        objectsMap = new HashMap<>();
        readClasses(path);
    }

    public Object get(String class_name) {
        return objectsMap.get(class_name);
    }

    private void readClasses(String path) {
        try {
            List<Class<?>> classList = PathScan.find(path);
            for (Class<?> clazz : classList) {
                //Create instance of all classes
                if (clazz.isAnnotationPresent(Component.class)) {
                    Object object = clazz.getConstructor().newInstance();
                    objectsMap.putIfAbsent(clazz.getSimpleName(), object);
                    for (Field field : clazz.getDeclaredFields()) {
                        //Initialize fields that only has @Autowire
                        if ((field.isAnnotationPresent(Autowire.class))) {
                            field.setAccessible(true);
                            //Initialize field in case it does not exist in advance
                            objectsMap.putIfAbsent(field.getType().getSimpleName(), field.getType().getConstructor().newInstance());
                            field.set(object, objectsMap.get(field.getType().getSimpleName()));
                        }
                    }
                }
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}