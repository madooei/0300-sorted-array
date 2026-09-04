package sorted;

/** Binary search over a sorted array of ints: iterative and recursive forms. */
public final class BinarySearch {

  private BinarySearch() {}

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

  // Assumes arr is sorted. Recursive form; the public method hides the
  // low/high bounds behind a private overload.
  public static int binarySearchRecursive(int[] arr, int target) {
    return binarySearchRecursive(arr, target, 0, arr.length - 1);
  }

  private static int binarySearchRecursive(int[] arr, int target, int low, int high) {
    if (low > high) {
      return -1;   // base case: empty range
    }
    int mid = low + (high - low) / 2;
    int cmp = Integer.compare(arr[mid], target);
    if (cmp == 0) {
      return mid;
    } else if (cmp < 0) {
      return binarySearchRecursive(arr, target, mid + 1, high);
    } else {
      return binarySearchRecursive(arr, target, low, mid - 1);
    }
  }
}
