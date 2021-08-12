# Beneficial algorithms

Welcome to another one of my study projects :smile:  
This time the examples include my java implementations of commonly used algorithms for searching and sorting, as well as some other algorithms that i personally find interesting.\
**These algorithms are not production ready**, i have only writen them as examples for study and research.

## Contents
### Sorting algorithms

+ [Bubble sort](#Bubble-sort) 
+ [Selection sort](#Selection-sort)
+ [Insertion sort](#Insertion-sort)
+ [Merge sort](#Merge-sort)
+ [Quick sort](#Quick-sort)
+ [Heap sort](#Heap-sort)

### Searching algorithms

+ [Linear search](#Linear-search)
+ [Binary search](#Binary-search)
+ [Jump search](#Jump-search)

### Bonus

+ Sieve of Eratosthenes
+ Euclidean greatest common divisor
+ Towers of Hanoi


## Theory

### Bubble sort
**Explanation**  
Bubble sorting works by repeatedly 
+ Stepping linearly through the list
+ Comparing adjacent elements 
+ Swapping the compared elements if they are in the wrong order. 

The passing through the list repeats until all elements are on the correct positions. Bubble sort is named after the way that smaller or larger elements "bubble" to the top of the list.\
Bubble sort is considered as one of the **simpler** sorting algorithms.\
Take a loot at MyBubbleSort.java in this project to see example implementation.

**Complexity**  
Worst-case and average complexity of bubble sort is **О(n^2)**   _- quadratic time_  
**n** - representing the number of items that are being sorted.
In simple words, it's not very efficient, considering the fact that most of the other sorting algorithms run in O(n log n), as will be explained further down in this readme.
 
The only thing that can be considered as a kind of an advantage of bubble sort, is that the ability to detect that the list is sorted efficiently is built into the algorithm. 

If the list is already sorted (best-case), the complexity of bubble sort is only **O(n)**, while most other sorting algorithms perform their entire process of sorting each and every time, no matter the starting state of the collection.  

This functionality however is not complex and can be added to other algorithms as well.

**Example**  
First Pass:  

( __7 3__ 9 6 1 ) –> ( **3 7** 9 6 1 )  
Compare 7 and 3, and swap them since 7 > 3
  
( 3 __7 9__ 6 1 ) –> ( 3 **7 9** 6 1 )  
Compare 7 and 9, and leave them as is since 7 < 9
   
( 3 7 __9 6__ 1 ) –> ( 3 7 **6 9** 1 )  
Compare 9 and 6, and swap them since 9 > 6
  
( 3 7 6 __9 1__ ) –> ( 3 7 6 **1 9** )  
Compare 6 and 1, and swap them since 1 < 9

That concludes the first pass and the largest item is now in the correct spot, as it has **bubbled up** (or _sank down_ depending on your point of view) to the end of the list.

The same process then starts again from the beginning of the list, and it is repeated until all items are in their correct positions.  

[My java implementation of bubble sort](https://github.com/StefanOffice/beneficial-algorithms/blob/main/src/algorithms/sorting/MyBubbleSort.java)  
[Back to contents](#Contents)

 
### Selection sort
**Explanation**  

Process of sorting using the selection sort divides the collection into 2 sub-parts, sorted and unsorted, and performs the following steps:
1) Pass through the unsorted part to find the smallest element ( if sorting is done in the ascending order)
2) Put the element at the beginning of the unsorted part ( which in the next loop belongs to the sorted part)  
3) Repeat steps 1 and 2 until all elements are sorted

**Runtime complexity**  
From the process itself it's visible that this is another simple method of sorting, and just as bubble sort has the worst-case runtime complexity of **О(n^2)**   _- quadratic time_. More detailed analysis is in the MySelectionSort.java file in this project.

**Example**
elements[] = 37 55 14 21 8

First pass:
1) Find the **minimum element** in the _unsorted part_  [0-4]  
_37 55 14 21 **8**_  
2) Put the element at the beginning of the unsorted part (0) by switching the element currently at that position  
**8** 55 14 21 **37** 

Second pass:
1) Find the **minimum element** in the _unsorted part_  [1-4]  
8 _55 **14** 21 37_  
2) Put the element at the beginning of the unsorted part (1) by switching the element currently at that position  
8 **14 55** 21 37

repeat the steps until all elements are sorted.

[My java implementation of selection sort](https://github.com/StefanOffice/beneficial-algorithms/blob/main/src/algorithms/sorting/MySelectionSort.java)  
[Back to contents](#Contents)

### Insertion sort
**Explanation**  
Insertion sort makes the following steps similarly to the selection sort there is also a sorted and unsorted part, but the process is a little bit different
1) Assume the first element is sorted
2) Passing: First next element in the unsorted part is taken and then compared with elements
in the sorted part one by one until a place is found for this new element
3) Shifting: Once the place is found, the elements greater than the current are shifted to the right
to make place for the next element, and then insert the element to the correct place   
4) Repeat steps 2 and 3 until the collection is sorted

MyInsertionSort.java in this project contains an example implementation.


**Complexity**  
Worst case runtime complexity of this algorithm is  **О(n^2)**   _- quadratic time_, same as the two algorithms explained above, however this algorithm is considered a little bit more efficient in comparison to them in the case that the collection is already **mostly** sorted.

**Example**
elements[] = 50 7 22 33 9

1) Assume the first element is sorted

First pass:  
2) Take the first element in the _unsorted part_ [1-4]   
50 _**7** 1 33 9_  
3) Place it at correct place(shifting the elements to make room if required so that elements[0-1] are now sorted   
**7 _50_** 1 33 9 

Second pass:
1) Take the first element in the unsorted part [2-4]    
7 50 _**1** 33 9_  
2) Place it at correct place(shifting the elements to make room if required so that elements[0-2] are now sorted  
**1** _**7** **50**_ 33 9 

repeat the steps until all elements are sorted.

[My java implementation of insertion sort](https://github.com/StefanOffice/beneficial-algorithms/blob/main/src/algorithms/sorting/MyInsertionSort.java)  
[Back to contents](#Contents)


### Merge sort

**Explanation**  
Moving on to more efficient algorithms, merge sort is one such example. This is a **divide-and-conquer** (breaking a big problem into a number of sub-problems, solve the smaller sub-problems, and then combine the solutions of sub-problems to find the solution of the original problem) type of algorithm and it works by:

1) Dividing the array into two parts
2) Recursively applying merge sort on each part
3) Merging them back together
  
