#!/usr/bin/env bash
# Compile all source into out/ and run both demos.
set -e
cd "$(dirname "$0")/.."
javac -d out $(find src/main -name "*.java")
java -cp out sorted.DemoBinarySearch
echo
java -cp out sorted.DemoSortedArray
