# Programming Paradigms (Paradygmaty Programowania)
This repository contains solutions to academic lab assignments focused on diverse programming paradigms, moving from pure functional programming in OCaml and Scala to concurrent and object-oriented systems in Java.

OCaml
---
The OCaml folder focuses on the pure functional approach, emphasizing immutable data structures and complex recursion. Throughout these exercises, manual memory and list management are practiced by implementing custom versions of standard operations like length, reverse, and append.

**Recursive Logic & Optimization:** Core assignments involve basic list manipulation (partitioning and joining) using recursion instead of imperative loops. High emphasis is placed on tail recursion to ensure memory efficiency for large datasets.

**Data Structures & ADTs:** Implementation of Algebraic Data Types (ADT) to solve problems such as stack-based logic evaluation (AND, OR, XOR, NOT) and directed graph reachability that avoids infinite loops in cyclic structures.

**Lazy Computation:** Exploration of lazy lists to handle potentially infinite sequences, including the implementation of a lazy Fibonacci generator and partitioning lists by index parity.

**Pattern Matching:** Advanced use of pattern matching for binary-to-decimal conversion and filtering nested list structures.

Scala
---
The Scala directory showcases the language's hybrid nature, blending functional concepts with object-oriented traits and advanced type systems.

**Functional Processing:** Assignments include element-wise multiplication of lists with neutral element padding and the calculation of binary tree statistics (node count, height, and sum).

**Stack Evaluators:** Creation of stack-based arithmetic evaluators using instruction sets like Push, Pop, and Inc.

**Metaprogramming & Traits:** Implementation of the Debug trait, which uses reflection-like capabilities to automatically output class names, field types, and current values via a debugVars method.

**Linguistic Features:** Utilization of variadic functions to create universal print utilities that identify and display argument types dynamically.

JAVA
---
The Java directory focuses on imperative programming, object-oriented design patterns, and system-level concurrency.

**Object-Oriented Design:** A full Christmas tree decoration system was developed using abstract classes, interfaces, and the Factory pattern to manage decorations like baubles and lights through inclusive polymorphism .

**Concurrency:** Multi-threaded programs solving the Producer-Consumer problem using semaphores and a FIFO strategy for data exchange.

**System Inspection:** Implementation of field inspection tools that display class types and values for any passed object.

**Imperative Collections:** Comparison of performance and side effects through imperative array sorting and duplicate removal
