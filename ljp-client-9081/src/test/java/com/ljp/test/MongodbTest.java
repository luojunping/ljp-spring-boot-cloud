package com.ljp.test;

import com.ljp.test.model.DataSyncSchoolProvince;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootTest
public class MongodbTest {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void testOne() {
		DataSyncSchoolProvince dataSyncSchoolProvince = new DataSyncSchoolProvince();
		dataSyncSchoolProvince.setId("9876543210");
		dataSyncSchoolProvince.setSchoolId("9876543210");
		dataSyncSchoolProvince.setSchoolName("阿里云学校");
		dataSyncSchoolProvince.setProvinceName("北京");
		dataSyncSchoolProvince.setOperate("1");
		mongoTemplate.save(dataSyncSchoolProvince);
	}

	@Test
	public void testTwo() {
		DataSyncSchoolProvince dataSyncSchoolProvince = new DataSyncSchoolProvince();
		dataSyncSchoolProvince.setId("0123456789");
		dataSyncSchoolProvince.setSchoolId("0123456789");
		dataSyncSchoolProvince.setSchoolName("腾讯云学校");
		dataSyncSchoolProvince.setProvinceName("深圳");
		dataSyncSchoolProvince.setOperate("1");
		mongoTemplate.save(dataSyncSchoolProvince);
		dataSyncSchoolProvince = new DataSyncSchoolProvince();
		dataSyncSchoolProvince.setId("9876543210");
		dataSyncSchoolProvince.setSchoolId("9876543210");
		dataSyncSchoolProvince.setSchoolName("阿里云学校");
		dataSyncSchoolProvince.setProvinceName("北京");
		dataSyncSchoolProvince.setOperate("0");
		mongoTemplate.save(dataSyncSchoolProvince);
		List<DataSyncSchoolProvince> dataSyncSchoolProvinces = mongoTemplate.find(Query.query(Criteria.where("operate").is("0")), DataSyncSchoolProvince.class);
		System.out.println("dataSyncSchoolProvinces = " + dataSyncSchoolProvinces);
	}

	@Test
	public void testThree() {
		DataSyncSchoolProvince dataSyncSchoolProvince = mongoTemplate.findOne(Query.query(Criteria.where("id").is("9876543210")), DataSyncSchoolProvince.class);
		System.out.println("dataSyncSchoolProvince = " + dataSyncSchoolProvince);
	}

}
