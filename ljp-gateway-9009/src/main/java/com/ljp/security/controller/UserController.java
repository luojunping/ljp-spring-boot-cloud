package com.ljp.security.controller;

import com.ljp.security.UserDTO;
import com.ljp.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/security/user/add")
	public Mono<Integer> addUserDTO(@RequestParam("userDTO") UserDTO userDTO) {
		return userService.addUserDTO(userDTO);
	}

	@PostMapping("/security/user/list")
	public Mono<Integer> listUserDTO(UserDTO userDTO) {
		return userService.addUserDTO(userDTO);
	}

}
