package sorting;

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
		int[] a = new int[] { 25, 59, 73, 89, 90, 1, 3, 5, 7, 11, -1 }; // given array
		printArray(a);
		bubbleSort(a);
		printArray(a);
		optimizedBubbleSort(a);
		printArray(a);
	}

	private static void printArray(int[] a) {
		System.out.print("Array = ");
		for (int v : a)
			System.out.print(v + " ");
		System.out.println();
	}
}
