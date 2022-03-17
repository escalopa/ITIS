package web.app.lab04.utils;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.List;

public class SQLPrepare {

    public static String prepareSQLValues(List<String> fields) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = fields.size();
        for (int i = 0; i < length; i++) {
            stringBuilder.append("'").append(fields.get(i)).append("'");
            if (i + 1 < length) stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

    public static String getColumns(Object object) {
        StringBuilder columns = new StringBuilder();
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.getName().equals("id")) continue;
            columns.append(field.getAnnotation(Column.class).name()).append(",");
        }
        return columns.substring(0, columns.length() - 1);
    }

    public static String getValues(Object object) {
        StringBuilder values = new StringBuilder();
        try {
            for (Field field : object.getClass().getDeclaredFields()) {
                if (field.getAnnotation(Column.class).name().equals("id")) continue;
                field.setAccessible(true);
                if (field.getType().equals(String.class))
                    values.append("'").append(field.get(object).toString()).append("',");
                else
                    values.append(field.get(object).toString()).append(",");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return values.substring(0, values.length() - 1);
    }

    public static String prepareUpdateQuery(Object object) throws IllegalAccessException {
        StringBuilder update_sql = new StringBuilder();
        String field_name;
        Object field_value;
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            field_name = field.getAnnotation(Column.class).name();
            field_value = field.get(object);
            if (field.getType().equals(String.class))
                update_sql.append(field_name).append(" ='").append(field_value.toString()).append("',");
            else
                update_sql.append(field_name).append(" = ").append(field_value.toString()).append(",");
        }
        return update_sql.substring(0, update_sql.length() - 1);
    }
}
