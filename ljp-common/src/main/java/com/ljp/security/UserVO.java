package com.ljp.security;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "ljp_user")
public class UserVO {

	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;
	private String loginName;
	private String userName;
	private String userEmail;
	private String nickname;

}
