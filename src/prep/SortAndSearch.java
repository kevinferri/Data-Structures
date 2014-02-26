package prep;

import java.util.*;

public class SortAndSearch {

	// < descending  |  > ascending
	
	// BEST CASE: O(n)  |  WORST CASE: O(n^2)  |  AVERAGE CASE O(n^2)
	public static void bubbleSort(int[] a) {
		for (int i = a.length - 1; i > 1; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j]  > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	// BEST CASE: O(n^2)  |  WORST CASE: O(n^2)  |  AVERAGE CASE O(n^2)
	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			
			for (int k = i; k < a.length; k++) {
				if (a[min] > a[k]) {
					min = k;
				}
			}
			
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
	}
	
	// BEST CASE: O(1)  |  WORST CASE: O(n^2)  |  AVERAGE CASE O(n^2)
	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int k = i;
			int toInsert = a[i];
			
			while ((k > 0) && a[k-1] > toInsert) {
				a[k] = a[k-1];
				k--;
			}
			
			a[k] = toInsert;
		}
	}
	
	public static void quickSort(int[] a, int pivot) {
	}
	
	// BEST CASE: O(1)  |  WORST CASE: O(1)  |  AVERAGE CASE O(log n)
	public static void binarySearch(int a[], int value) {
		int lowIndex = 0;
		int highIndex = a.length - 1;
		
		while(lowIndex <= highIndex){
			
			int middleIndex = (highIndex + lowIndex) / 2;
			
			if(a[middleIndex] < value) {
				lowIndex = middleIndex + 1;
			}
			
			else if(a[middleIndex] > value) {
				highIndex = middleIndex - 1;
			}

			else {
				System.out.println("\nFound a Match for " + value + " at Index " + middleIndex);
				lowIndex = highIndex + 1;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 4, 2, 5, 1};
		insertionSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}