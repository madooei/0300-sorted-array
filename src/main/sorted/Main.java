package sorted;

import java.util.Arrays;

/** A runnable demo: binary search over a sorted array, and the self-sorting SortedArray. */
public final class Main {

  private Main() {}

  public static void main(String[] args) {
    // Part 1: binary search over a sorted array.
    int[] nums = {1, 4, 7, 9, 12};
    System.out.println("nums: " + Arrays.toString(nums));
    System.out.println("binarySearch(7)          = " + BinarySearch.binarySearch(nums, 7));
    System.out.println("binarySearch(5)          = " + BinarySearch.binarySearch(nums, 5));
    System.out.println("binarySearchRecursive(5) = " + BinarySearch.binarySearchRecursive(nums, 5));

    // Part 2: a SortedArray keeps a roster in id order no matter the add order.
    SortedArray<Student> roster = new SortedArray<>();
    roster.add(new Student(3, "Ada", 3.9));
    roster.add(new Student(1, "Linus", 3.4));
    roster.add(new Student(2, "Grace", 4.0));
    System.out.println();
    System.out.println("roster (added 3, 1, 2 — stored in id order):");
    printEach(roster);

    Student probe = new Student(1, "Linus", 3.4);
    System.out.println("contains student #1? " + roster.contains(probe));
    System.out.println("indexOf student #2 = " + roster.indexOf(new Student(2, "Grace", 4.0)));

    roster.remove(probe);   // remove by value
    System.out.println("after remove(#1):");
    printEach(roster);

    // Part 3: the remove overload trap from Chapter 2.
    SortedArray<Integer> scores = new SortedArray<>();
    scores.add(70);
    scores.add(50);
    scores.add(60);   // stored sorted: [50, 60, 70]
    System.out.println();
    System.out.println("scores (added 70, 50, 60): " + toString(scores));
    scores.remove(2);                     // remove(int): removes INDEX 2 (the 70)
    System.out.println("after remove(2) — the index overload removed the 70: " + toString(scores));
    scores.remove(Integer.valueOf(50));   // remove(T): removes the VALUE 50
    System.out.println("after remove(Integer.valueOf(50)) — the value overload: " + toString(scores));
  }

  private static void printEach(SortedArray<Student> roster) {
    for (int i = 0; i < roster.size(); i++) {
      System.out.println("  " + roster.get(i));
    }
  }

  // Builds "[a, b, c]" for a SortedArray.
  private static <T extends Comparable<T>> String toString(SortedArray<T> a) {
    StringBuilder str = new StringBuilder();
    str.append("[");
    for (int i = 0; i < a.size(); i++) {
      str.append(a.get(i));
      if (i < a.size() - 1) {
        str.append(", ");
      }
    }
    str.append("]");
    return str.toString();
  }
}
