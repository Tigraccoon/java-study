package ch05;

import java.util.Arrays;

public class ArrayCopy {
	public static void main(String[] args) {
		int[] list = { 10, 20, 30, 40, 50 };
		int[] numbers = list;
		for (int i = 0 ; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		int[] list_copy = Arrays.copyOf(list, list.length);
		for (int value : list_copy) {	// 향상된 for문에선 ++n, 배열, 객체타입을 내부적으로 다룸
			System.out.println(value);
		}
		
	}
}
