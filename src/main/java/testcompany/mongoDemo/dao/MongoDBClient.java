package testcompany.mongoDemo.dao;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import testcompany.mongoDemo.domain.Author;
import testcompany.mongoDemo.domain.Blog;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDBClient {

	private static MongoDBClient instance;
	
	private static MongoClient client;
	private static Morphia morphiaInstance;
	
	private MongoDBClient(){}
	
	public MongoClient getClient() {
		return client;
	}
	
	public Datastore getDataStore(String dbname){
		return morphiaInstance.createDatastore(client, dbname); 
	}
	
	public Morphia getMorphiaInstance() {
		return morphiaInstance;
	}

	public static MongoDBClient getInstance(){
		if(instance==null){
			synchronized(MongoDBClient.class){
				if(instance==null){
					instance = new MongoDBClient();
					// no authentication
					client = new MongoClient(DBConstant.URL, Integer.parseInt(DBConstant.PORT));
					// if need authencate
					// MongoCredential credential = MongoCredential.createCredential(username, database, password.toCharArray());
					// client = new MongoClient(new ServerAddress(url, Integer.parseInt(port)), Arrays.asList(credential));
					morphiaInstance = new Morphia();
					morphiaInstance.map(Author.class, Blog.class);
				}
			}
		}
		return instance;
	}
	
}
