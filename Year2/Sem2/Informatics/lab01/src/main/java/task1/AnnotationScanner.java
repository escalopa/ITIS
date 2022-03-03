package task1;

import task1.annotations.OnGround;
import task1.annotations.SuperAcceleration;
import task1.components.Car;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * IoC Inversion of Control
 * <p>
 * DI Dependency Injection
 */

public class AnnotationScanner {

    public static String PATH_FOR_SCAN = "task1.components";

    public static void main(String[] arg) {

        /* Просканируем пакет PATH_FOR_SCAN для поиска классов (включая вложенные пакеты)  */
        System.out.println("STEP 1: scan package " + PATH_FOR_SCAN + ":");

        List<Class<?>> classList = PathScan.find(PATH_FOR_SCAN);
        if (classList != null)
            classList.forEach(c -> System.out.println("\t" + c.getSimpleName()));

        System.out.println("STEP 2: scan class fields:");
        for (Class<?> cl : classList) {
            /* Сканируем поля классов */
            System.out.println("\tFields of class " + cl.getName());

            for (Field field : cl.getDeclaredFields()) {
                System.out.println("\t\t" + field.getName() + " of type " + field.getType().getCanonicalName());
                Type type = field.getGenericType();
                if (type instanceof ParameterizedType) {
                    ParameterizedType pt = (ParameterizedType) type;
                    System.out.println("raw type: " + pt.getRawType());
                    System.out.println("owner type: " + pt.getOwnerType());
                    System.out.println("actual type args:");
                    for (Type t : pt.getActualTypeArguments()) {
                        System.out.println("    " + t);
                    }
                }

            }
        }

        System.out.println("STEP 3: scan class methods:");
        for (Class<?> cl : classList) {
            /* Сканируем методы классов */
            System.out.println("\tFields of class " + cl.getName());
            Method[] methods = cl.getMethods();
            for (Method method : methods) {
                System.out.println("\t\t" + method.getName());
            }
        }


        System.out.println("STEP 4: scan class annotations:");
        Annotation[] annotations = Car.class.getAnnotations();
        if (annotations != null) {
            for (Annotation a1 : annotations) {
                if (a1.annotationType().equals(OnGround.class)) {
                    System.out.println("\tAirplane is OnAir!");
                    break;
                }

            }
        }

        System.out.println("STEP 5: scan fields annotations:");

        Field[] fields = Car.class.getDeclaredFields();
        for (Field f : fields) {
            Annotation[] fannotations = f.getAnnotations();
            for (Annotation a2 : fannotations) {
                if (a2.annotationType().equals(SuperAcceleration.class)) {
                    System.out.println(String.format("\tField %s %s has SuperAcceleration!", f.getType().getName(), f.getName()));
                }
            }
        }


        System.out.println("...");
    }
}
