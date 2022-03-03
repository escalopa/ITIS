import API.BlockChainAPI;
import DB.DBWork;
import Interface.BlockChainFrame;

public class MainApplication {

    public static void main(String[] args) throws Exception {

        DBWork.EstablishConnection();
        new BlockChainFrame(new BlockChainAPI());
    }
}