**Complexity**

As mentioned above this algorithm is very efficient. The runtime complexity of Merge Sort is  **O(n log n)** in every case, as merge sort always divides the array into two halves and takes linear time to merge two halves.

  Dividing:  O(log n) - any time we are repeatedly dividing by two, we are dealing with _logarithmic time_   
  Merging:   O(n)   
  Total:	 O(n*log n)  
  
However, with this algorithm there is also another thing to consider which is its space cost
		
  Space complexity: O(n) - additional cost of all the sub-arrays
  All the other arrays created combined take as much memory as the original array

**Example**

To avoid confusion with a pretty lengthy written example, i think this algorithm can be more clearly visualized through [this](https://www.youtube.com/watch?v=KF2j-9iSf4Q) excellent video.

[My java implementation of merge sort](https://github.com/StefanOffice/beneficial-algorithms/blob/main/src/algorithms/sorting/MyMergeSort.java)  
[Back to contents](#Contents)

### Quick sort

**Explanation**  
Like the merge sort this is another example of a divide-and-conquer approach
See MyQuickSort.java for more info.

Quick sort algorithm works as follows:
1) Take a certain element as the pivot
2) Divides the elements in the array so that
   * elements <= pivot are on the right of the pivot
   * and elements > pivot are on the left of the pivot
3) Then recursively do this on the right and left parts
     
**Complexity**
     
| Runtime   Complexity | BC         | WC     |  
|----------------------|------------|--------|  
| Partitioning         | O(n)       | O(n)   |  
| Number of partitions | O(log n)   | O(n)   |  
| Total                | O(n log n) | O(n^2) |     
 
     
In the worst case, with bad pivot selection, the array is divided each time into one big sub-array and the other array empty  
However statistically the sizes of the two parts are close.  
So the average runtime O(n log n) is more common.   
  
**Example**

