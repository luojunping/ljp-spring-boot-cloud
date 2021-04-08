package com.ljp.test.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BaseInfo {

	@Id
	private String id;

}
