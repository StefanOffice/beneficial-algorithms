package algorithms.sorting;

import java.util.Arrays;

/*
  Bubble sort works by passing the array multiple times
  On each pass it swaps the two neighbour elements if they are not in order
  So the largest element(in this implementation) of each pass 'bubbles up' to its sorted place
    - hence where the algorithm got the name.
  
  Runtime Complexity:
              BC    WC
  Passes      O(1)  O(n)
  Comparisons O(n)	O(n)
  Total	      O(n)	O(n^2)

 */
public class MyBubbleSort {
  
  public static void main(String[] args) {
    int[] data = new int[(int)(Math.random() * 50) + 5];
    for (int i = 1; i < data.length; i++) {
      data[i] = (int) (Math.random() * 200) + 1;
    }
    bubbleSort(data);
    System.out.println(Arrays.toString(data));
  }
  
  public static void bubbleSort(int[] data) {
    boolean needNextPass = true;
  
    for (int i = 1; i < data.length && needNextPass; i++) {
      // this is a little optimization
      // for the case that the array is sorted at this point
      needNextPass = false;
      
      for (int j = 0; j < data.length - i; j++) {
        if (data[j] > data[j + 1]) {
          // Swap the neighbours if they are not in order
          int temp = data[j];
          data[j] = data[j + 1];
          data[j + 1] = temp;
  
          // in case even one swap happens
          // the we pass the array again
          needNextPass = true;
          System.out.println(Arrays.toString(data));
        }
      }
    }
  }
  
}
