package sorting;

public class Sort {
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
				if(a1[i] < a2[j]) {
					a[k++] = a1[i++];
				} else {
					a[k++] = a2[j++];
				}

			while(i < a1.length)
				a[k++] = a1[i++];
			while(j < a2.length)
				a[k++] = a2[j++];
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 25, 59, 73, 89, 90, 1, 3, 5, 7, 11, -1, 72 }; // given array
		printArray(a);
		// bubbleSort(a);
		// printArray(a);
		// optimizedBubbleSort(a);
		// printArray(a);
		// insertionSort(a);
		mergeSort(a, 0, a.length - 1);
		printArray(a);

	}

	private static void printArray(int[] a) {
		System.out.print("Array = ");
		for (int v : a)
			System.out.print(v + " ");
		System.out.println();
	}
}
