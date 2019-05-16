package searching;

public class BinarySearch {
	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 5, 7, 11, 25, 59, 73, 89, 90}; // Given array
		int x = 73; // Search value
		int r; // Result 
		r = binarySearchRecursive(a, x, 0, a.length - 1); 
		r = binarySearchIterative(a, x, 0, a.length - 1); 
		System.out.println("Result = " + r);
	}

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
}
