package task1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

public class ClassScanner {

    public static String PATH_FOR_SCAN = "task1.components";

    public static void main(String[] args) {

        /* Просканируем пакет PATH_FOR_SCAN для поиска классов (включая вложенные пакеты)  */
        System.out.println("STEP 1: scan package " + PATH_FOR_SCAN + ":");

        List<Class<?>> classList = PathScan.find(PATH_FOR_SCAN);

        for (Class<?> aClass : classList) {
            System.out.println(aClass.getSimpleName());
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("\t" + aClass.getSimpleName() + " depends on --> " + field.getName() + " that has type --> " + field.getType().getSimpleName());
                for (Annotation annotation : field.getAnnotations()) {
                    System.out.println("\t\t" + field.getName() + " has annotation" + annotation);

                }
            }
        }
    }
}
