package mms.mongo.dao;
import mms.mongo.beans.User;
import mms.mongo.utility.DatabaseConnection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.MongoException;
import org.bson.Document;
import com.mongodb.client.FindIterable;
public class UserDAO {
	private MongoDatabase mongoDatabase=DatabaseConnection.getDatabase("mms_new");
	private MongoCollection<Document> userCollection = mongoDatabase.getCollection("user");
	public void addUser(User user){
		try {
			
		} catch (MongoException e) {
			System.out.println("Exception in [addUser(User)]"+e);
		}
	}
	
	public User getByUsername(String username){
		User user = null;
		try {
			//MongoCollection<Document> userCollection = mongoDatabase.getCollection("user");
			Document query=new Document("username",username);
			FindIterable<Document> users=userCollection.find(query);
			for(Document u:users){
				user=new User();
				user.setUsername(u.getString("username"));
				user.setPassword(u.getString("password"));
				user.setName(u.getString("name"));
			}
		} catch (MongoException me) {
			System.out.println("Exception in class : UserDAO : method : [getByUsername(String)]"+me);
		} 
		return user;
	}
}
