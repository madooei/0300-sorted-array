package sorted;

/** Binary search over a sorted array of ints, implemented recursively. */
public final class RecursiveBinarySearch {

  private RecursiveBinarySearch() {}

  // Assumes arr is sorted. The public method hides the low/high bounds
  // behind a private overload.
  public static boolean binarySearch(int[] arr, int target) {
    return binarySearch(arr, target, 0, arr.length - 1);
  }

  private static boolean binarySearch(int[] arr, int target, int low, int high) {
    if (low > high) {
      return false;   // base case: empty range
    }
    int mid = low + (high - low) / 2;
    int cmp = Integer.compare(arr[mid], target);
    if (cmp == 0) {
      return true;
    } else if (cmp < 0) {
      return binarySearch(arr, target, mid + 1, high);
    } else {
      return binarySearch(arr, target, low, mid - 1);
    }
  }
}
