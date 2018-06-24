import java.util.Arrays;
import java.util.ArrayList;

/*Write a Java method that takes two integer arrays of equal length and return an integer array from the addition of the corresponding elements.

The method header is:

public static boolean matchCheck(int [] a, int [] b)*/

public class Activities{
	public static void main(String[] args){
		int[] myArray = {1,2,3,4,5,6};
		int[] add = {1,1,1,1,1,1};
		ArrayList<Integer> myList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6)); 
		myArray = matchCheck(myArray, add);
		System.out.println(Arrays.toString(myArray) + " " + myList);
	}
	


	public static int[] addition(int[] array){
		int size = array.length;
		int temp;
		for(int i = 0; i < size/2; i++){
			temp = array[i];
			array[i] = array[size - 1 - i];
			array[size - 1 - i] = temp;
		}
		return array;
	}

	public static int[] matchCheck(int [] a, int [] b){
		int size = a.length;
		int[] sum = new int[size];
		for(int i = 0; i < size; i++){
			sum[i] = a[i] + b[i];
		}
		return sum;
	}





}