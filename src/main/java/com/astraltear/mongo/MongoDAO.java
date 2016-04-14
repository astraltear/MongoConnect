package com.astraltear.mongo;

import org.springframework.data.mongodb.core.MongoTemplate;


public class MongoDAO {
	private MongoTemplate mongoTemplate;
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	public void insertTestVO(TestVO testVO) {

		
		mongoTemplate.insert(testVO,"user");
	}
	
	
}
