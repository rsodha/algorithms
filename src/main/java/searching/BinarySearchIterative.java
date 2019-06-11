package searching;

public class BinarySearchIterative {
	private static int binarySearchIterative(int[] a, int x, int i, int j) {
		while (i <= j) {
			int k = (i + j) / 2;
			if (x == a[k]) return k;
			else if (x < a[k]) j = k - 1;
			else i = k + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 5, 7, 11, 25, 59, 73, 89, 90 };
		int x = 3;
		int r = binarySearchIterative(a, x, 0, a.length - 1);
		System.out.println("Result Iterative Search = " + r);
	}
}
