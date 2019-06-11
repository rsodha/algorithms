package sorting;

import java.util.Arrays;

public class HeapSort {
	private static void heapSort(int[] a) {
		for(int i = a.length / 2 - 1; i >= 0; i--)  // generate max heap
            heapify(a, a.length, i);
		
		for(int i = a.length - 1; i >= 0; i--) { // remove first element from heap and put on back and heapify reduced heap
			int t = a[0];
			a[0] = a[i];
			a[i] = t;
			heapify(a, i, 0);
		}
	}
	
	private static void heapify(int[] a, int n, int i) {
		int root = i; // index of largest element
		int l = 2 * i + 1; // left
		int r = 2 * i + 2; // right
		
		if(l < n && a[root] < a[l]) root = l;
		if(r < n && a[root] < a[r]) root = r;
		
		if(root != i) {
			int t = a[i];
			a[i] = a[root];
			a[root] = t;
			heapify(a, n, root); // heapify impacted child
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 25, 59, 73, 89, 90, 1, 3, 5, 7, 11, -1, 72, -8 }; // given array
		heapSort(a);
		System.out.println(Arrays.toString(a));
	}
}
