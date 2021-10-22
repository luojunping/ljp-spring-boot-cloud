package com.ljp.test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljp.test.dto.TestDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDAO extends BaseMapper<TestDTO> {

}
