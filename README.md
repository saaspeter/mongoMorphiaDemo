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

Go this url to learn free course: "java for MongoDB" : Http://www.tomylearn.com
