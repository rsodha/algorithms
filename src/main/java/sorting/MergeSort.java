package sorting;

import java.util.Arrays;

public class MergeSort {
	private static void mergeSort(int[] a, int l, int r) {
		if(l < r) {
			int m = (l + r) / 2;
			mergeSort(a, l, m);
			mergeSort(a, m + 1, r);
			
			// merge sorted arrays
			int[] a1 = new int[m - l + 1];
			int[] a2 = new int[r - m];
			for(int i = 0; i < a1.length; i++)
				a1[i] = a[l + i];
			for(int j = 0; j < a2.length; j++)
				a2[j] = a[m + 1 + j];
			
			int i = 0, j = 0, k = l;
			while(i < a1.length && j < a2.length)
				if(a1[i] < a2[j])
					a[k++] = a1[i++];
				else
					a[k++] = a2[j++];

			while(i < a1.length)
				a[k++] = a1[i++];
			while(j < a2.length)
				a[k++] = a2[j++];
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[] { 25, 59, 73, 89, 90, 1, 3, 5, 7, 11, -1, 72, -8 }; // given array
		mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
}
