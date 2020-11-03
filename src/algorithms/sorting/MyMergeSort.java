package algorithms.sorting;

import java.util.Arrays;

/*
  Merge sort works by:
  1.Dividing the array into two parts
  2.Recursively applying merge sort on each part
  3.Merging them back together
  
  It's a good example of divide-and-conquer problem solving approach
    (breaking a big problem into a number of sub-problems,
    solve the smaller sub-problems
    and then combine the solutions of sub-problems to find the solution of the original problem)
  
  Runtime complexity:
  Dividing:  O(log n)
  Merging:   O(n)
  Total:	 O(n*log n)
  
  this algorithm is very efficient however it comes with a space cost
		
  Space complexity: O(n) - additional cost of all the sub-arrays
  All the other arrays created combined take as much memory as the original array


 */
public class MyMergeSort {
  

  public static void main(String[] args) {
    int[] data = {7, 11, -4, 15, -30, 1, 2, 8, 100, 11};
    mergeSort(data);
    System.out.println(Arrays.toString(data));
  }
  
  
  public static void mergeSort(int[] data) {
    if (data.length > 1) {
      // Recursively call the method on first part
      int part1Length = data.length / 2;
      int[] part1 = new int[part1Length];
      System.arraycopy(data, 0, part1, 0, part1Length);
      mergeSort(part1);
  
      // Recursively call the method on second part
      int part2Length = data.length - part1Length;
      int[] part2 = new int[part2Length];
      System.arraycopy(data, data.length / 2, part2, 0, part2Length);
      mergeSort(part2);

      // Combine the first part with second part into data
      merge(part1, part2, data);
    }
  }

  /** Merge two sorted lists */
  public static void merge(int[] part1, int[] part2, int[] combinedData) {
    int currentP1 = 0; // Current index in part1
    int currentP2 = 0; // Current index in part2
    int currentC = 0; // Current index in combinedData

    while (currentP1 < part1.length && currentP2 < part2.length) {
      //take the smaller element and place it at the start of combinedData
      //this repeats until all elements from any one of the parts are copied back to combinedData
      if (part1[currentP1] < part2[currentP2])
        combinedData[currentC++] = part1[currentP1++];
      else
        combinedData[currentC++] = part2[currentP2++];
    }
    
    //then copy the rest of the elements from the part that has any content left
    while (currentP1 < part1.length)
      combinedData[currentC++] = part1[currentP1++];

    while (currentP2 < part2.length)
      combinedData[currentC++] = part2[currentP2++];
  }
  
}
