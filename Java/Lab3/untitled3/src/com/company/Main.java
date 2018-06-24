package com.company;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        System.out.println(isUniqueChars("hello"));
        System.out.println(Integer.toBinaryString( 1<<10));
        char[] cStyle = {'S','a','a','a','\0'};
        int[][] test = {{1,2,3,4},{5,6,7,8},{9,1,2,3},{4,5,6,7}};
        reverseString(cStyle);
        removeDuplicates(cStyle);
        System.out.println(cStyle);
        System.out.println(anagram("Sandra","anSdrr"));
        //replaceSpaces(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(Arrays.toString(test[i]));
        }
        rotate(test, test.length);
        System.out.println();
        for (int i = 0; i < test.length; i++) {
            System.out.println(Arrays.toString(test[i]));
        }
	// write your code here
    }
//1.1
    public static boolean isUnique(String s) {
        boolean[] alphabet = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i)])
                return false;
            else {
                alphabet[s.charAt(i)] = true;
            }
        }
        return true;
    }
    public static boolean isUniqueChars(String s) {
        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentValue = s.charAt(i) - 'a';
            if ((checker & (1 << currentValue)) != 0 )
                return false;
            checker |= ( 1 << currentValue);
        }
        return true;
    }
    //1.2
    public static void reverseString(char[] myString) {
        int endIndex = myString.length - 2;
        for (int i = 0; i <= endIndex/2 ; i++) {
            char temp = myString[i];
            myString[i] = myString[endIndex - i];
            myString[endIndex - i] = temp;
        }
    }
    //1.3
    public static void removeDuplicates(char[] str) {
        boolean[] check = new boolean[256];
        check[str[0]] = true;
        int tail = 1;
        for (int i = 1; i < str.length - 1; i++) {
            if (check[str[i]] != true){
                str[tail] = str[i];
                tail++;
                check[str[i]] = true;
            }

        }
        for (int i = tail; i < str.length; i++){
            str[i] = '\0';
        }
    }
    //1.4
    public static boolean anagram(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        int[] allUnicode = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            allUnicode[str1.charAt(i)]++;
            allUnicode[str2.charAt(i)]--;
        }
        for (int num : allUnicode)
            if (num != 0 )
                return false;

        return true;
    }
    //1.5
    public static void replaceSpaces(char[] str) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' '){
                for (int j = str.length - 1; j >= i; j++){
                    str[j+2] = str[j];
                    if (j == i)
                        str[j] = '%';
                    else if (j == i + 1)
                        str[j] = '2';
                    else if (j == i + 2)
                        str[j] = '0';
                }
            }

        }
    }

    //1.6
    public static void rotate(int[][] matrix, int n) {
        for (int i = 0; i < n / 2; i++) {
            for (int j  = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}
