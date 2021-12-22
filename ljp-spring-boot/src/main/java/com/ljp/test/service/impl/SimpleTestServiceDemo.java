package com.ljp.test.service.impl;

import com.ljp.test.dao.TestDAO;
import com.ljp.test.dto.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class SimpleTestServiceDemo {

	@Autowired
	private TestDAO testDAO;

	@Transactional(rollbackFor = Throwable.class)
	public void testTransaction(String param) {
		Date now = new Date();
		TestDTO t1 = TestDTO.builder().fullName("张三").birthday(now).birthplace("北京").createTime(now).modifyTime(now).build();
		testDAO.insert(t1);
		if ("illegal".equals(param)) {
			throw new IllegalArgumentException("参数有误！！！");
		}
		TestDTO t2 = TestDTO.builder().fullName("李四").birthday(now).birthplace("上海").createTime(now).modifyTime(now).build();
		testDAO.insert(t2);
	}

}
