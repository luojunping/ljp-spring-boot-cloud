package com.ljp.test.dao.impl;

import com.ljp.test.dao.StudentDAO;
import com.ljp.test.dto.StudentDTO;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StudentDAOImpl implements StudentDAO {

	@Resource
	private MongoTemplate mongoTemplate;

	@Override
	public void insertUser(StudentDTO studentDTO) {
		mongoTemplate.insert(studentDTO);
	}

	@Override
	public void updateUser(StudentDTO studentDTO) {
		mongoTemplate.save(studentDTO);
	}

	@Override
	public void deleteUser(StudentDTO studentDTO) {
		mongoTemplate.remove(studentDTO);
	}

	@Override
	public StudentDTO selectUser(StudentDTO studentDTO) {
		StudentDTO u = mongoTemplate.findOne(Query.query(Criteria.where("loginName").is("admin")), StudentDTO.class);
		return u;
	}

}
