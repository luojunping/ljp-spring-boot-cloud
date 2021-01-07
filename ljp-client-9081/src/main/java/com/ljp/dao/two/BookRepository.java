package com.ljp.dao.two;

import com.ljp.po.two.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {

}
