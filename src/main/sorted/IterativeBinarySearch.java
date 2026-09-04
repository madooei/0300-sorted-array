package sorted;

/** Binary search over a sorted array of ints, implemented iteratively. */
public final class IterativeBinarySearch {

  private IterativeBinarySearch() {}

  // Assumes arr is sorted. Returns the index of target, or -1 if absent.
  public static int binarySearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;   // avoids overflow vs (low + high) / 2
      int cmp = Integer.compare(arr[mid], target);
      if (cmp == 0) {
        return mid;
      } else if (cmp < 0) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }
}
