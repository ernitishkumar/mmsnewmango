package mms.mongo.utility;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
import java.sql.*;
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

	public static Connection getConnection(String dbName)
	{
		Connection connectionWithSource=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connectionWithSource=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,"root","kumar");		
		} catch (SQLException exception) {
			System.out.println("Not able to connect to the Database "+exception.getMessage());
			exception.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found "+e.getMessage());
			e.printStackTrace();
		}
		return connectionWithSource;
	}
}
