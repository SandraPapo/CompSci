import java.util.HashMap;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class Q1{
	public static void main(String args[]){
		HashMap<Integer, String> myMap = new HashMap<Integer, String>();
		myMap.put(1, "Sandra");
		myMap.put(2, "Leah");
		myMap.put(3, "Rosario");
		System.out.println(myMap);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(0,2);
		System.out.println(numbers);
		StringBuilder sentance = new StringBuilder();
		sentance.append(1);
		sentance.append(' ');
		sentance.append(false);
		System.out.println(sentance.toString());
		System.out.println(isUnique("SAndra"));
		System.out.println(checkPermutation("s","s"));
	}

	static public boolean isUnique(String s){
		int length = s.length();
		if(length > 26){
			return false;
		}
		boolean[] alphabet = new boolean[26];
		s = s.toLowerCase();
		for(int i = 0; i < length; i++){
			char currentCharacter = s.charAt(i);
			int index = (int)(currentCharacter - 'a');
			if(alphabet[index] == false){
				alphabet[index] = true;
			}
			else{
				return false;
			}
		} 
		return true;
	}

	static public boolean checkPermutation(String s, String t){
		if (s.length() != t.length()){
			return false;
		}
		char[] sorted1 = s.toCharArray();
		char[] sorted2 = t.toCharArray();
		java.util.Arrays.sort(sorted1);
		java.util.Arrays.sort(sorted2);
		return sorted1.equals(sorted2);

	}

}