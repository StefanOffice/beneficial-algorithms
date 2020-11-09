package algorithms.searching;


import java.util.Arrays;

/*
        Jump search is another search algorithm that can be used only with sorted arrays, the way it works is:
        1. Jump ahead a certain number of indexes
        2. Check if the key is >= to the element at the current index
            2a. if yes inspect the block starting at index before the jump and ending at the current index
                if the element is not here then it's not in the array.
            2b. if no repeat steps 1 and 2.
      
      Runtime Complexity:
        It's not that straightforward with this algorithm as the runtime complexity will depend on
        1. Jump size
        2. The other search algorithm used to search the block
        
 */

public class MyJumpSearch {
    
    public static void main(String[] args) {
        int[] data = new int[(int)(Math.random() * 50) + 5];
        data[0] = 0;
        for (int i = 1; i < data.length; i++) {
            data[i] = data[i - 1] + (int) (Math.random() * 20) + 1;
        }
        
        int key = data[(int)(Math.random() * data.length)];
        
        int index = jumpSearch(data, key, (int) Math.floor(Math.sqrt(data.length)));
        
        System.out.println("\nNumber " + key + " is at index " + index);
        System.out.println(Arrays.toString(data));
    }
    
    
    public static int jumpSearch(int[] data, int key, int stepSize) {
        // Finding the block where element is
        // present (if it is present)
        int blockStartIndex = 0;
        int blockEndIndex = stepSize;
        while (data[Math.min(blockEndIndex, data.length) - 1] < key) {
            blockStartIndex = blockEndIndex;
            blockEndIndex = blockEndIndex + stepSize;
            if (blockStartIndex >= data.length)
                return -1;
        }
        
        // any search algorithm can be used here to search the specified block
        //to keep it simple i will demonstrate combination with linear search
        while (data[blockStartIndex] < key) {
            //search only the specified block, if it's not here it's not in the array
            //need to use math min here as blockEndIndex can go over the length of data
            blockStartIndex++;
            if (blockStartIndex == Math.min(blockEndIndex, data.length))
                return -1;
        }
        
        if (data[blockStartIndex] == key)
            return blockStartIndex;
        else
            return -1;
    }
    
}