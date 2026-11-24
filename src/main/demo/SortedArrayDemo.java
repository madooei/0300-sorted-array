package demo;

import sorted.SortedArray;
import sorted.Student;

/** A demo of SortedArray: a roster kept in id order, then the Integer remove trap. */
public final class SortedArrayDemo {

  private SortedArrayDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    SortedArray<Student> roster = new SortedArray<>();
    roster.add(new Student(3, "Ada", 3.9));
    roster.add(new Student(1, "Linus", 3.4));
    roster.add(new Student(2, "Grace", 4.0));

    // Added 3, 1, 2. Expect them stored in id order: Linus, Grace, Ada.
    System.out.println("roster: " + toString(roster));

    // Expect true.
    Student probe = new Student(1, "Linus", 3.4);
    System.out.println("contains student #1? " + roster.contains(probe));

    // Grace is in the middle. Expect 1.
    System.out.println("indexOf student #2: " + roster.indexOf(new Student(2, "Grace", 4.0)));

    // Remove by value. Expect Grace, Ada.
    roster.remove(probe);
    System.out.println("after remove(#1): " + toString(roster));

    SortedArray<Integer> scores = new SortedArray<>();
    scores.add(70);
    scores.add(50);
    scores.add(60);

    // Expect [50, 60, 70].
    System.out.println("scores (added 70, 50, 60): " + toString(scores));

    // remove(int) removes the element at index 2. Expect [50, 60].
    scores.remove(2);
    System.out.println("after remove(2): " + toString(scores));

    // remove(T) removes the value 50. Expect [60].
    scores.remove(Integer.valueOf(50));
    System.out.println("after remove(Integer.valueOf(50)): " + toString(scores));
  }

  // Builds "[a, b, c]" for a SortedArray, reaching it only through public operations.
  private static <T extends Comparable<T>> String toString(SortedArray<T> list) {
    StringBuilder str = new StringBuilder();
    str.append("[");
    for (int i = 0; i < list.size(); i++) {
      str.append(list.get(i));
      if (i < list.size() - 1) {
        str.append(", ");
      }
    }
    str.append("]");
    return str.toString();
  }
}
