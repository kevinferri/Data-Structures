package prep;

import java.util.*;

public class Teasers {
  public static void main(String[] args) {
    int[][] nums = {{1, 1, 100}, {5, 5, 5}, {2, 2, 2}};
    System.out.println(findBiggestRow(nums));
  }
  
  
  // 1.1 is the string unique?
  public static boolean isUnique(String str) {
    if (str.length() > 256) return false;
    
    boolean[] charList = new boolean[256];
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i);
      if (charList[val]) { // Already set this char to true so we already have seen it
        return false;
      }
      charList[val] = true;
    }
    return true;
  }
  
  // 1.2 reverse a string
  public static String reverseString(String str) {
    String reversed = "";
    for (int i = str.length() - 1; i >= 0; i--) {
      reversed += str.charAt(i);
    }
    return reversed;
  }
  
  // reverse an array in place
  public static void reverse(int[] a) {
    for (int i = 0; i < a.length / 2; i++) {
      int temp = a[i];
      a[i] = a[a.length - 1 - i];
      a[a.length - 1 - i] = temp;
    }
      System.out.println(Arrays.toString(a));
  }
  
  // 1.3 decide if one string is a permutation of the other
  
  //  helper for 1.3
  public static String sortString(String s) {
    char[] content = s.toCharArray();
    java.util.Arrays.sort(content);
    return new String(content);
  }
  
  public static boolean isPermutation(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    
    return sortString(s1).equals(sortString(s2));
  }
  
  // 1.4 replace blank space with '%20'
  public static String replaceSpaces(char[] str) {
    int spaceCount = 0, newLength, currIndex;
    
    for (int i = 0; i < str.length; i++) {
      if (str[i] == ' ') {
        spaceCount++;
      }
    }
    
    newLength = str.length + spaceCount * 2;
    char[] newStr = new char[newLength];
    currIndex = newStr.length - 1;
    
    for (int j = str.length - 1; j >= 0; j--) {
      if (str[j] == ' ') {
        newStr[currIndex] = '0';
        newStr[currIndex - 1] = '2';
        newStr[currIndex - 2] = '%';
        currIndex = currIndex - 3;
      } else {
        newStr[currIndex] = str[j];
        currIndex--;
      }
    }

    return new String(newStr);
  }
  
  // 1.5 compress strings aabcccccaaa => a2b1c5a3
  public static String compressString (String s) {
    int count = 0;
    String compressedString = "";
    String prevVal = s.substring(0, 1);
    
    for (int i = 0; i < s.length(); i++) {
      if (s.substring(i, i + 1).equals(prevVal)) {
        count++;
        prevVal = s.substring(i, i + 1);
        if (i == s.length() - 1) { // if it is the last element, we need to add it to the final string
          compressedString += (prevVal + Integer.toString(count));
        }
      } else {
        compressedString += (prevVal + Integer.toString(count));
        prevVal = s.substring(i, i + 1);
        count = 1;
        if (i == s.length() - 1) { // if it is the last element, we need to add it to the final string
          compressedString += (prevVal + Integer.toString(count));
        }
      }
    }
      return compressedString;
  }
  
  // 1.6 rotate a matrix right
  public static int[][] rotateMatrixRight(int[][] matrix) {
    // W and H are already swapped
    int h = matrix[0].length;
    int[][] ret = new int[h][matrix.length];
    for (int i = 0; i < h; ++i) {
      for (int j = 0; j < matrix.length; ++j) {
        ret[i][j] = matrix[matrix.length - j - 1][i];
      }
    }
    return ret;
  }
  
  // 1.8 check if one string is a rotation of the other waterbottle => erbottlewat
  
  // helper for isRotation
  public static boolean isSubstringString(String str1, String str2) {
    return str1.toLowerCase().contains(str2.toLowerCase());
  }
  
  public static boolean isRotation(String s1, String s2) {
    if (s1.length() == s2.length() && s1.length() > 0) {
      String s1s1 = s1 + s1;
      return isSubstringString(s1s1, s2);
    }
    return false;
  }
  
  public static void switchXO(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int k = 0; k < board.length; k++) {
        if (board[i][k] == 'x') {
          board[i][k] = '0';
          System.out.print(board[i][k]);
        } else {
          board[i][k] = '7';
          System.out.print(board[i][k]);
        }
      }
    }
  }
  
  public static int[] removeStreaks(int[] a) {
    int totalStreaks = 0;
    int currentStreak = 0;
    
    for (int i = 0; i < a.length; i++) {
      if (i == a.length - 1) break;
      if (a[i] == a[i+1]) {
        totalStreaks++;
      }
    }
    
    int[] removed = new int[a.length - totalStreaks];

    for (int i = 0; i < a.length; i++) {
      if (i == a.length - 1) {
        removed[i - currentStreak] = a[i];
        break;
      }
      
      if (a[i] == a[i+1]) {
        currentStreak++;
      } else {
        removed[i - currentStreak] = a[i];

      }
    }
    return removed;
  }
  
  public static boolean isSubstring(String s1, String s2) {
    int len = s1.length();
    for (int i = 0; i < s2.length(); i++) {
      if (i + len > s2.length()) return false;
      if (s1.equals(s2.substring(i, i + len))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean sumTwoNums(int[] nums, int sum) {
    java.util.Arrays.sort(nums);
    
    int left = nums[0];
    int right = nums[nums.length - 1];
    int leftCount = 0;
    int rightCount = 0;
    
    for (int i = 0; i < nums.length; i++) {
      if (left == right) {
        return false;
      }

      if (left + right == sum) {
        return true;
      }

      if (left + right > sum) {
        rightCount++;
        right = nums[nums.length - 1 - rightCount];
      } else if (left + right < sum) {
        leftCount++;
        left = nums[leftCount] ;
      }

    }

    return false;
  }
  
  public static void InsertionSort(int[] num) {
    int j; // the number of items sorted so far
    int key; // the item that needs to be sorted
    int i;  
    
    for (j = 1; j < num.length; j++) {
      key = num[j];
      
      for(i = j - 1; (i >= 0) && (num[i] < key); i--) {
        num[i+1] = num[i];
      }
      
      num[i+1] = key;
       }
  }
  
  public static int findBiggestRow(int[][] matrix) {
    int newSum = 0;
    int biggestSum = 0;
    
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        newSum += matrix[i][j];
      }
      if (newSum > biggestSum) {
        biggestSum = newSum;
      }
      newSum = 0;
    }
    return biggestSum;
  }
  
  public static int countWays(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }
  }
}
