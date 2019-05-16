package searching;

public class BinarySearch {
	private static int binarySearchRecursive(int[] a, int x, int i, int j) {
		if(i > j) return -1;
		int k = (i + j) / 2;
		if(x == a[k]) return k;
		else if (x < a[k]) return binarySearchRecursive(a, x, i, k - 1);
		else return binarySearchRecursive(a, x, k + 1, j);
	}
	
	private static int binarySearchIterative(int[] a, int x, int i, int j) {
		while(i <= j) {
			int k = (i + j) / 2;
			if(x == a[k]) return k;
			else if (x < a[k]) j = k - 1;
			else i = k + 1;
		}
		return -1;
	}
	
	private static int binarySearchRotated(int[] a, int x, int i, int j) {
		if(i > j) return -1;
		int k = (i + j) / 2;
		if(x == a[k]) return k;
		else if(a[i] <= a[k]) { // first half is sorted
			if(a[i] <= x && x < a[k]) return binarySearchRotated(a, x, i, k - 1); // key is in sorted half
			else return binarySearchRotated(a, x, k + 1, j); // key is in rotated half 
		} else {
			if(a[k] < x && x <= a[j]) return binarySearchRotated(a, x, k + 1, j); // key is in sorted half
			else return binarySearchRotated(a, x, i, k - 1); // key is in rotated half 
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 5, 7, 11, 25, 59, 73, 89, 90}; // Given array
		int x = 1; // Search value
		int r; // Result 
		r = binarySearchRecursive(a, x, 0, a.length - 1); 
		System.out.println("Result Recursive Search = " + r);
		
		r = binarySearchIterative(a, x, 0, a.length - 1); 
		System.out.println("Result Iterative Search = " + r);
		
		// a = new int[] { 59, 73, 89, 90, 91, 3, 5, 7, 11, 25}; // Given array
		a = new int[] {4, 1, 2, 3, 4, 4, 4, 4, 4, 4}; // this corner case not handled
		r = binarySearchRotated(a, x, 0, a.length - 1); 
		System.out.println("Result Rotated Array Search = " + r);
	}
}
