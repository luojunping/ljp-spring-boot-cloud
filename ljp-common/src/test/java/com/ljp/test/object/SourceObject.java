package com.ljp.test.object;

import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class SourceObject {

	private String username;
	private String password;
	private String nickname;

	public static void main(String[] args) {
		SourceObject sourceObject = new SourceObject();
		sourceObject.setUsername("source username");
		sourceObject.setPassword("source password");
		sourceObject.setNickname("source nickname");
		TargetObject targetObject = new TargetObject();
		targetObject.setEmail("target email");
		targetObject.setPassword("target password");
		targetObject.setNickname("target nickname");
		System.out.println(targetObject);
		BeanUtils.copyProperties(sourceObject, targetObject);
		System.out.println(targetObject);
	}

}
