import java.util.*;

public class Search{

	public boolean isOrdered(int[] data, int size){
		for(int i = 0; i < size-1; i++){
			if (data[i] > data[i+1])
				return false;
		}
		return true;
	}

	public int linearSearch(int key, int[] data, int size){
		int index = -1;
		for(int i = 0; i < size; i++){
			if(key == data[i]){
				index =i;
				return index;
			}
		}
		return index;
	}

	public int jumpSearch(int key, int[] data, int size){
		int stepSize = (int)Math.floor(Math.sqrt(size));
		int index = -1;
		for(int i = 0; i < size; i+= stepSize){
			if(key == data[i]){
				index = i;
				return index;
			}
			if(data[i] > key){
				index = linearSearch(key, Arrays.copyOfRange(data, i - stepSize, i),stepSize);
				return index;
			}
		}
		return index;

	}

	public int binarySearch(int key, int[] data, int size){
		int begin = 0;
		int end = size - 1;
		int mid;

		while(begin <= end){
			mid = (begin+end)/2;
			if(data[mid] == key)
				return mid;
			else if(data[mid] < key)
				begin = mid + 1;
			else
				end = mid -1;
		}

		return -1;	
	}

	public int interpolationSearch(int key, int[] data, int size){
		int begin = 0;
		int end = size - 1;
		int loc;

		while(begin <= end){
			loc = begin + ((end - begin)/(data[end] - data[begin])*(key - data[begin]));
			if(data[loc] == key)
				return loc;
			else if(data[loc] < key)
				begin = loc + 1;
			else
				end = loc - 1;
		}

		return -1;

	}

	public static void main(String[] args){
		int[] data = {0,1,2,3,4,5,6,7,8,9};

		Search test = new Search();

		System.out.println("isOrdered: " + test.isOrdered(data, 10));

		//Linear Search
		System.out.println("The number 4 is in Position " + test.linearSearch(4,data, 10));
		System.out.println("The number 10 is in Position " + test.jumpSearch(9,data, 10));
		System.out.println("The number 2 is in Position " + test.interpolationSearch(2,data, 10));

	}
}