package testcompany.mongoDemo.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import testcompany.mongoDemo.domain.Author;

import com.mongodb.MongoClient;


public class AuthorDao extends BasicDAO<Author, ObjectId> {

	private static AuthorDao instance;
	
	private AuthorDao(MongoClient mongoClient, Morphia morphia) {
		super(mongoClient, morphia, DBConstant.DB_Name);
		ensureIndexes();
	}
	
	/**
	 * insert or save, depends whether Author has ObjectId, if don't have then insert, else update vo
	 */
	public Author saveObject(Author vo){
		save(vo);
		return vo;
	}
	
	public static AuthorDao getInstance(){
		if(instance==null){
			synchronized(AuthorDao.class){
				if(instance==null){
					instance = new AuthorDao(MongoDBClient.getInstance().getClient(),
							MongoDBClient.getInstance().getMorphiaInstance());
				}
			}
		}
		return instance;
	}

}
