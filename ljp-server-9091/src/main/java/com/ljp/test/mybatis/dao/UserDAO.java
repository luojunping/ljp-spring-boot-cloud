package com.ljp.test.mybatis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljp.test.mybatis.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO extends BaseMapper<UserDTO> {

}
