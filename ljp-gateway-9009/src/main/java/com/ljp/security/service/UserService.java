package com.ljp.security.service;

import com.ljp.security.UserDTO;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {

	Mono<Integer> addUserDTO(UserDTO userDTO);

	Mono<List<UserDTO>> listUserDTO();

}
