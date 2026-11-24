package demo;

import java.util.Arrays;
import sorted.IterativeBinarySearch;

/** A demo of IterativeBinarySearch on the example the notes trace. */
public final class IterativeBinarySearchDemo {

  private IterativeBinarySearchDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    int[] arr = {3, 9, 14, 21, 28, 33, 42, 55};
    int target = 42;
    System.out.println("arr: " + Arrays.toString(arr) + ", target = " + target);

    // Three comparisons find 42 at index 6. Expect 6.
    int index = IterativeBinarySearch.binarySearch(arr, target);
    System.out.println("index of " + target + ": " + index);
  }
}
