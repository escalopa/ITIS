package DB;

import java.sql.*;
import java.util.List;

public class DBWork {

    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public static void EstablishConnection() throws SQLException {


        String url = "jdbc:postgresql://localhost:5432/block_chain";
        String username = "postgres";
        String password = "postgres";
        System.out.println("DB Connection established......");
        connection = DriverManager.getConnection(url, username, password);
    }

    // Inserting data in DB
    public static void addChainDB(List<BlockModel> blocks) {
        if (blocks == null) return;
        clearDB();
        for (BlockModel block : blocks) {
            addBlock(block);
        }
    }

    public static void addBlock(BlockModel blockModel) {

        String sqlModel = "INSERT into block_info(info) values ((?)::json) RETURNING id";
        String sqlBlock = "INSERT into block_data(block_id,prev_hash,public_key,signature,block_formation_date) values(?,?,?,?,?)";
        PreparedStatement add_model;
        PreparedStatement add_block;
        try {
            //Add Model
            add_model = connection.prepareStatement(sqlModel);
            add_model.setString(1, blockModel.getData().toString());
            ResultSet resultSet = add_model.executeQuery();

            //Get id of added block
            resultSet.next();
            int index = resultSet.getInt(1);

            //Add Block
            add_block = connection.prepareStatement(sqlBlock);
            add_block.setInt(1, index);
            add_block.setString(2, blockModel.getPrevhash());
            add_block.setString(3, blockModel.getPublickey());
            add_block.setString(4, blockModel.getSignature());
            add_block.setString(5, blockModel.getTs());
            add_block.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int getDataModelIndex(DataModel dataModel) throws SQLException {

        ResultSet resultSet = getConnection().createStatement().executeQuery(
                "SELECT id FROM block_info ORDER BY id DESC LIMIT 1");
        resultSet.next();
        return resultSet.getInt("id");
    }

    public static void clearDB() {
        try {
            connection.createStatement().execute("DELETE FROM block_data where block_id is not null ");
            connection.createStatement().execute("DELETE FROM block_info where id is not null ");
        } catch (SQLException e) {
            System.err.println("Dropping Data Failed");
            e.printStackTrace();
        }
    }
}