package www.j1stiot.cn.mongo;


import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.*;

/**
 * mongodb test
 */
public class MongoTest {

    public static void main(String[] args){

        //connect
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        ClientSession clientSession = mongoClient.startSession();

        //开启事务
        clientSession.startTransaction();

        //TODO something
        Document doc=new Document();
        doc.append("user_name","jackyoung");
        mongoClient.getDatabase("smartcharger").getCollection("t1").insertOne(clientSession,doc);

        //提交事务
        clientSession.commitTransaction();


    }

}
