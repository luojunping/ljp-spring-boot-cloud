package com.ljp.service.impl;

import com.ljp.common.util.ResultUtils;
import com.ljp.common.vo.Result;
import com.ljp.dao.one.StudentRepository;
import com.ljp.dao.two.BookRepository;
import com.ljp.po.one.Student;
import com.ljp.po.two.Book;
import com.ljp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private BookRepository bookRepository;

    @Transactional(readOnly = true)
    @Override
    public Map<String, Object> listAll() {
        List<Student> studentList = studentRepository.findAll();
        List<Book> bookList = bookRepository.findAll();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("studentList", studentList);
        resultMap.put("bookList", bookList);
        return resultMap;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result saveAll() {
        LocalDateTime now = LocalDateTime.now();
        Student student = new Student();
        student.setStudentName("2测试学生2");
        student.setStudentNumber("911911110110");
        student.setCardNumber("333222200001010001");
        student.setBirthday(LocalDate.parse("2020-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        student.setSex((byte) 1);
        student.setModifyTime(now);
        studentRepository.save(student);
        // System.out.println(1 / 0);
        Book book = new Book();
        book.setBookName("三体·黑暗森林");
        book.setAuthorName("刘慈欣");
        book.setModifyTime(now);
        bookRepository.save(book);
        return ResultUtils.success("保存信息成功！");
    }

}
