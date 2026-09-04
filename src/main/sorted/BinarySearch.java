package sorted;

/** A namespace of static searches over a sorted DynamicArray. */
public final class BinarySearch {

  private BinarySearch() {}

  // Assumes a is sorted. Returns the index of target, or -1 if absent.
  public static <T extends Comparable<T>> int binarySearch(DynamicArray<T> a, T target) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Assumes a is sorted. Recursive form; the public method hides the
  // low/high bounds behind a private overload.
  public static <T extends Comparable<T>> int binarySearchRecursive(DynamicArray<T> a, T target) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  private static <T extends Comparable<T>> int binarySearchRecursive(
      DynamicArray<T> a, T target, int low, int high) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Assumes a is sorted. Like binarySearch, but returns where target
  // belongs when absent, not -1.
  public static <T extends Comparable<T>> int insertionPoint(DynamicArray<T> a, T target) {
    int low = 0;
    int high = a.size() - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int cmp = a.get(mid).compareTo(target);
      if (cmp == 0) {
        return mid;
      } else if (cmp < 0) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }
}
