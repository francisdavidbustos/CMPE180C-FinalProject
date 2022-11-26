package proj;

import java.util.Arrays;

public class Insertion implements Sort{
	
	public Insertion() {
	}
	
	/*
	 * arr: The array to perform quickSort on
	 * a: The starting index
	 * b: The last index
	 */
	@Override
	public void quickSort(int[] arr, int a, int b) {
		// TODO Auto-generated method stub
		if (a < b) {
			int pivot = partition(arr, a, b);
			quickSort(arr, a, pivot - 1);
			quickSort(arr, pivot + 1, b);
		}
	}
	
	/*
	 * arr: The array which will swap elements at indices
	 * a: The first index
	 * b: The second index
	 */
	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	/*
	 * arr: The array to perform partition on
	 * a: The lower index
	 * b: The higher index
	 * Returns the index to swap in arr
	 */
	private int partition(int[] arr, int a, int b) {
		int pivot = arr[b];
		
		int i = (a - 1);
		
		for (int j = a; j <= b; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, b);
		return (i + 1);
	}
	
	/*
	 * arr: The array to perform mergeSort on
	 */
	@Override
	public void mergeSort(int[] arr) {
		// TODO Auto-generated method stub
		int len = arr.length;
		if (len < 2) {
			return;
		}
		int[] a = Arrays.copyOfRange(arr, 0, (len/2));
		int[] b = Arrays.copyOfRange(arr, len/2, len);
		
		
		mergeSort(a);
		mergeSort(b);
		merge(arr, a, b);
	}
	
	/*
	 * merge: The array which will combine two arrays
	 * a: The first sorted array to combine
	 * b: The second sorted array to combine
	 */
	private void merge(int[] merge, int[] a, int[] b) {
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				merge[k] = a[i];
				i++;
			}
			else {
				merge[k] = b[j];
				j++;
			}
			k++;
		}
		while (i < a.length) {
			merge[k] = a[i];
			k++;
			i++;
		}
		while (j < b.length) {
			merge[k] = b[j];
			k++;
			j++;
		}
	}

	/*
	 * arr: The array to perform insertionSort on
	 */
	@Override
	public void insertionSort(int[] arr) {
		// TODO Auto-generated method stub
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			int key = arr[i];
			int j = i - 1;
			
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}
}
