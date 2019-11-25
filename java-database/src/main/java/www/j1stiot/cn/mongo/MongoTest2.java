package www.j1stiot.cn.mongo;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.*;
import org.bson.Document;

public class MongoTest2 {

    public static void main(String[] args) {
        /**
         * https://docs.mongodb.com/manual/core/transactions/
         * For a replica set, include the replica set name and a seedlist of the members in the URI string; e.g.
         * String uri = "mongodb://mongodb0.example.com:27017,mongodb1.example.com:27017/admin?replicaSet=myRepl";
         * For a sharded cluster, connect to the mongos instances; e.g.
         * String uri = "mongodb://mongos0.example.com:27017,mongos1.example.com:27017:27017/admin";
         */
        String uri = "mongodb://47.100.32.119:27017,106.15.40.89:27017,106.15.40.101:27017/admin?replicaSet=rs0";

        final MongoClient client = MongoClients.create(uri);

        /**
         * Prereq: Create collections. CRUD operations in transactions must be on existing collections.
         */
        client.getDatabase("mydb1").getCollection("foo")
                .withWriteConcern(WriteConcern.MAJORITY).insertOne(new Document("abc", 3));

        client.getDatabase("mydb2").getCollection("bar")
                .withWriteConcern(WriteConcern.MAJORITY).insertOne(new Document("xyz", 4));

        /* Step 1: Start a client session. */
        final ClientSession clientSession = client.startSession();

//        /**
//         *  Step 2: Optional. Define options to use for the transaction.
//         */
//        TransactionOptions txnOptions = TransactionOptions.builder()
//                .readPreference(ReadPreference.primary())
//                .readConcern(ReadConcern.LOCAL)
//                .writeConcern(WriteConcern.MAJORITY)
//                .build();
//
//        /**
//         * Step 3: Define the sequence of operations to perform inside the transactions.
//         *
//         */
//        TransactionBody txnBody = new TransactionBody<String>() {
//            public String execute() {
//                MongoCollection<Document> coll1 = client.getDatabase("mydb1").getCollection("foo");
//                MongoCollection<Document> coll2 = client.getDatabase("mydb2").getCollection("bar");
//
//                /**
//                 * Important:: You must pass the session to the operations.
//                 */
//                coll1.insertOne(clientSession, new Document("abc", 1));
//                coll2.insertOne(clientSession, new Document("xyz", 999));
//                return "Inserted into collections in different databases";
//            }
//        };
//        try {
//            /**
//             * Step 4: Use .withTransaction() to start a transaction
//             * execute the callback, and commit (or abort on error).
//             */
//            clientSession.withTransaction(txnBody, txnOptions);
//        } catch (RuntimeException e) {
//            // some error handling
//        } finally {
//            clientSession.close();
//        }


        try {
            /**
             * Step 4: Use .withTransaction() to start a transaction
             * execute the callback, and commit (or abort on error).
             */
            clientSession.startTransaction();
            MongoCollection<Document> coll1 = client.getDatabase("mydb1").getCollection("foo");
            MongoCollection<Document> coll2 = client.getDatabase("mydb2").getCollection("bar");

            /**
             * Important:: You must pass the session to the operations.
             */
            coll1.insertOne(clientSession, new Document("abc", 1));
            coll2.insertOne(clientSession, new Document("xyz", 999));

            clientSession.commitTransaction();

        } catch (RuntimeException e) {
            // some error handling
            //回滚事物
            clientSession.abortTransaction();
            //TODO 重试

        } finally {
            clientSession.close();
        }


    }
}
