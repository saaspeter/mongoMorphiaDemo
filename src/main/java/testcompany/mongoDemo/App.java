package testcompany.mongoDemo;

import java.util.Date;
import java.util.List;

import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

import testcompany.mongoDemo.dao.AuthorDao;
import testcompany.mongoDemo.dao.BlogDao;
import testcompany.mongoDemo.domain.Author;
import testcompany.mongoDemo.domain.Blog;

/**
 * Main class to Run
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Author author1 = new Author();
        author1.setAge(28);
        author1.setName("jack");
        author1.setStatus("A");
        author1.addAddress("street1", "hefei", "236000");
        author1.addAddress("street2", "shanghai", "200000");
        
        Blog blog1 = new Blog();
        blog1.setContent("my first blog");
        blog1.setCreateDate(new Date());
        blog1.setTitle("blog first title1");
        blog1.setAuthor(author1);
        
        Blog blog2 = new Blog();
        blog2.setContent("my second blog");
        blog2.setCreateDate(new Date());
        String title2= "blog second title2";
        blog2.setTitle(title2);
        blog2.setAuthor(author1);
        
        author1 = AuthorDao.getInstance().saveObject(author1);
        BlogDao.getInstance().saveObject(blog1);
        BlogDao.getInstance().saveObject(blog2);
        
        Query<Blog> q = BlogDao.getInstance().getDs().createQuery(Blog.class).filter("title =", title2);
        QueryResults<Blog> blogResult = BlogDao.getInstance().find(q);
        List<Blog> blogList = blogResult.asList();
        if(blogList!=null && blogList.size()>0){
        	System.out.println("blog result:");
        	System.out.println("id:"+blogList.get(0).getObjectId()+" | content:"+blogList.get(0).getContent());
        	System.out.println("blog author:"+blogList.get(0).getAuthor());
        }else {
        	System.out.println("search blog result is empty");
        }
        
    }
}
