package mms.mongo.utility;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
public class DatabaseConnection {
	private static MongoClient mongoClient=null;
	public static MongoClient getConnection(){
		try{
			if(mongoClient==null){
				mongoClient = new MongoClient("localhost",27017);	
			}
		}catch(MongoException me){
			System.out.println("Exception in DatabaseConnection class method : getConnection() "+me);
		}
		return mongoClient;
	}

	public static MongoClient getConnection(String host,int port){
		try{
			if(mongoClient==null){
				mongoClient = new MongoClient(host,port);	
			}
		}catch(MongoException me){
			System.out.println("Exception in DatabaseConnection class method : getConnection(String,String) "+me);
		}
		return mongoClient;
	}

	public static MongoDatabase getDatabase(String databaseName){
		MongoDatabase mongoDatabase=null;
		try{
			mongoDatabase=getConnection().getDatabase(databaseName);
		}catch(MongoException me){
			System.out.println("Exception in DatabaseConnection class method : getDatabase() "+me);
		}
		return mongoDatabase;
	}

	public static MongoDatabase getDatabase(String databaseName,String username,String password){
		MongoDatabase mongoDatabase=null;
		try{
			mongoDatabase=getConnection().getDatabase(databaseName);
		}catch(MongoException me){
			System.out.println("Exception in DatabaseConnection class method : getDatabase(String,String,String) "+me);
		}
		return mongoDatabase;
	}
}
