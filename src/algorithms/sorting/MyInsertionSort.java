package algorithms.sorting;

import java.util.Arrays;

/*
This sorting algorithm partitions the list into a sorted and unsorted sublist.
It assumes that the first element is sorted
and then repeatedly performs insertion of next element from the unsorted sublist
into the sorted sublist.

1. Passing: First next element in the unsorted part is taken and then compared with elements
in the sorted part one by one until a place is found for this new element
2. Shifting: Once the place is found, the elements greater than the current are shifted to the right
to make place for the next element
3.Element is inserted in the correct position and the process repeats until all elements are sorted

Runtime complexity:
Passing:  O(n)	O(n)
Shifting: O(1)	O(n)
Total:	  O(n)	O(n^2)

If the input list is already mostly sorted, using insertion sort might be a good idea.
 */
public class MyInsertionSort {
  
  public static void main(String[] args) {
    int[] data = {8, 3, 4, 1, 10, 11, 15, 2};
    insertionSort(data);
    System.out.println(Arrays.toString(data));
  }
 
  
  public static void insertionSort(int[] data) {
    
    for (int i = 1; i < data.length; i++) {
      /* take the next unsorted element -> data[i]
      insert it into the sorted sublist -> data[0..i-1]
      so that sublist[0..i] is now sorted. */
      int nextToSort = data[i];
      int newPosition = i;
      //shift the elements to find the place for the new element
      for (int j = i - 1; j >= 0 && data[j] > nextToSort; j--) {
        data[j + 1] = data[j];
        newPosition = j;
      }

      // Insert the current element into data[k+1]
      data[newPosition] = nextToSort;
    }
  }
}
