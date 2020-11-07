package algorithms.searching;

/*
Linear search is the most basic searching algorithm
It works by taking each element from the collection and comparing it with the key
Once a match is found, the index where it was found is returned
If the element is not in the collection, -1 is returned
Runtime Complexity: O(n)
 */
public class MyLinearSearch {
  
  /** Returns: - the index of the key in the specified array
   * - -1 if no match was found*/
  public static int linearSearch(int key, int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (key == array[i])
        return i;
    }
    return -1;
  }
  
}
