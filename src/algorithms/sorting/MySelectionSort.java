package algorithms.sorting;

import java.util.Arrays;

/*
  Selection sort works as follows:
  1. Begin with one pointer(i) at the start of the array
  2. Take a second pointer and run through i to end, to find the smallest element in this range
  3. Swap it with i
  4. Increment i
  5. and repeat 2-4 until the array is sorted
  
  Runtime Complexity:
    Passes:	      O(n)
    Comparisons:  O(n)
	Total:	      O(n^2)

 */

public class MySelectionSort {
  
  public static void main(String[] args) {
    int[] data = {3, 4, 7, 10, 12, -5, -20, 21, 19, -3};
    selectionSort(data);
    System.out.println(Arrays.toString(data));
  }
  
  public static void selectionSort(int[] data) {
    for (int slowRunner = 0; slowRunner < data.length - 1; slowRunner++) {
      // Find the smallest element in the range of slowRunner-end
      int minElement = data[slowRunner];
      int minElementIndex = slowRunner;
      for (int fastRunner = slowRunner + 1; fastRunner < data.length; fastRunner++) {
        if (minElement > data[fastRunner]) {
          minElement = data[fastRunner];
          minElementIndex = fastRunner;
        }
      }

      // do the swap if the smallest element in this range is not in place already
      if (minElementIndex != slowRunner) {
        data[minElementIndex] = data[slowRunner];
        data[slowRunner] = minElement;
      }
    }
  }
}
