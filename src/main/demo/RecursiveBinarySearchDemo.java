package demo;

import java.util.Arrays;
import sorted.RecursiveBinarySearch;

/** A demo of RecursiveBinarySearch on the example from the notes. */
public final class RecursiveBinarySearchDemo {

  private RecursiveBinarySearchDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    int[] numbers = {3, 9, 14, 21, 28, 33, 42, 55};
    int target = 14;
    System.out.println("numbers: " + Arrays.toString(numbers) + ", target = " + target);

    // 14 is in the array. Expect true.
    boolean found = RecursiveBinarySearch.binarySearch(numbers, target);
    System.out.println("found " + target + "? " + found);
  }
}
