package www.j1stiot.cn.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;
import org.apache.commons.configuration.AbstractConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.mongodb.client.model.Sorts.ascending;

/**
 * mongodb storage
 */
public class DataMongoStorage {
    protected MongoClient client;
    protected MongoDatabase database;

    /**
     * Initial mongodb
     *
     * @param config config params of mongodb
     */
    public void init(AbstractConfiguration config) {
        //ip connect method
//        List<ServerAddress> addresses = parseAddresses(config.getString("mongo.address"));
//        List<MongoCredential> credentials = parseCredentials(
//                config.getString("mongo.userName"),
//                "admin",
//                config.getString("mongo.password"));
//        if (addresses.size() == 1) {
//            this.client = new MongoClient(addresses.get(0), credentials);
//        } else {
//            this.client = new MongoClient(addresses, credentials);
//        }

        //url connect method
        MongoClientURI uri = new MongoClientURI(config.getString("mongo.url"));
        this.client = new MongoClient(uri);
        String dbName = config.getString("data_mongo.database");

        this.database = this.client.getDatabase(dbName);

    }

    public void destroy() {
        if (this.client != null) {
            this.client.close();
        }
    }

    private ServerAddress parseAddress(String address) {
        int idx = address.indexOf(':');
        return (idx == -1) ?
                new ServerAddress(address) :
                new ServerAddress(address.substring(0, idx), Integer.parseInt(address.substring(idx + 1)));
    }


    private List<ServerAddress> parseAddresses(String addresses) {
        List<ServerAddress> result = new ArrayList<>();
        String[] addrs = addresses.split(" *, *");
        for (String addr : addrs) {
            result.add(parseAddress(addr));
        }
        return result;
    }

    private List<MongoCredential> parseCredentials(String userName, String database, String password) {
        List<MongoCredential> result = new ArrayList<>();
        result.add(MongoCredential.createCredential(userName, database, password.toCharArray()));
        return result;
    }



}
