package sorting;

import java.util.Arrays;

public class InsertionSort {
	private static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int t = a[i];
			int j = i - 1;
			while(j >= 0 && t < a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = t;
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[] { 25, 59, 73, 89, 90, 1, 3, 5, 7, 11, -1, 72, -8 }; // given array
		insertionSort(a);
		System.out.println(Arrays.toString(a));
	}
}
