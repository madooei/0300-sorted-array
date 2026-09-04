# The Sorted Array

A list that always keeps its elements in sorted order, and the binary search
that order unlocks.

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
        DynamicArray.java   # Chapter 2's growable array, carried forward
        BinarySearch.java   # iterative, recursive, and insertion-point search
        SortedArray.java    # the always-sorted list: add, indexOf, remove
        Student.java        # a sample element type: equals, hashCode, Comparable
        Main.java           # a small demo
  scripts/
    run.sh                  # compile everything and run the Main demo
```

## How to compile and run

- `scripts/run.sh` — compiles all source into `out/` and runs the `Main` demo.

There is no build tool and no test suite: testing is introduced later in the
course. The script above is all you need.

## What's here

- `sorted.DynamicArray<T>` — Chapter 2's growable array, carried forward
  unchanged. The standalone binary search runs over it, as the notes do, before
  the `SortedArray` exists.
- `sorted.BinarySearch` — a namespace of static searches over a sorted
  `DynamicArray`: `binarySearch` (iterative, returns the index or `-1`),
  `binarySearchRecursive` (the same algorithm written recursively, with a
  private `low`/`high` helper), and `insertionPoint` (returns where a value sits
  or where it would belong). Correct only on sorted input.
- `sorted.SortedArray<T extends Comparable<T>>` — a list that maintains the
  sorted-order invariant. `add` finds the insertion point with binary search and
  shifts larger elements right; `indexOf`/`contains` reuse that one search;
  `remove` closes the gap. There is deliberately no `set`.
- `sorted.Student` — a sample element type, carried forward from Chapter 2:
  value equality by `id` (`equals`/`hashCode`) and a natural order by `id`
  (`Comparable<Student>`), kept consistent so binary-search `contains` answers
  "is this student here?" correctly.
- `sorted.Main` — a runnable demo: binary search over a sorted `DynamicArray`, a
  `SortedArray<Student>` roster kept in id order, and the `SortedArray<Integer>`
  `remove` overload trap.
