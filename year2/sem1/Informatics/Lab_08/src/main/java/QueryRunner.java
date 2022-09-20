import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class QueryRunner {

    private Connection connection;

    public QueryRunner(Connection connection) {
        this.connection = connection;
    }

    public void executeScripts(String path) throws IOException, SQLException {
        Statement statement = connection.createStatement();
        for (String sql : getQueries(path)) {
            statement.execute(sql);
        }
    }

    public void executeSelectScripts(String pathSelectSql, String excelFilePath) {
        try {
            int queryCount = 1;
            for (String query : getQueries(pathSelectSql)) {
                //Run query and get results
                ResultSet resultSet = connection.createStatement().executeQuery(query);
                //Write results
                //Path is made in order that all queries had different file names
                String path = excelFilePath.replace("requiredQueryResults", "requiredQueryResults" + queryCount);
                writeQueryResults(resultSet, path);
                queryCount++;
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private String[] getQueries(String path) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Files.readAllLines(Paths.get(path)).forEach(c -> stringBuilder.append(c).append(" "));
        return stringBuilder.toString().trim().split(";");
    }

    private void writeQueryResults(ResultSet resultSet, String excelFilePath) throws IOException, SQLException {
        //Create file to save query results (CSV)
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(excelFilePath));
        List<String> columns = getColumnsFromQuery(resultSet);
        //Added header
        bufferedWriter.write((columns.toString().substring(1, columns.toString().length() - 1)) + "\n");
        //Fill file with query results
        while (resultSet.next()) {
            for (int i = 0; i < columns.size(); i++) {
                bufferedWriter.write(resultSet.getString(columns.get(i)));
                if (i + 1 < columns.size())
                    bufferedWriter.write(",");
            }
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private List<String> getColumnsFromQuery(ResultSet resultSet) throws SQLException {
        List<String> columns = new LinkedList<>();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            columns.add(resultSetMetaData.getColumnName(i));
        }
        return columns;
    }
}
