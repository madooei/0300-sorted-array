package sorted;

/** A dynamic array that keeps its elements in sorted order. No set: it could break the invariant. */
public class SortedArray<T extends Comparable<T>> {

  private T[] arr;   // elements kept sorted in [0, size)
  private int size;

  // Comparable[] (not Object[]) because T is bounded by Comparable; can't make an array of a type parameter.
  @SuppressWarnings("unchecked")
  public SortedArray() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
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
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  public int indexOf(T value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  public boolean contains(T value) {
    return indexOf(value) != -1;
  }

  // Removes the element at a given index; returns what was removed.
  public T remove(int index) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Removes the first occurrence of value.
  // Returns false if value is not found.
  public boolean remove(T value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Index where value sits, or where it would belong if absent (binary search).
  private int insertionPoint(T value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Doubles the capacity. Same cast rationale as the constructor.
  @SuppressWarnings("unchecked")
  private void grow() {
    T[] bigger = (T[]) new Comparable[arr.length * 2];
    for (int i = 0; i < size; i++) {
      bigger[i] = arr[i];
    }
    arr = bigger;
  }
}
