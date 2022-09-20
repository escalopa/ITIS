package messenger.server;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Data
public class Message {


    String sender_username;
    String receiver_username;
    String body;
    Timestamp timestamp;

    public Message(){}
    public Message(String sender_username, String receiver_username, String body, Timestamp timestamp) {
        this.sender_username = sender_username;
        this.receiver_username = receiver_username;
        this.body = body;
        this.timestamp = timestamp;
    }
    // receiver ; body
    public Message getMSG(String wholeMSG,String name){
        String[] blocks = wholeMSG.split(";");
        return new Message(name,blocks[0],blocks[1],new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public String toString(){
        return ("[" + new SimpleDateFormat("dd.MM.YYYY HH.mm").format(timestamp)+ "] "+sender_username+": "+body);
    }


}