Take a loot at [this](https://www.youtube.com/watch?v=JSceec-wEyw) visual example for clarity.

[My java implementation of quick sort](https://github.com/StefanOffice/beneficial-algorithms/blob/main/src/algorithms/sorting/MyQuickSort.java)  
[Back to contents](#Contents)

### Heap sort

**Explanation**   
Heap sort in this project is just a demonstration what can be done using heaps,
This algorithm has a simple job:
 1) place the elements in the heap
 2) take them out sorted
 
All the actual work is being done in the heap  
For more explanation of how the heap works, (or other data structures) look at my MyGenericHeap.java copied over from my other project with data structures implementations

[My java implementation of heap sort](https://github.com/StefanOffice/beneficial-algorithms/blob/main/src/algorithms/sorting/MyGenericHeapSort.java)  
[Back to contents](#Contents)

### Linear search

**Explanation**   
Linear search is the most basic searching algorithm.  
It works by taking each element from the collection and comparing it with the key.  
Once a match is found, the index where it was found is returned  
If the element is not in the collection, -1 is returned  

**Complexity**  
**O(n)** this is pretty straightforward, all the elements of the collection are inspected once to find the required element.

[My linear search java implementation](https://github.com/StefanOffice/beneficial-algorithms/blob/main/src/algorithms/searching/MyLinearSearch.java)  
[Back to contents](#Contents)

### Binary search

**Explanation**  
Binary search algorithm provides efficient way to search for a key in a collection.  
**It works only on sorted collections.**  
The process starts out by comparing the middle element in the collection with the key  
+ If compared element matches the key its index is returned
+ If compared element is greater/(smaller) than the key HALF of the collection is eliminated from the search and only the elements that come after/(before) the compared element are taken into consideration for next comparison

**Complexity**  
Since the half the elements are eliminated from the search on each comparison, finding a key in a collection possible in **O(log n)** _logarithmic time_  
Simple way to visualize logarithmic time is to think how many times can a number of items in the collection be divided by 2.  
For example finding a key in a collection of 1 000 000 items will takes ~20 comparisons in worst case and linear search would take 1 000 000 comparisons
  
**Example**  
collection - 1 5 30 47 70 83 92 100 130 145 198   
key - 47 

First comparison:
1) Inspect the middle element and compare it with the key  
1 5 30 47 70 **83** 92 100 130 145 198 
2) Since 47 < 83 eliminate the right half of collection from the search  
1 5 30 47 70

Second comparison:  
1) Inspect the middle element and compare it with the key  
1 5 **30** 47 70
2) Since 47 > 30 eliminate the left half of the collection from the search  
47 70

Third comparison:
1) Inspect the middle element and compare it with the key  
1 **47** 70
2) Since 47 = 47 return the index where the element was found (3)

[My binary search java implementation](https://github.com/StefanOffice/beneficial-algorithms/blob/main/src/algorithms/searching/MyBinarySearch.java)  
[Back to contents](#Contents)

### Jump search

**Explanation**  
Similarly as binary search, jump search is another search algorithm that **can be used only with sorted collections**, the way it works is:  
1) Jump ahead a certain number of indexes
2) Check if the key is >= to the element at the current index
            2a. if yes inspect the block starting at index before the jump and ending at the current index (if the element is not here then it's not in the collection.)
            2b. if no repeat steps 1 and 2.
      
**Complexity**  
Runtime complexity is not that straightforward with this algorithm as the runtime complexity will depend on
+ Jump size
+ The other search algorithm used to search the block



**Example**  
collection - 10 24 31 53 62 88 100 127 170 230  
example jump size - 3  
key - 100

_First jump_  
1) Jump ahead by 3 elements (to index 2)  
10 24 **31** 53 62 88 100 127 170 230
2) Compare the key with element at the jump location  
31 < 100  

_Second jump_  
1) Since 31 < 100, jump again (to index 5)  
10 24 31 53 62 **88** 100 127 170 230
2) Compare the key with element at the jump location   
88 < 100  

_Third jump_  
1) Since 88 < 100, jump again (to index 8)  
10 24 31 53 62 88 100 127 **170** 230
2) Compare key with the element at the jump location
170 > 100
 
3) Since 170 >= 100 inspect the block from the last jump starting position(5) to the current position(8)
88 100 127 170

[My jump search java implementation](https://github.com/StefanOffice/beneficial-algorithms/blob/main/src/algorithms/searching/MyJumpSearch.java)  
[Back to contents](#Contents)

## Other algorithms 
For other interesting algorithms check out the 'other' folder of this project, or click [here](https://github.com/StefanOffice/beneficial-algorithms/tree/main/src/algorithms/other) every algorithm has explanations in the comments.

## Thank you.

As a final word, i'd like to thank you for checking out my work, i hope it was informative/helpful and that it may assist you in your learning journey. :wink:

___All the best,\
Stefan Stefanovic___
