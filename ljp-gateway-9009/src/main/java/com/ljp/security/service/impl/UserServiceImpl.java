package com.ljp.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljp.security.UserDTO;
import com.ljp.security.service.UserService;
import com.ljp.security.service.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public Mono<Integer> addUserDTO(UserDTO userDTO) {
		return Mono.create(monoSink -> {
			monoSink.success(userDAO.insert(userDTO));
		});
		// QueryWrapper<UserDTO> queryWrapper = Wrappers.query().eq("username", "");
	}

	@Override
	@Transactional(readOnly = true)
	public Mono<List<UserDTO>> listUserDTO() {
		return Mono.create(monoSink -> {
			monoSink.success(userDAO.selectList(new QueryWrapper<>()));
		});
	}

}
