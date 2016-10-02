package sql;

import java.util.Arrays;
import java.util.Vector;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBTest {
	private static final String serverAddress = "localhost";
	private static final int port = 27017;
	private static final String dbName = "test";
	private static final String collectionName = "user";
	/**
	 * @return 设置好的MongoClient对象
	 */
	public static MongoClient getMongoClient(String serverAddress, int port, String dbName, String collectionName) {
		MongoClientOptions.Builder build = new MongoClientOptions.Builder();
		build.connectionsPerHost(1000);
		build.threadsAllowedToBlockForConnectionMultiplier(100);
		build.maxWaitTime(2*60*1000);
		build.connectTimeout(1*60*1000);
		MongoClientOptions mongoClientOptions = build.build();
		MongoClient mongoClient = new MongoClient(new ServerAddress(serverAddress, port), mongoClientOptions);
		return mongoClient;
	}
	public static void main(String[] args) {
		MongoClient mongoClient = getMongoClient(serverAddress, port, dbName, collectionName);
		MongoDatabase mongoDatabase = mongoClient.getDatabase(dbName);
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(collectionName);
		
		Vector<Document> docs = new Vector<Document>();
		
		Document doc = new Document();
		doc.put("id", 101);
		doc.put("nickName", "how");
		doc.put("phone", "13227730127");
		doc.put("participation", Arrays.asList(new Document("actID", "act20001")
				.append("content", "reading"), new Document("actID", "act20003")
				.append("content", "fucking")));
		doc.put("publishing", Arrays.asList(new Document("actID", "act20003")
				.append("content", "fucking"), new Document("actID", "act20006")
				.append("content", "coding")));
		docs.add(doc);
		
		doc = new Document();
		doc.put("id", 102);
		doc.put("nickName", "are");
		doc.put("phone", "13227780825");
		doc.put("participation", Arrays.asList(new Document("actID", "act20003")
				.append("content", "fucking"), new Document("actID", "act20006")
				.append("content", "coding")));
		doc.put("publishing", Arrays.asList(new Document("actID", "act20004")
				.append("content", "luing")));
		docs.add(doc);
		
//		mongoCollection.insertMany(docs);
		MongoCursor<Result> cursor = mongoCollection.find(new Document("participation.actID", "act20001"), Result.class).iterator();
		while(cursor.hasNext()) {
			System.out.println(cursor.next().toString());
		}
		
		mongoClient.close();
	}
}
class Result {
	int id = 1;
}
