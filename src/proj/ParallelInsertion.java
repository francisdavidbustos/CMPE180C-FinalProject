package proj;

import java.util.concurrent.RecursiveAction;
import java.util.Arrays;

public class ParallelInsertion extends RecursiveAction {
	
	private static final long serialVersionUID = 1L;
	public final int[] arr;
	
	/*
	 * Constructor
	 */
	public ParallelInsertion(int[] arr) {
		this.arr = arr;
	}

	/*
	 * Call this to invoke merge sort via multithreading
	 */
	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		int len = arr.length;
		
		if (len < 2) {
			return;
		}
		int[] a = Arrays.copyOfRange(arr, 0, (len/2));
		int[] b = Arrays.copyOfRange(arr, (len/2), len);
		
		invokeAll(new ParallelInsertion(a), new ParallelInsertion(b));
		merge(a,b);
		
	}
	
	/*
	 * Combines and sorts arrays a and b, which are already sorted
	 */
	private void merge(int[] a, int[] b) {
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			if(a[i] < b[j]) {
				arr[k++] = a[i++];
			}
			else {
				arr[k++] = b[j++];
			}
		}
		while (i < a.length) {
			arr[k++] = a[i++];
		}
		while (j < b.length) {
			arr[k++] = b[j++];
		}
	}

}
