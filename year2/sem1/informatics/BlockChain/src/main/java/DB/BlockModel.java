package DB;

import lombok.Data;

@Data
public class BlockModel {
    private String prevhash;
    private DataModel data;
    private String signature;
    private String ts;
    private String publickey;
    private boolean verified;

    public String[] getRowData() {

        return new String[]{
                  getData().getName()
                , getData().getData()
                , getPrevhash()
                , getPublickey()
                , getSignature()
                , getTs()
                , isVerified() ? "Yes" : "No"
        };
    }

    // return as normalized JSON object
    public String toString() {
        return new StringBuilder().append("{")
                .append("\"prevhash\":\"").append(prevhash).append("\",")
                .append("\"data\":").append(data.toString()).append(",")
                .append("\"signature\":\"").append(signature).append("\",")
                .append("\"ts\":\"").append(ts).append("\",")
                .append("\"publickey\":\"").append(publickey).append("\"}")
                .toString();
    }
}
