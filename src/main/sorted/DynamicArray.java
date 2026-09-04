package sorted;

import java.util.Objects;

/**
 * A growable array of any element type T.
 *
 * @param <T> the type of element stored in this array.
 */
public class DynamicArray<T> {

  private T[] arr;
  private int size;

  // Object[] cast to T[]: can't make an array of a type parameter directly.
  @SuppressWarnings("unchecked")
  public DynamicArray() {
    arr = (T[]) new Object[10];
    size = 0;
  }

  public void add(T value) {
    if (size == arr.length) {
      grow();
    }
    arr[size] = value;
    size++;
  }

  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    return arr[index];
  }

  public void set(int index, T value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    arr[index] = value;
  }

  public int size() {
    return size;
  }

  public boolean contains(T value) {
    return indexOf(value) != -1;
  }

  // Returns -1 if value is not found.
  public int indexOf(T value) {
    for (int i = 0; i < size; i++) {
      // Objects.equals: content comparison, null-safe (unlike ==).
      if (Objects.equals(arr[i], value)) {
        return i;
      }
    }
    return -1;
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

  // Removes the first occurrence of value, preserving insertion order.
  // Returns false if value is not found.
  public boolean remove(T value) {
    int i = indexOf(value);
    if (i == -1) {
      return false;
    }
    remove(i);
    return true;
  }

  // Doubles the capacity.
  private void grow() {
    @SuppressWarnings("unchecked")
    T[] bigger = (T[]) new Object[arr.length * 2];
    for (int i = 0; i < size; i++) {
      bigger[i] = arr[i];
    }
    arr = bigger;
  }
}
