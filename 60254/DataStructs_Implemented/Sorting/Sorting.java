import java.util.Arrays;

public class Sorting {
	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1 ;i++ ) {
			for (int j = i + 1; j < a.length; j++ ) {
				System.out.println(Arrays.toString(a));
				if (a[j] < a[i]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	public static void insertionSort(int[] a) {
		for (int i = 0; i < a.length - 1 ;i++ ) {
			int temp = a[i];
			for (int j = i; j>0 && temp < a[j-1] ;j-- ) {
				a[j] = a[j-1];	
			}	
			a[j] = temp
		}
	}

	public static void mergeSort(int[] a, int first, int last) {
		if (first < last) {
			int mid = (first + last)/2;
			mergeSort(a, first, mid);
			mergeSort(a, mid+1, last);
			merge(a, first, mid, last);
		}
	}
	
	public static void quickSort(int[] a, int low, int high) {
		if(low<high) {
			pi
		}
	}

	public static void main(String[] args) {
		int[] a = {4,3,2,1};
		selectionSort(a);
		System.out.println(Arrays.toString(a));
		
	}
}