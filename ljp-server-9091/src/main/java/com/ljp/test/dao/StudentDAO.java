package com.ljp.test.dao;

import com.ljp.test.dto.StudentDTO;

public interface StudentDAO {

	void insertUser(StudentDTO studentDTO);

	void updateUser(StudentDTO studentDTO);

	void deleteUser(StudentDTO studentDTO);

	StudentDTO selectUser(StudentDTO studentDTO);

}
