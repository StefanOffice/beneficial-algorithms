package algorithms.sorting;

import java.util.Arrays;

/*
     Quick sort algorithm works as follows:
     1. Take a certain element as the pivot
     2. Divides the elements in the array so that
        * elements <= pivot are on the right of the pivot
        * and elements > pivot are on the left of the pivot
     3. Then recursively do this on the right and left parts
     
     Like the merge sort this is another example of a divide-and-conquer approach
     See MyMergeSort for more info.
     
     Runtime Complexity:  BC          WC
     Partitioning		  O(n)	      O(n)
     # of times		      O(log n)	  O(n)
	 Total	              O(n log n)  O(n2)
     
     In the worst case, with bad pivot selection, the array is divided each time into one big sub-array and the other array empty
     But statistically the sizes of the two parts are close
     So the average runtime O(n log n) is more common.
     
 */

public class MyQuickSort {
    
    public static void main(String[] args) {
        int[] data = {8, 3, 4, 1, 10, 11, 15, 2};
        quickSort(data);
        System.out.println(Arrays.toString(data));
    }
    
    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }
    
    private static void quickSort(int[] data, int startIndex, int endIndex) {
        if (endIndex > startIndex) {
            int pivotIndex = partition(data, startIndex, endIndex);
            quickSort(data, startIndex, pivotIndex - 1);
            quickSort(data, pivotIndex + 1, endIndex);
        }
    }
    
    /**
     * Reorders the elements in the array
     * so that elements <= pivot are on the right of the pivot
     * and elements > pivot are on the left of the pivot
     * Returns: the index of the pivot
     */
    private static int partition(int[] data, int startIndex, int endIndex) {
        //Pivot selection can vary
        //I will use first element for the pivot in this example
        int pivot = data[startIndex];
        //start from the element after the pivot
        int lowIndex = startIndex + 1;
        //and start at the other side from the last element
        int highIndex = endIndex;
        
        //Start swapping elements based on the pivot
        while (highIndex > lowIndex) {
            // Go towards end - from start
            // Find an element greater than the pivot
            while (lowIndex <= highIndex && data[lowIndex] <= pivot)
                lowIndex++;
            
            // Go towards start - from end
            // Find an element smaller than the pivot(or equal)
            while (lowIndex <= highIndex && data[highIndex] > pivot)
                highIndex--;
            
            // Swap the two elements
            // put smaller element to the right side
            // and greater to the left
            if (highIndex > lowIndex) {
                int temp = data[highIndex];
                data[highIndex] = data[lowIndex];
                data[lowIndex] = temp;
            }
        }
        
        //navigate the highIndex to point to the leftmost element smaller than the pivot
        while (highIndex > startIndex && data[highIndex] >= pivot)
            highIndex--;
        
        // Final swap to put the pivot in place
        if (pivot > data[highIndex]) {
            data[startIndex] = data[highIndex];
            data[highIndex] = pivot;
            //return the pivots new index
            return highIndex;
        } else {
            //if the final swap didn't happen because pivot is the smallest of the selected elements
            //return it's original position
            return startIndex;
        }
    }
    
    
}
