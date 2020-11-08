package algorithms.searching;


/*
Binary search algorithm provides efficient way to search for a key in a collection
It works only on sorted collections.
It starts out by comparing the middle element in the collection with the key
  If compared element matches the key its index is returned
  If compared element is greater/(smaller) than the key HALF of the collection is eliminated from the search
    and only the elements that come after/(before) the compared element are taken into consideration for next comparison
  
  This makes finding a key in a collection possible in logarithmic time
  (Simple way to visualize it is to think how many times can a number of items in the collection be divided by 2)
  Which means that finding a key in a collection of 1_000_000 items takes ~20 comparisons in worst case
  and linear search would take 1_000_000
  Runtime Complexity: O(log n)
 */
public class MyBinarySearch {
  
  
  public static int binarySearch(int[] array, int key) {
    int first = 0;
    int last = array.length - 1;

    while (last >= first) {
      /*instead of using
          int mid = (first + high) / 2;
       it's better to use the line below to avoid integer overflow */
      int mid = first + (last - first)/2;
      
      if (key < array[mid])
        last = mid - 1;
      else if (key == array[mid])
        return mid;
      else
        first = mid + 1;
    }
  
    //returns where the element would go if it was in the collection
    // if this returns -4 for example then the item would be at index 3 if it was in the collection
    return -first - 1;
  }
  
}
