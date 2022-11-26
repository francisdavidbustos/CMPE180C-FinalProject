package proj;

import java.util.concurrent.RecursiveAction;

public class ParallelQuick extends RecursiveAction {

	private static final long serialVersionUID = 1L;
	private int[] arr;
	private int a, b;
	
	/*
	 * Constructor
	 */
	public ParallelQuick(int[] arr) {
		this.arr = arr;
		a = 0;
		b = arr.length - 1;
	}
	
	/*
	 * Constructor
	 */
	public ParallelQuick(int[] arr, int a, int b) {
		this.arr = arr;
		this.a = a;
		this.b = b;
	}

	/*
	 * Call this to invoke quick sort via multithreading
	 */
	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		if (a < b) {
			int pivot = partition(arr, a, b);
			invokeAll(new ParallelQuick(arr, a, pivot - 1),
					new ParallelQuick(arr, pivot + 1, b));
		}
		
		
	}
	
	/*
	 * arr: The array which will swap elements
	 * a: The index whose element will be swapped
	 * b: The index whose element will be swapped
	 */
	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	/*
	 * arr: The array to perform an array partition
	 * a: The starting index
	 * b: The ending index
	 * Returns the index whose element should be swapped
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

}
