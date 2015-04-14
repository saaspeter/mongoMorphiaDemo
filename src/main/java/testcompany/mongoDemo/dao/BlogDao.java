package testcompany.mongoDemo.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import testcompany.mongoDemo.domain.Blog;

import com.mongodb.MongoClient;


public class BlogDao extends BasicDAO<Blog, ObjectId> {

	private static BlogDao instance;
	
	private BlogDao(MongoClient mongoClient, Morphia morphia) {
		super(mongoClient, morphia, DBConstant.DB_Name);
		ensureIndexes();
	}
	
	/**
	 * insert or save, depends whether Author has ObjectId, if don't have then insert, else update vo
	 */
	public Blog saveObject(Blog vo){
		save(vo);
		return vo;
	}
	
	public static BlogDao getInstance(){
		if(instance==null){
			synchronized(BlogDao.class){
				if(instance==null){
					instance = new BlogDao(MongoDBClient.getInstance().getClient(),
							MongoDBClient.getInstance().getMorphiaInstance());
				}
			}
		}
		return instance;
	}

}
