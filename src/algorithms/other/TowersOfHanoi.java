package algorithms.other;

import java.util.Scanner;

/*
        Problem description (copied over from wikipedia):
        
        The Tower of Hanoi is a mathematical puzzle.
        It consists of three rods and a number of disks of different diameters,
        which can slide onto any rod.
        The puzzle starts with the disks stacked on one rod in order of decreasing size,
        the smallest at the top, thus approximating a conical shape.
        
        The objective of the puzzle is to move the entire stack to the last rod,
        obeying the following simple rules:
        1. Only one disk may be moved at a time.
        2. Each move consists of taking the upper disk from one of the stacks
          and placing it on top of another stack or an empty rod.
        3. No disk may be placed on top of a disk that is smaller than it.
        
        With 3 disks, the puzzle can be solved in 7 moves.
        The minimal number of moves required to solve a Tower of Hanoi puzzle is 2^n − 1,
        where n is the number of disks.
*/

public class TowersOfHanoi {
    
    //this var will keep track of the current step number
    // it gets incremented every time a step is made
    //it's outside the method as the method is recursive therefore a local variable would not work
    static int step = 1;
    static int bottomDiskTracker;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the starting number of disks: ");
        int bottomDiskNum = input.nextInt();
        bottomDiskTracker = bottomDiskNum;
        // Find the solution recursively
        System.out.println("The disks start out on Start-Pile.\n The goal is to move them to Target-Pile with the assistance of Help-Pile");
        System.out.println("Move the disks in the following order (Solution): ");
        
        //the recursion begins by feeding the bottom disk number as the starting point
        move(bottomDiskNum, "Start-Tower", "Target-Tower", "Help-Tower");
    }
    
    public static void move(int diskNum, String startTower, String targetTower, String helpTower) {
        //Base condition to terminate recursion
        if (diskNum == 1) {
          //if there is only 1(top disk) then just move it to the target
            System.out.println("Step " + step++ + ": Move disk "
                    + diskNum + " from " + startTower + " to " + targetTower);
            if(bottomDiskTracker == 1)
              System.out.println("\t\tFinal disk locked into target tower, puzzle complete.");
            return;
        }
        
        //otherwise the pattern goes as follows:
        // in order to move the Nth disk from start to target tower
        // all the disks above it (N-1 to 1) must be moved to help tower
        // using recursion to move them one by one
        move(diskNum - 1, startTower, helpTower, targetTower);
        
        //then the Nth disk can be moved to target tower
        System.out.println("Step " + step++ + ": Move disk "
                + diskNum + " from " + startTower + " to " + targetTower);
        
        //this is just decorative info(not required by the algo)
        // to keep track of current state of disks, and to make the solution more readable
        if(diskNum == bottomDiskTracker){
          System.out.println("\t\tDisk " + bottomDiskTracker-- + " locked into target tower\n");
        }
        
        //then all the other disks can be moved from help tower to target tower
        // in the same process using recursion
        // notice how the helpTower is now set as the startTower
        // and startTower is now fulfilling the role of the help tower.
        move(diskNum - 1, helpTower, targetTower, startTower);
        
    }
}
