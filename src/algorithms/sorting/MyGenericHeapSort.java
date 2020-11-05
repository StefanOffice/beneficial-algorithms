package algorithms.sorting;

import datastructures.MyGenericHeap;
import java.util.Arrays;
import java.util.Comparator;

/*
  This is just a demonstration what can be done using heaps,
  This algorithm has a simple job:
  1. place the elements in the heap
  2. take them out sorted
  all the actual work is being done in the heap
  for more explanation of how the heap works, (or other data structures)
  look at my MyGenericHeap copied over from my other project with data structures implementations
  
 */

public class MyGenericHeapSort {
  
  public static void main(String[] args) {
    Integer[] data = {8, 3, 4, 1, 10, 11, 15, 2};
    heapSort(data);
    System.out.println(Arrays.toString(data));
  }
  
  /** To sort with a provided comparator */
  public static <E extends Comparable<E>> void heapSort(E[] data, Comparator<E> comparator) {
    MyGenericHeap<E> tempHeap = new MyGenericHeap<>(comparator);
  
    for (E element : data)
      tempHeap.add(element);

    for (int i = data.length - 1; i >= 0; i--)
      data[i] = tempHeap.remove();
  }
  
  /** To sort in natural order */
  public static <E extends Comparable<E>> void heapSort(E[] list) {
    heapSort(list, Comparator.naturalOrder());
  }
  
}
