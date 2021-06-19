import java.util.*;

public class RecursionTotalItem {
	public static void main(String[] args) {
		int[] arr = { 2, 4, 6 };
		System.out.println(Arrays.toString(arr) + " has length " + size(arr));
	}

	public static int size(int[] arr) {
		// Base case
		if (arr.length == 0) return 0;

		// Recursive case
		return 1 + size(Arrays.copyOfRange(arr, 1, arr.length));
	}
}
