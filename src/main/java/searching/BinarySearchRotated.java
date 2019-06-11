package searching;

public class BinarySearchRotated {
	private static int binarySearchRotated(int[] a, int x, int i, int j) {
		if (i > j) return -1;
		int k = (i + j) / 2;
		if (x == a[k]) return k;
		else if (a[i] <= a[k]) {
			// first half is sorted
			if (a[i] <= x && x < a[k]) 
				// key is in sorted half
				return binarySearchRotated(a, x, i, k - 1);
			else 
				// key is in rotated half
				return binarySearchRotated(a, x, k + 1, j);
		} else {
			if (a[k] < x && x <= a[j])
				// key is in sorted half
				return binarySearchRotated(a, x, k + 1, j);
			else
				// key is in rotated half
				return binarySearchRotated(a, x, i, k - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[] { 7, 11, 25, 59, 73, 89, 90, 1, 3, 5 };
		int x = 1;
		int r = binarySearchRotated(a, x, 0, a.length - 1);
		System.out.println("Result Rotated Array Search = " + r);
	}
}
