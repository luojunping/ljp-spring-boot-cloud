package com.ljp.test.leetcode;

public class Code134 {

	public static void main(String[] args) {
		int[] gas = {1, 2, 3, 4, 5};
		int[] cost = {3, 4, 5, 1, 2};
		gas = new int[]{2, 3, 4};
		cost = new int[]{3, 4, 3};
		Code134 code134 = new Code134();
		System.out.println(code134.canCompleteCircuit(gas, cost));
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int sum = 0;
		int tank = 0;
		int start = 0;
		int length = gas.length;
		for (int i = 0; i < length; i++) {
			sum += (gas[i] - cost[i]);
			tank += (gas[i] - cost[i]);
			if (tank < 0) {
				tank = 0;
				start = i + 1;
			}
		}
		if (sum < 0) {
			return -1;
		}
		return start;
	}

}
