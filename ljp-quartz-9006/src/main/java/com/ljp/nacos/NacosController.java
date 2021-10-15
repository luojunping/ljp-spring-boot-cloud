package com.ljp.nacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/7/22
 * @since 1.0.0
 **/
@RestController
public class NacosController {

	@Autowired
	private Environment environment;

	@GetMapping("/test/nacos/config/{nacosKey}")
	public String nacosConfig(@PathVariable("nacosKey") String nacosKey) {
		return environment.getProperty(nacosKey);
	}

}
