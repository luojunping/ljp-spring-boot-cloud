package com.ljp.service;

import com.ljp.common.vo.Result;

import java.util.Map;

public interface TestService {

    Map<String, Object> listAll();

    Result saveAll();

}
