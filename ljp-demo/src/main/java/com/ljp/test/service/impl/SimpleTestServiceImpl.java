package com.ljp.test.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ljp.test.dao.TestDAO;
import com.ljp.test.dto.TestDTO;
import com.ljp.test.service.SimpleTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleTestServiceImpl implements SimpleTestService {

	@Autowired
	private TestDAO testDAO;

	@Override
	public void testTransaction() {
		Wrappers.lambdaQuery(TestDTO.class);
//		testDAO.selectList();
	}

}
