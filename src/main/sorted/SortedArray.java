package sorted;

/** A dynamic array that keeps its elements in sorted order. No set: it could break the invariant. */
public class SortedArray<T extends Comparable<T>> {

  private T[] arr;   // elements kept sorted in [0, size)
  private int size;

  // Comparable[] (not Object[]) because T is bounded by Comparable; can't make an array of a type parameter.
  @SuppressWarnings({"unchecked", "rawtypes"})
  public SortedArray() {
    arr = (T[]) new Comparable[10];
    size = 0;
  }

  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    return arr[index];
  }

  public int size() {
    return size;
  }

  public void add(T value) {
    if (size == arr.length) {
      grow();
    }
    int i = insertionPoint(value);
    for (int j = size; j > i; j--) {
      arr[j] = arr[j - 1];   // shift larger elements right to open a gap
    }
    arr[i] = value;
    size++;
  }

  public int indexOf(T value) {
    int i = insertionPoint(value);
    if (i < size && arr[i].equals(value)) {
      return i;
    }
    return -1;
  }

  public boolean contains(T value) {
    return indexOf(value) != -1;
  }

  // Removes the element at a given index; returns what was removed.
  public T remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    T removed = arr[index];
    for (int j = index; j < size - 1; j++) {
      arr[j] = arr[j + 1];   // shift left to close the gap
    }
    size--;
    arr[size] = null;
    return removed;
  }

  // Removes the first occurrence of value.
  // Returns false if value is not found.
  public boolean remove(T value) {
    int i = indexOf(value);
    if (i == -1) {
      return false;
    }
    remove(i);
    return true;
  }

  // Index where value sits, or where it would belong if absent (binary search).
  private int insertionPoint(T value) {
    int low = 0;
    int high = size - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int cmp = arr[mid].compareTo(value);
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

  // Doubles the capacity. Same cast rationale as the constructor.
  private void grow() {
    @SuppressWarnings({"unchecked", "rawtypes"})
    T[] bigger = (T[]) new Comparable[arr.length * 2];
    for (int i = 0; i < size; i++) {
      bigger[i] = arr[i];
    }
    arr = bigger;
  }
}
