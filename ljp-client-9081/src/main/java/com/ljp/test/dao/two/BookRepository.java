package com.ljp.test.dao.two;

import com.ljp.test.po.two.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {

}
