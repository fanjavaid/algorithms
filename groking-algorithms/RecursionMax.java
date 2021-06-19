import java.util.*;

public class RecursionMax {
	public static void main(String[] args) {
		int[] arr = { 4, 2, 6 };
		System.out.println("Max number in "+ Arrays.toString(arr) + " is " + max(arr));		
	}

	public static int max(int[] arr) {
		// Base case
		if (arr.length == 1) return arr[0];
		
		/*
		int currentMax = arr[0];
		int x = max(Arrays.copyOfRange(arr, 1, arr.length));
		if (x > currentMax) {
			currentMax = x; 
		}*/

		int currentMax = Math.max(arr[0], max(Arrays.copyOfRange(arr, 1, arr.length)));
		return currentMax;
	}
}
