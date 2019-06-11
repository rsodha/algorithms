package sorting;

import java.util.Arrays;

public class OptimizedBubbleSort {
	private static void optimizedBubbleSort(int[] a) {
		boolean swapped = true; // if no swap performed by inner loop means array has been sorted, exit the loop 
		for (int i = 0; swapped && i < a.length - 1; i++) {
			swapped = false;
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j + 1] < a[j]) {
					int t = a[j];
					a[j] = a[j + 1];
					a[j + 1] = t;
					swapped = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[] { 25, 59, 73, 89, 90, 1, 3, 5, 7, 11, -1, 72, -8 }; // given array
		optimizedBubbleSort(a);
		System.out.println(Arrays.toString(a));
	}
}
