package com.wyw.basic;

import java.util.*;

public class Hello {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		ArrayList<Integer> aIntegers = new ArrayList<Integer>();
		aIntegers.add(scan.nextInt());
		System.out.println(aIntegers);

		int[] a = { 66, 66, 66, 66, 66 };
		printSecond(a);
	}

	public static void printSecond(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		int second = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < max && arr[i] > second) {
				second = arr[i];
			}
		}
		System.out.println(second);
	}
}
