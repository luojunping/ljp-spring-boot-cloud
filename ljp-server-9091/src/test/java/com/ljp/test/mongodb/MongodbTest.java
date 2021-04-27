package com.ljp.test.mongodb;

import com.ljp.Server9091Application;
import com.ljp.test.dao.StudentDAO;
import com.ljp.test.dto.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@SpringBootTest(classes = Server9091Application.class)
public class MongodbTest {

	@Resource
	private StudentDAO studentDAO;

	@Test
	public void testOne() {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(UUID.randomUUID().toString().replace("-", ""));
		studentDTO.setLoginName("admin");
		studentDTO.setNickName("admin");
		studentDTO.setPassword("admin");
		studentDTO.setBirthday(LocalDate.now());
		studentDTO.setCreateTime(new Date());
		studentDTO.setModifyTime(new Date());
		studentDTO.setThirdId(UUID.randomUUID().toString().replace("-", ""));
		studentDAO.insertUser(studentDTO);
		System.out.println(studentDAO.selectUser(studentDTO));
		studentDTO.setBirthday(LocalDate.of(1990, 1, 6));
		studentDAO.updateUser(studentDTO);
		System.out.println(studentDAO.selectUser(studentDTO));
		studentDAO.deleteUser(studentDTO);
		System.out.println(studentDAO.selectUser(studentDTO));
	}

}
