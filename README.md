# mongoMorphiaDemo
Simple demo of morphia demo on mongoDB -- this is the demo code for course "Java for MongoDB" in: http://www.tomylearn.com
This Demo will show how to insert/update java object into MongoDB using open source project: Morphia
(Morphia project: https://github.com/mongodb/morphia)

Project Model:
        Author object -- which has embeded object: Address, one Author can have many address
        Blog object -- Which has a foreign reference to Author, one Author can have many Blogs
        
#How to Run:
1. check out this project
2. change mongoDB url and port in testcompany.mongoDemo.dao.DBConstant.jave
3. Run class: testcompany.mongoDemo.App
4. check you mongoDB data, DB is: mongoDemo (I use this client: MongoVUE 1.6.9)
   
here is my data in MongoDB
   /* 0 */
{
  "_id" : ObjectId("552caaeede1a35281cc1dd00"),
  "className" : "testcompany.mongoDemo.domain.Blog",
  "title" : "blog first title1",
  "content" : "my first blog",
  "createDate" : ISODate("2015-04-14T05:51:42.253Z"),
  "author" : {
    "$ref" : "Author",
    "$id" : ObjectId("552caaeede1a35281cc1dcff")
  }
}

/* 1 */
{
  "_id" : ObjectId("552caaeede1a35281cc1dd01"),
  "className" : "testcompany.mongoDemo.domain.Blog",
  "title" : "blog second title2",
  "content" : "my second blog",
  "createDate" : ISODate("2015-04-14T05:51:42.253Z"),
  "author" : {
    "$ref" : "Author",
    "$id" : ObjectId("552caaeede1a35281cc1dcff")
  }
}
