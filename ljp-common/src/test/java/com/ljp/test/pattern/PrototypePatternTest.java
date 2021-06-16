package com.ljp.test.pattern;

import lombok.ToString;

@ToString
public class PrototypePatternTest implements Cloneable {

	private String username;

	public static void main(String[] args) throws CloneNotSupportedException {
		PrototypePatternTest prototypePatternTest = new PrototypePatternTest();
		prototypePatternTest.setUsername("prototypePatternTest");
		PrototypePatternTest clone = (PrototypePatternTest) prototypePatternTest.clone();
		System.out.println(prototypePatternTest == clone);
		prototypePatternTest.setUsername("clone");
		System.out.println(prototypePatternTest);
		System.out.println(clone);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
