# The Sorted Array

A list that always keeps its elements in sorted order, and the binary search that order unlocks.

## Prerequisites

- JDK 17+

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  src/
    main/
      sorted/
        IterativeBinarySearch.java   # binary search over int[], iterative
        RecursiveBinarySearch.java   # binary search over int[], recursive
        SortedArray.java             # the always-sorted list: add, indexOf, remove
        Student.java                 # a sample element type: equals, hashCode, Comparable
      demo/                          # one demo per class you implement
        IterativeBinarySearchDemo.java
        RecursiveBinarySearchDemo.java
        SortedArrayDemo.java
  scripts/
    run.sh                           # compile everything and run one demo
```

## How to compile and run

- `scripts/run.sh demo.SortedArrayDemo` — compiles all source into `out/` and runs that one demo. Every class you implement has its own demo.

There is no build tool and no test suite: testing is introduced later in the course. The script above is all you need.

## What's here

- `sorted.IterativeBinarySearch` — `binarySearch(int[] arr, int target)`, returns the index of `target` or `-1`. Correct only on sorted input.
- `sorted.RecursiveBinarySearch` — the same search written recursively: a public `binarySearch(int[] arr, int target)` returning `boolean`, backed by a private `low`/`high` overload. Correct only on sorted input.
- `sorted.SortedArray<T extends Comparable<T>>` — a list that maintains the sorted-order invariant. `add` finds the insertion point with binary search and shifts larger elements right; `indexOf`/`contains` reuse that one search; `remove` closes the gap. There is deliberately no `set`.
- `sorted.Student` — a sample element type, carried forward from Chapter 2: value equality by `id` (`equals`/`hashCode`) and a natural order by `id` (`Comparable<Student>`).
- `demo.IterativeBinarySearchDemo`, `demo.RecursiveBinarySearchDemo`, and `demo.SortedArrayDemo` — one demo per class. The two search demos run on the sorted array from the notes, and the `SortedArray` demo keeps a `SortedArray<Student>` roster in id order and shows the `SortedArray<Integer>` `remove` overload trap.
