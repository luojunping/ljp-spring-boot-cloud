package com.ljp.test.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Data
@Document(collection = "ljp_student")
@CompoundIndex(name = "idx_nickName_birthday", def = "{'nickName': 1, 'birthday': 1}")
public class StudentDTO {

	@Id
	private String id;
	@Indexed(name = "uk_loginName", unique = true)
	private String loginName;
	private String nickName;
	private LocalDate birthday;
	private String password;
	private Date createTime;
	private Date modifyTime;
	@Transient
	private String thirdId;

}
