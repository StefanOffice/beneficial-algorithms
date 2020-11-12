package algorithms.other;

import java.util.Scanner;

/*
    Euclidean algorithm is another one of the ancient algorithms next to sieve of Eratosthenes
    It is named after the ancient Greek mathematician Euclid, who first described it in his Elements (c. 300 BC).
    
    Some wikipedia background info:
    The Euclidean algorithm is based on the principle that the greatest common divisor of two numbers
      does not change if the larger number is replaced by its difference with the smaller number.
    For example, 21 is the GCD of 252 and 105 (as 252 = 21 × 12 and 105 = 21 × 5),
      and the same number 21 is also the GCD of 105 and 252 − 105 = 147.
    Since this replacement reduces the larger of the two numbers,
      repeating this process gives successively smaller pairs of numbers until the two numbers become equal.
    
    The version described above (and by Euclid) can take many subtraction steps to find the GCD
      when one of the given numbers is much bigger than the other.
    The algorithm has evolved since Euclid tho.
    A more efficient version of the algorithm shortcuts these steps,
      instead replacing the larger of the two numbers by its remainder when divided by the smaller of the two
      (with this version, the algorithm stops when reaching a zero remainder).
    With this improvement, the algorithm never requires more steps than
       five times the number of digits (base 10) of the smaller integer
       
       Below is my Java implementation of the second version
 */

public class EuclideanGCD {
  

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Program for finding the greatest common divisor of 2 numbers.");
    System.out.print("Please enter the first number(integer): ");
    int firstNum = input.nextInt();
    System.out.print("Please enter the second number(integer): ");
    int secondNum = input.nextInt();
    
    int gcd = gcd(firstNum, secondNum);
    System.out.printf("The greatest common divisor for %d and %d is %d ", firstNum, secondNum, gcd);
  }
  
  public static int gcd(int firstNum, int secondNum) {
    if (firstNum % secondNum == 0)
      return secondNum;
    else
      //greater number will get replaced by it's remainder when divided by lesser num
      // if second num is initially greater they will just switch places in the first iteration
      return gcd(secondNum, firstNum % secondNum);
  }
  
  //brute force inefficient version, just for demo
  public static int bruteForceGCD(int firstNum, int secondNum) {
    int gcd = 1; // if it's not any other number it's going to be for sure at least 1
    int potentialGCD = 1; // start at one and check every number <= lesser number
    
    int lesserNum = Math.min(Math.abs(firstNum), Math.abs(secondNum));
    
    while (potentialGCD <= lesserNum) {
      if (firstNum % potentialGCD == 0 && secondNum % potentialGCD == 0)
        gcd = potentialGCD;
      potentialGCD++;
    }
    
    return gcd;
  }
  

 
}
