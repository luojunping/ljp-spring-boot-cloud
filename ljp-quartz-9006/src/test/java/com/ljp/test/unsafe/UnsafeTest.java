package com.ljp.test.unsafe;

import org.junit.jupiter.api.Test;

public class UnsafeTest {

	// private static final Unsafe unsafe = Unsafe.getUnsafe();

	// public static void main(String[] args) throws NoSuchFieldException {
	// // Unsafe unsafe = Unsafe.getUnsafe();
	// // long studentNameOffset =
	// // unsafe.objectFieldOffset(Student.class.getDeclaredField("studentName"));
	// // Student student = new Student();
	// // student.setStudentName("xiaoming");
	// // boolean flag = unsafe.compareAndSwapObject(student, studentNameOffset,
	// // "xiaoming", "xiaohong");
	// // if (flag)
	// // System.out.println(student);
	// }

	@Test
	public void testOne() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
//		final Class<Unsafe> unsafeClass = Unsafe.class;
//		Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");
//		theUnsafe.setAccessible(true);
//		Unsafe unsafe = (Unsafe) theUnsafe.get(null);
//		long studentNameOffset = unsafe.objectFieldOffset(Student.class.getDeclaredField("studentName"));
//		Student student = new Student();
//		student.setStudentName("xiaoming");
//		boolean flag = unsafe.compareAndSwapObject(student, studentNameOffset, "xiaoming", "xiaohong");
//		if (flag)
//			System.out.println(student);
	}

}
