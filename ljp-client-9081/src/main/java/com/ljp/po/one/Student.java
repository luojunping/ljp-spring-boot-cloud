package com.ljp.po.one;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@org.hibernate.annotations.Table(appliesTo = "t_student", comment = "学生表")
@Table(indexes = {@Index(name = "idx_student_student_number", columnList = "student_number", unique = true), @Index(name = "idx_student_card_number", columnList = "card_number", unique = true)})
@Entity(name = "t_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = " bigint(20) COMMENT '主键ID'")
    private Long id;
    @Column(name = "student_number", nullable = false, columnDefinition = " char(22) COMMENT '学籍号'")
    private String studentNumber;
    @Column(name = "student_name", columnDefinition = " varchar(22) NOT NULL COMMENT '学生姓名'")
    private String studentName;
    @Column(name = "card_number", columnDefinition = " char(18) NOT NULL COMMENT '身份证号'")
    private String cardNumber;
    @Column(name = "sex", insertable = false, columnDefinition = " tinyint(2) NOT NULL DEFAULT 3 COMMENT '性别：1：男；2：女；3：其它；'")
    private Byte sex;
    @Column(name = "birthday", columnDefinition = " date DEFAULT NULL COMMENT '出生日期'")
    private LocalDate birthday;
    @Column(name = "create_time", insertable = false, columnDefinition = " timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private LocalDate createTime;
    @Column(name = "modify_time", columnDefinition = " datetime DEFAULT NULL COMMENT '修改时间'")
    private LocalDateTime modifyTime;

}
