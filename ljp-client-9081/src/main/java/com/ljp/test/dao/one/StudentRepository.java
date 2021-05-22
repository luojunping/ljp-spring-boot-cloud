package com.ljp.test.dao.one;

import com.ljp.test.po.one.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long> {

	@RestResource(rel = "findStudentByCardNumber", path = "findStudentByCardNumber", description = @Description("根据身份证号码查询学生信息！"))
	Student findByCardNumberEquals(@Param("cardNumber") String cardNumber);

}
