# DSA521S-Group-Project-2026
DSA521S Group Project 2026 - Campus Service Centre Simulation (Java Data Structures &amp; Algorithms).
# DSA521S Group Mini-Project 2026
### Campus Service Centre Simulation

 Group Members
* [224080911] - [Hendritte Musambani]
* [226010058] - [Shilondelo Erastus]
* [226029905] - [Lazarus Jessica]
* [226075583] - [Johanna Nghidileko]
* [Student Number 5] - [Full Name 5]

# Campus Service Centre Simulation (NUST DSA521S)

# Overview
The **Campus Service Centre Simulation** is a modular Java console application designed to simulate administrative queue management, student record tracking, service time statistics, and sorting algorithm benchmarking for a university environment. This project was developed as part of the Data Structures and Algorithms (DSA521S) course requirements at the Namibia University of Science and Technology (NUST).

# Features
- **Queue Management:** Enqueue, dequeue, and peek operations to simulate student queuing.
- **Singly Linked List:** Insert, delete, search, and display student records dynamically.
- **Service Statistics (`ArrayStats`):** Analyzes service times and operational metrics.
- **Sorting Algorithms:** Implements and demonstrates four sorting techniques from scratch (Selection Sort, Insertion Sort, Merge Sort, and Quick Sort) *without* using built-in library sorting methods.
- **Performance Benchmarking:** Measures and compares execution time in nanoseconds (`System.nanoTime()`) across varying dataset sizes (20, 50, 100, 500 elements).

# Project Structure
- `Main.java` - Centralized command-line menu interface controlling all modules.
- `ServiceQueue` / Node classes - Handles queue logic.
- `StudentLinkedList` / Node classes - Manages student records.
- `ArrayStats.java` - Service time analytics module.
- `SelectionSort.java` - Selection sort implementation with pass-by-pass tracing.
- `InsertionSort.java` - Insertion sort implementation with pass-by-pass tracing.
- `MergeSort.java` - Divide-and-conquer merge sort implementation.
- `QuickSort.java` - Partition-based quick sort implementation.
- `StackAndPostfix.java` - Stack and postfix expression evaluation utilities.

## How to Run
1. Clone the repository and open it in your preferred Java IDE (such as IntelliJ IDEA).
2. Ensure all `.java` source files are located inside the `src` directory.
3. Compile and execute `Main.java`.
4. Follow the interactive console prompts (Options 1–11) to test modules and performance experiments.
