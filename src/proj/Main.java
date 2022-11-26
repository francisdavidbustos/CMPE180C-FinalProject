/**
 * 
 */
package proj;

import java.util.concurrent.ForkJoinPool;
import java.util.Random;
import java.util.Date;

/**
 * @author francisdavidbustos
 *
 */
public class Main {
	
	static ForkJoinPool p = new ForkJoinPool();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		unitTests(10);
		unitTests(100);
		unitTests(1000);
		unitTests(10000);
		unitTests(100000);
		unitTests(1000000);
		unitTests(10000000);
		//unitTests(100000000);
	}
	
	/*
	 * inp: How long the array will be
	 */
	public static void unitTests(int inp) {
		Random rand = new Random();
		int[] arr = rand.ints(inp, 0, 10000).toArray();
		int[] arr2 = new int[arr.length];
		int[] arr3 = new int[arr.length];
		int[] arr4 = new int[arr.length];
		for (int j = 0; j < arr.length; j++) {
			arr2[j] = arr[j];
			arr3[j] = arr[j];
			arr4[j] = arr[j];
		}
		System.out.println("Array size: " + arr.length);
		if (arr.length < 100000) {
			Insertion a = new Insertion();
			int b = (int) new Date().getTime();
			a.insertionSort(arr);
			int c = (int) new Date().getTime();
			int d = c - b;
			System.out.println("Insertion: " + d);
			System.out.println();
			return;
		}
		ParallelInsertion x = new ParallelInsertion(arr);
		ParallelQuick i = new ParallelQuick(arr2, 0, arr2.length-1);
		Insertion y = new Insertion();
		//System.out.println("Before: " + Arrays.toString(arr3));
		int b = (int) new Date().getTime();
		y.mergeSort(arr3);
		int c = (int) new Date().getTime();
		int d = c - b;
		System.out.println("Naive Merge: " + d);
		//System.out.println("After: " + Arrays.toString(arr3));
		//System.out.println();
		//System.out.println("Before: " + Arrays.toString(arr));
		int e = (int) new Date().getTime();
		p.invoke(x);
		int f = (int) new Date().getTime();
		int g = f - e;
		System.out.println("ForkPool Merge: " + g);
		//System.out.println("After: " + Arrays.toString(arr));
		//System.out.println();
		//System.out.println("Before: " + Arrays.toString(arr4));
		b = (int) new Date().getTime();
		y.quickSort(arr4, 0, arr.length-1);
		c = (int) new Date().getTime();
		d = c - b;
		System.out.println("Naive Quick: " + d);
		//System.out.println("After: " + Arrays.toString(arr4));
		//System.out.println();
		//System.out.println("Before: " + Arrays.toString(arr2));
		e = (int) new Date().getTime();
		p.invoke(i);
		f = (int) new Date().getTime();
		g = f - e;
		System.out.println("ForkPool Quick: " + g);
		//System.out.println("After: " + Arrays.toString(arr3));
		System.out.println();
	}

}
