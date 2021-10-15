package com.ljp.test.object;

public class Son extends Dad {

	public static final FinalObject FINAL_OBJECT = new FinalObject();

	static {
		System.out.println("初始化：Son。");
	}

	public InstanceObject instanceObject = new InstanceObject();

	public Son() {
		System.out.println("执行构造函数初始化：Son。");
	}

	public static void main(String[] args) {
		// new Son();
		String a = "123";
		String b = a.intern();
		System.out.println(a == b);
		String c = "123";
		System.out.println(b == c);
	}

}
