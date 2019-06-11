package searching;

import java.util.Arrays;

public class BinarySearchRecursive {
	private static int binarySearchRecursive(int[] a, int x, int i, int j) {
		if (i > j) return -1;
		
		int k = (i + j) / 2;
		if (x == a[k]) return k;
		else if (x < a[k]) return binarySearchRecursive(a, x, i, k - 1);
		else return binarySearchRecursive(a, x, k + 1, j);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 5, 7, 11, 25, 59, 73, 89, 90 };
		int x = 91;
		int r = binarySearchRecursive(a, x, 0, a.length - 1);
		System.out.println("Result Recursive Search = " + r);
		
		// Inbuilt function
		r = Arrays.binarySearch(a, x);
		System.out.println("Result Inbuilt Arrays Function For Binary Search = " + r);
	}
}
