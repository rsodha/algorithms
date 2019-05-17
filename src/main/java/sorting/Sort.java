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
		printArray(a);
		// bubbleSort(a);
		// printArray(a);
		// optimizedBubbleSort(a);
		// printArray(a);
		// insertionSort(a);
		// mergeSort(a, 0, a.length - 1);
		quickSort(a, 0, a.length - 1);
		// heapSort(a);
		printArray(a);

	}

	private static void printArray(int[] a) {
		System.out.print("Array = ");
		for (int v : a)
			System.out.print(v + " ");
		System.out.println();
	}
}
