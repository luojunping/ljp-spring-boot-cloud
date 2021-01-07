package com.ljp.test.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("ljp_user")
@Data
public class UserDTO {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    @TableField("login_name")
    private String loginName;
    @TableField("login_password")
    private String loginPassword;
    @TableField("user_name")
    private String userName;
    @TableField("user_email")
    private String userEmail;

}
