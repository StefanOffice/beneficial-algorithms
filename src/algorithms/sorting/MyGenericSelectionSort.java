package algorithms.sorting;

import java.util.Arrays;

/*
  This is same as MySelectionSort but reworked as a generic method to accept any type
  for details about selection sort look at MySelectionSort class
 */

public class MyGenericSelectionSort {
  public static void main(String[] args) {
  
  
    String[] fruits = {"Peach", "Apple", "Strawberry", "Banana" };
    Integer[] ints = {7, 11, -5, 20, 19, 17};
    Float[] floats = {99.99f, -33.75f, 21.12f};
    Character[] chars = {'m', 'K', 'h', 'n', 'R', 'a'};
  
    System.out.println("Strings before sorting :" + Arrays.toString(fruits));
    genericSelectionSort(fruits);
    System.out.println("Strings after sorting: " + Arrays.toString(fruits) + "\n");
  
    System.out.println("Ints before sorting: " + Arrays.toString(ints));
    genericSelectionSort(ints);
    System.out.println("Ints after sorting: " + Arrays.toString(ints) + "\n");
  
    System.out.println("Floats before sorting: " + Arrays.toString(floats));
    genericSelectionSort(floats);
    System.out.println("Floats after sorting: " + Arrays.toString(floats) + "\n");
  
    System.out.println("Chars before sorting: " + Arrays.toString(chars));
    genericSelectionSort(chars);
    System.out.println("Chars after sorting: " + Arrays.toString(chars) + "\n");
    
  }

  /** Sort an array of comparable objects */
  public static <E extends Comparable<E>> void genericSelectionSort(E[] data) {
    E minElement;
    int minElementIndex;
    // Find the smallest element in the range of slowRunner - end
    for (int slowRunner = 0; slowRunner < data.length - 1; slowRunner++) {
      minElement = data[slowRunner];
      minElementIndex = slowRunner;
      for (int fastRunner = slowRunner + 1; fastRunner < data.length; fastRunner++) {
        if (minElement.compareTo(data[fastRunner]) > 0) {
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
