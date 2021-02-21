package com.ljp.test.stream;

import com.google.common.collect.Lists;
import com.ljp.test.dto.UserDTO;
import com.ljp.test.entity.Role;
import com.ljp.test.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTest {

	List<UserDTO> userDTOList = new ArrayList<>();

	public static void main(String[] args) {
		UserDTO u1 = new UserDTO();
		u1.setId(1L);
		u1.setLoginName("zhangsan");
		u1.setUserName("张三");
		UserDTO u2 = new UserDTO();
		u2.setId(2L);
		u2.setLoginName("lisi");
		u2.setUserName("李四");
		UserDTO u3 = new UserDTO();
		u3.setId(3L);
		u3.setLoginName("wangwu");
		u3.setUserName("王五");
		ArrayList<UserDTO> userDTOList = Lists.newArrayList(u1, u2, u3);
		Map<Long, String> mapp = userDTOList.stream().collect(Collectors.toMap(UserDTO::getId, UserDTO::getLoginName, (v1, v2) -> {
			return v2;
		}));
		System.out.println("mapp = " + mapp);
	}

	@BeforeEach
	public void before() {
		UserDTO u1 = new UserDTO();
		u1.setId(1L);
		u1.setLoginName("zhangsan");
		u1.setUserName("张三");
		UserDTO u2 = new UserDTO();
		u2.setId(2L);
		u2.setLoginName("lisi");
		u2.setUserName("李四");
		UserDTO u3 = new UserDTO();
		u3.setId(3L);
		u3.setLoginName("wangwu");
		u3.setUserName("王五");
		userDTOList.add(u1);
		userDTOList.add(u2);
		userDTOList.add(u3);
	}

	@Test
	public void testOne() {
		UserDTO u = new UserDTO();
		u.setId(3L);
		u.setLoginName("zhaoliu");
		u.setUserName("赵六");
		userDTOList.add(u);
		System.out.println("userDTOList = " + userDTOList);
		List<UserDTO> subList = userDTOList.subList(0, userDTOList.size() - 1);
		System.out.println("subList = " + subList);
		subList.add(u);
		System.out.println("------------------------------------------------");
		System.out.println("userDTOList = " + userDTOList);
		System.out.println("subList = " + subList);
	}

	@Test
	public void testTwo() {
		List<String> list = new ArrayList();
		list.add("1");
		list.add("2");
		for (String item : list) {
			if ("1".equals(item)) {
				list.remove(item);
			}
		}
	}

	@Test
	public void testThree() {
		UserDTO u = new UserDTO();
		u.setId(3L);
		u.setLoginName("zhaoliu");
		u.setUserName("赵六");
		UserDTO uu = new UserDTO();
		BeanUtils.copyProperties(u, uu);
		System.out.println("uu = " + uu);
		System.out.println(u == uu);
		Role role = new Role();
		role.setRolename("admin");
		User user = new User();
		user.setUsername("admin");
		user.setRole(role);
		User uuu = new User();
		BeanUtils.copyProperties(user, uuu);
		System.out.println("uuu = " + uuu);
		System.out.println(user.getRole() == uuu.getRole());
		assert user.getRole() == uuu.getRole();
		assert user == uuu;
		System.out.println("new Random().nextInt() = " + new Random().nextInt(10));
	}

}
