package sorted;

import java.util.Arrays;

/** A runnable demo of iterative and recursive binary search. */
public final class DemoBinarySearch {

  private DemoBinarySearch() {}

  public static void main(String[] args) {
    int[] nums = {1, 4, 7, 9, 12};
    System.out.println("nums: " + Arrays.toString(nums));
    System.out.println("IterativeBinarySearch.binarySearch(7) = " + IterativeBinarySearch.binarySearch(nums, 7));
    System.out.println("IterativeBinarySearch.binarySearch(5) = " + IterativeBinarySearch.binarySearch(nums, 5));
    System.out.println("RecursiveBinarySearch.binarySearch(5) = " + RecursiveBinarySearch.binarySearch(nums, 5));
  }
}
