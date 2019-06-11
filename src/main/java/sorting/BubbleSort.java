package sorting;

import java.util.Arrays;

public class BubbleSort {
	private static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j + 1] < a[j]) {
					int t = a[j];
					a[j] = a[j + 1];
					a[j + 1] = t;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 25, 59, 73, 89, 90, 1, 3, 5, 7, 11, -1, 72, -8 }; // given array
		printArray(a);
		bubbleSort(a);
		// Inbuilt function
		System.out.println(Arrays.toString(a));
	}

	private static void printArray(int[] a) {
		System.out.print("Array = ");
		for (int v : a)
			System.out.print(v + " ");
		System.out.println();
	}
}
