import java.util.*;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 19, 100, -1, 5, 6, 87, -90 };
		/*
			p,q,j			  r  
			[ 19, -90, -1, 5, 6, 87, 100 ]
		 */
		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	public static int partition(int[] arr, int p, int r) {
		int q = p;
		for (int j = p; j < r; j++) {
			if (arr[j] < arr[r]) {
				swap(arr, j, q);
				q++;
			}
		}

		swap(arr, q, r);
		return q;
	}

	public static void sort(int[] arr, int p, int r) {
		if (p < r) {
			int q = partition(arr, p, r);
			//System.out.println(p + ", " + r);
			
			sort(arr, p, q - 1);
			sort(arr, q + 1, r);
		}
	}
}
