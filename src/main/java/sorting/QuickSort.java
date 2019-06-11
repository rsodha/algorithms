package sorting;

import java.util.Arrays;

public class QuickSort {
	private static void quickSort(int[] a, int l, int h) {
		if(l < h) {
			int i = partition(a, l, h);
			quickSort(a, l, i);
			quickSort(a, i+2, h);
		}
	}

	private static int partition(int[] a, int l, int h) {
		int p = a[h]; // pivot
		int i = l - 1; 
		for(int j = l; j < h; j++) {
			if(a[j] <= p) {
				i++;
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		int t = a[i + 1];
		a[i + 1] = a[h];
		a[h] = t;
		return i;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 25, 59, 73, 89, 90, 1, 3, 5, 7, 11, -1, 72, -8 }; // given array
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
}
