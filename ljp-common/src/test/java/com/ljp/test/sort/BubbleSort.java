package com.ljp.test.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = {2, 3, 4, 9, 8, 7, 5, 6, 1, 0};
//		int num = bubbleSort(array);
//		System.out.println(Arrays.toString(array));
//		System.out.println(num);
		int num = optimizeBubbleSort(array);
		System.out.println(Arrays.toString(array));
		System.out.println(num);
	}

	public static int bubbleSort(int[] array) {
		int num = 0;
		int length = array.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
				num++;
			}
		}
		return num;
	}

	public static int optimizeBubbleSort(int[] array) {
		int num = 0;
		boolean flag = true;
		int length = array.length - 1;
		int lastExchange = length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
					flag = false;
					lastExchange = j + 1;
				}
				num++;
			}
			length = lastExchange;
			if (flag) {
				break;
			}
		}
		return num;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
