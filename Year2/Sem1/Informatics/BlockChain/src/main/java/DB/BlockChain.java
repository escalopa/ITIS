package DB;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Data
public class BlockChain {

    private List<BlockModel> chain;

    private static URLConnection chainSocket;

    String SERVER_HOST = "http://188.93.211.195/dis";
    String chainsExtension;
    String newBlockExtension;

    public BlockChain() throws IOException {
        chainsExtension = "/chain";
        newBlockExtension = "/newblock";
        getBlockChains();
    }

    private void initializeSocket() throws IOException {
        chainSocket = new URL(SERVER_HOST + chainsExtension).openConnection();
    }

    public void getBlockChains() throws IOException {
        initializeSocket();
        String chainJson = readChainFromServer();
        ObjectMapper mapper = new ObjectMapper();
        this.chain = List.of(mapper.readValue(chainJson, new TypeReference<>() {
        }));
        DBWork.addChainDB(this.chain);
    }

    private String readChainFromServer() throws IOException {
        initializeSocket();
        StringBuilder stringBuilder = new StringBuilder("");
        new BufferedReader(new InputStreamReader(chainSocket.getInputStream())).lines().forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    public BlockModel getLastBlock() {
        return chain.get(chain.size() - 1);
    }

    public String[][] chainData(int headerSize) {
        String[][] data = new String[chain.size()][headerSize];
        for (int i = 0; i < data.length; i++) {
            data[i] = chain.get(i).getRowData();
        }
        return data;
    }
}
