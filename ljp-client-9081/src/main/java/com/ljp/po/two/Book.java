package com.ljp.po.two;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@org.hibernate.annotations.Table(appliesTo = "t_book", comment = "书籍表")
@Table(indexes = {@Index(name = "idx_book_book_name", columnList = "book_name"), @Index(name = "idx_book_author_name", columnList = "author_name")})
@Entity(name = "t_book")
public class Book {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", columnDefinition = " char(32) COMMENT '主键ID'")
    private String id;
    @Column(name = "book_name", columnDefinition = " varchar(50) NOT NULL COMMENT '书名'")
    private String bookName;
    @Column(name = "author_name", insertable = false, columnDefinition = " varchar(50) NOT NULL DEFAULT '无名（作者未知）' COMMENT '作者'")
    private String authorName;
    @Column(name = "create_time", insertable = false, columnDefinition = " timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private LocalDate createTime;
    @Column(name = "modify_time", columnDefinition = " datetime DEFAULT NULL COMMENT '修改时间'")
    private LocalDateTime modifyTime;

}
