package algorithms.other;

import java.util.Arrays;
import java.util.Scanner;

/*
    Fun fact:
    Sieve of Eratosthenes is one of the earliest known algorithms.
    Waaaaaaay before modern computers were invented.
    And it's still one of the more efficient algorithms for finding prime numbers
    It dates back to ~250 years BC, when Eratosthenes of Cyrene discovered it.
    
    The example below is my Java implementation of it.
    
 */

public class SieveOfEratosthenes {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Program for printing prime numbers in the range 0-limit.\nPlease enter limit: ");
    int limit = input.nextInt();
    
    System.out.print("Please enter the amount of numbers to print per line: ");
    int numsPerLine = input.nextInt();
    
    sieve(limit, numsPerLine);
  }
  
  public static void sieve(int limit, int numsPerLine){
    boolean[] primes = new boolean[limit + 1];
  
    // Initialize primes[i] to true
    Arrays.fill(primes, true);
  
    //it's enough to check numbers up to limit/i as any other will already have been eliminated by earlier primes
    for (int currentPrime = 2; currentPrime <= limit / currentPrime; currentPrime++) {
      if (primes[currentPrime]) {
        //any number divisible by the current prime is not itself prime
        for (int numToCheck = currentPrime; numToCheck <= (limit / currentPrime); numToCheck++) {
          //so mark it off
          primes[currentPrime * numToCheck] = false;
        }
      }
    }
  
    // used to control how many are primes printed in one line and also for the total count
    int count = 0;
    System.out.printf("Prime number(s) in range of 0-%d are:\n", limit);
    
    for (int i = 2; i < primes.length; i++) {
      //if the current number is prime, count & print it.
      if (primes[i]) {
        count++;
        
        System.out.printf("%-7d", i);
        if (count % numsPerLine == 0)
          System.out.println();
      }
    }
  
    System.out.printf("\nCount: %d prime number(s) less than or equal to %d", count, limit);
    
  }
}
