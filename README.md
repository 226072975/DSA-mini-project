# DSA Mini Project

## Group Members

| Student Number | Full Name            |
| -------------- | -------------------- |
| 226072975      | Valentino Joseph     |
| 226108953      | Heather Kampira      |
| 225118025      | Lowell Van Schalkwyk |
| 226146369      | Salmi Shaanika       |
| 225111578      | Vaughan Lehmann      |

**Submitted by: 226072975 – Valentino Joseph**

## Project Overview

This project demonstrates the implementation and use of fundamental data structures and sorting algorithms in Java.

The project includes:

* Arrays and Stacks
* Queues
* Linked Lists
* Selection Sort
* Insertion Sort
* Merge Sort
* Quick Sort
* Sorting performance experiments

The required data structures and algorithms are implemented without using Java's built-in sorting, queue, or linked-list classes as replacements for the required implementations.

## Project Structure

```text
DSA-mini-project/
│
├── queue/
│   ├── Main.java
│   ├── QueueNode.java
│   ├── Student.java
│   └── StudentQueue.java
│
├── Soarting/
│   ├── InsertionSort.java
│   ├── MergeSort.java
│   ├── QuickSort.java
│   ├── SelectionSort.java
│   └── SortingExperiment.java
│
├── src/
│   ├── Main.java
│   └── Student.java
│
├── README.md
└── .gitignore
```

## Requirements

* Java Development Kit (JDK)
* Command Prompt, PowerShell, or another terminal
* A Java-compatible development environment such as VS Code

## Running the Queue

Open a terminal in the main project folder:

```text
DSA-mini-project
```

Compile the queue files:

```powershell
javac queue\Student.java queue\QueueNode.java queue\StudentQueue.java queue\Main.java
```

Run the queue demonstration:

```powershell
java -cp queue Main
```

The queue demonstration creates six students, adds them to the queue using `enqueue()`, displays the queue, and serves three students using `dequeue()`.

The queue follows the **First-In, First-Out (FIFO)** principle.

## Running the Sorting Experiment

From the main project folder, compile:

```powershell
javac Soarting\SortingExperiment.java
```

Run:

```powershell
java -cp Soarting SortingExperiment
```

The sorting experiment tests:

* Selection Sort
* Merge Sort
* Insertion Sort
* Quick Sort

The experiment uses different array sizes and records:

* Number of comparisons
* Execution time

It also includes an almost-sorted 100-element test.

## Running the Individual Sorting Algorithms

### Selection Sort

```powershell
javac Soarting\SelectionSort.java
java -cp Soarting SelectionSort
```

### Insertion Sort

```powershell
javac Soarting\InsertionSort.java
java -cp Soarting InsertionSort
```

### Merge Sort

```powershell
javac Soarting\MergeSort.java
java -cp Soarting MergeSort
```

### Quick Sort

```powershell
javac Soarting\QuickSort.java
java -cp Soarting QuickSort
```

## GitHub Repository

The project's GitHub repository is:

https://github.com/226072975/DSA-mini-project.git
