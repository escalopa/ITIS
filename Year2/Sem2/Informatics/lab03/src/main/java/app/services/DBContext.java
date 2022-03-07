package app.services;

import app.dbService.DB;
import task2.annotations.Autowire;
import task2.annotations.Component;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Component
public class DBContext {

    @Autowire
    private DB db;
    public HashMap<String, Set<String>> tables;

    public void scanEntities() {
        try {
            getTables();
            getAttributes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getTables() throws SQLException {
        String sql = "SELECT TABLE_NAME " +
                "FROM information_schema.tables " +
                "WHERE table_type = 'BASE TABLE' " +
                "  AND table_schema NOT IN ('pg_catalog'," +
                "                           'information_schema')";
        Statement statement = db.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        tables = new HashMap<>();
        while (resultSet.next())
            tables.put(resultSet.getString("table_name"), new HashSet<>());
    }

    private void getAttributes() throws SQLException {
        String sql = "SELECT a.attname " +
                "FROM pg_catalog.pg_attribute a " +
                "WHERE a.attrelid = " +
                "    (SELECT c.oid " +
                "     FROM pg_catalog.pg_class c " +
                "     LEFT JOIN pg_catalog.pg_namespace n ON n.oid = c.relnamespace " +
                "     WHERE pg_catalog.pg_table_is_visible(c.oid) " +
                "       AND c.relname = 'TABLE-NAME' )" +
                "  AND a.attnum > 0 " +
                "  AND NOT a.attisdropped";
        for (String table_name : tables.keySet()) {
            ResultSet resultSet = db.getConnection().createStatement().executeQuery(prepareSQL(sql, table_name));
            while (resultSet.next())
                tables.get(table_name).add(resultSet.getString("attname"));
        }
    }

    public String prepareSQL(String sql, String table_name) {
        return sql.replace("TABLE-NAME", table_name);
    }
}
