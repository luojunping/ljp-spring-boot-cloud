package com.ljp.test.proxy;

import com.ljp.test.proxy.service.StudentService;
import com.ljp.test.proxy.service.TeacherService;
import com.ljp.test.proxy.service.impl.StudentServiceImpl;
import com.ljp.test.proxy.service.impl.TeacherServiceImpl;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		AddHandler<StudentService> studentAddHandler = new AddHandler<>(new StudentServiceImpl());
		StudentService studentService = (StudentService) Proxy.newProxyInstance(ClassUtils.getDefaultClassLoader(),
				StudentServiceImpl.class.getInterfaces(), studentAddHandler);
		AddHandler<TeacherService> teacherAddHandler = new AddHandler<>(new TeacherServiceImpl());
		TeacherService teacherService = (TeacherService) Proxy.newProxyInstance(ClassUtils.getDefaultClassLoader(),
				TeacherServiceImpl.class.getInterfaces(), teacherAddHandler);
		studentService.addStudent();
		teacherService.addTeacher();
	}

}
