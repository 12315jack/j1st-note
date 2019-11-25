package www.j1stiot.cn.mongo;


import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;



/**
 * mongodb test
 */
public class MongoTest {

    public static void main(String[] args) {

        //副本集
//        final List<ServerAddress> servers = new ArrayList<ServerAddress>();
//        servers.add(new ServerAddress("mongo1", 27017));
//        servers.add(new ServerAddress("mongo2", 27017));
//        servers.add(new ServerAddress("mongo3", 27017));

//        //认证信息
//        String user = "myTest"; // the user name
//        String db = "test"; // the name of the database in which the user is defined
//        char[] password = "123".toCharArray(); // the password as a character array
//        MongoCredential credential = MongoCredential.createCredential(user, db, password);
//        MongoClientSettings settings = MongoClientSettings.builder()
//                .credential(credential)
//                .applyToClusterSettings(new Block<ClusterSettings.Builder>() {
//                    public void apply(
//                            com.mongodb.connection.ClusterSettings.Builder t) {
//                        t.hosts(servers);// 副本集
//                    }
//                }).build();
//
//        MongoClient mongoClient = MongoClients.create(settings);


        MongoClientURI uri = new MongoClientURI("mongodb://47.100.32.119:27017,106.15.40.89:27017,106.15.40.101:27017/?replicaSet=rs0");
        MongoClient mongoClient = new MongoClient(uri);

        MongoClient client = new MongoClient(uri);
        String dbName = "test";

        MongoDatabase database = mongoClient.getDatabase(dbName);
        MongoCollection<Document> collection = database.getCollection("testdb");

        //插入数据
        collection.insertOne(new Document("test1", "高数"));
        collection.insertOne(new Document("test1", "MongoDB从入门到精通"));


        MongoCursor<Document> iterator = collection.find().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toJson());
        }

    }

}
