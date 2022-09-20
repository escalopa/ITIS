import org.apache.ibatis.jdbc.ScriptRunner;
import java.io.*;
import java.sql.*;


public class JDBCHomework {

    private static Connection connection;
    private static final String pathTables = "src/main/resources/script/tables.sql";
    private static final String pathValues = "src/main/resources/script/values.sql";
    private static final String pathSelect = "src/main/resources/script/queries.sql";
    private static final String pathDrop = "src/main/resources/script/drop.sql";
    private static final String excelFilePath = "src/main/resources/results/requiredQueryResults.csv";
    private static Reader reader;

    public static void main(String[] args) throws SQLException, FileNotFoundException {

        String url = "jdbc:postgresql://localhost:5432/lab08";
        String username = "postgres";
        String password = "postgres";
        System.out.println("Connection established......");
        connection = DriverManager.getConnection(url, username, password);

        runAllQueries();
        //runAllQueriesMybatis();
        //dropTables();

        connection.close();
        System.out.println("Connection closed");
    }

    private static void runAllQueries() {
        try {
            QueryRunner queryRunner = new QueryRunner(connection);
            //Create tables
            queryRunner.executeScripts(pathTables);
            //Insert values in DB
            queryRunner.executeScripts(pathValues);
            //Make random Select queries from db
            queryRunner.executeSelectScripts(pathSelect, excelFilePath);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void runAllQueriesMybatis() {
        try {
            ScriptRunner sr = new ScriptRunner(connection);
            reader = new BufferedReader(new FileReader(pathTables));
            sr.runScript(reader);
            reader = new BufferedReader(new FileReader(pathValues));
            sr.runScript(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dropTables() throws FileNotFoundException {
        ScriptRunner sr = new ScriptRunner(connection);
        reader = new BufferedReader(new FileReader(pathDrop));
        sr.runScript(reader);
    }

}