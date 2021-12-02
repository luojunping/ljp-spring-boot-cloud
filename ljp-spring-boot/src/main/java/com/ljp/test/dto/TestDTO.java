package com.ljp.test.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "t_test")
public class TestDTO {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	private String username;
	private Date birthday;
	private String from;
	private Date createTime;
	private Date modifyTime;

}
