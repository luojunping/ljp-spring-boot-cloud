package com.ljp.test.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
@TableName(value = "t_test")
public class TestDTO {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	private String fullName;
	private Date birthday;
	private String birthplace;
	private Date createTime;
	private Date modifyTime;

}
