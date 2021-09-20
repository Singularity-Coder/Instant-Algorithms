![alt text](https://github.com/Singularity-Coder/Code-Snippets-Algorithms/blob/main/assets/banner_algorithm.png)
# Code Snippets Algorithms
List of Algorithm topics and their code snippets!


## Linear DS
* **Arrays**
* **Linked List**
	* **Doubly Linked List**
	* **Circular Linked List**


## Stack DS
* Stack 
* Queue
* Heap


## Tree DS
* **Binary Tree**
* **Binary Search Tree**
* AVL Tree
* Red Black Tree
* Threaded Binary Tree
* Expression Tree
* B Tree


## Graph DS
* **Breadth First Search (BFS)**
* **Depth First Search (DFS)**
* **Back Tracking**
* Dijkstra’s Shortest Path Algorithm
* Adjacency matrix
* Adjacency list
* Path matrix
* Warshall’s Algorithm


## Tree & Graph
* Prim's Algorithm  
* Kruskal's Algorithm


## Dynamic Programming
* **Memoization**
* **Divide-And-Conquer**


## Others
* Hashing
* **Recursion**
* **Iteration**
* **Matrices**
* **Sets**
* **Hash Maps**
* **Tries**
* Bubble Sort
* Insertion Sort
* **Quick Sort**
* **Merge Sort**
* Selection Sort
* Binary Search
* Bit Manipulation
* String
* **Multile Pointer**
* **Sliding Windows**
* **Greedy Algorithms**
* **Proofs**
	* **Contrapositive**
	* **Contradiction**
	* **Proof by Cases**
	* **Induction**


## Terminology

#### Game Logic
* **Chess:**
* **Othello:**
* **Su-Do-Ku:**
* **Poker:**

#### Problem Theory
* **Fibonacci Series:** Each number is the sum of the 2 preceding ones, starting from 0 and 1. Ex: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144... where 8 is a sum of 5 and 3, its preceding 2 numbers.
* **Factorial** A function that multiplies a number by every number below it. Ex: 5!= 5 * 4 * 3 * 2 * 1 = 120. The function is used, among other things, to find the number of ways “n” objects can be arranged.
* **Programming Paradigm:** A way to classify programming languages based on their features. Recursion is especially observed in pure functional programming languages like Haskell, Clojure, Scala, etc.
* **Permutation:**
* **Combination:**
* **Axiom:** Statement that is taken to be true.
* **Probable Outcomes:**

#### Recursion
* **Recursion Notes** [Link](https://github.com/Singularity-Coder/Code-Snippets-Algorithms/blob/main/assets/notes/Recursion.pdf)
* **Recursion:** Something defined in terms of itself. Ex: 2 = (2 * 2) / 2. Its like iteration without loops. Also means repetition. Its a programming paradigm. Implementation wise, its a function that calls itself. The idea behind recursion is that we solve the main problem by reducing it into smaller subproblems.
* **Iteration:** Repetition of a process.
* **Call stack:** Stack Data Structure that stores info about the active functions/methods/subroutines of a computer program. Also called as execution stack, program stack, control stack, run-time stack, machine stack.
* **Stack Overflow:** A programming error when too much memory is used on the call stack.
* **Base case** Its the final recursive call that actually returns a value which is then computed by the rest of the functions in the call stack. It can also be called as an "exit" condition. A conditon where we quit the recursive call.
* **Memoization or Caching of computed values:** Optimisation technique to speed up running times of programs by storing results of expensive function calls and returning the cached result when the same input occurs again.
* **Dynamic Programming (DP):** An algorithmic technique for optimising a recursive problem by breaking it into subproblems and caching the computed values (memoization) in order to not compute the same subproblem again if it occurs more than once. Refer "Memoization" definition.
* **Ways to solve Recursion / DP problems:**
	* **Bottom-Up:** Solve the problem by first solving the large subproblems using results of smaller subproblems. In-short, solve the simplest case first and build up on that.
	* **Top-Down:** We think about how we can divide the problem for case N into subproblems. Solve the problem by caching solutions to subproblems to avoid recomputing them and reuse those results when required.
	* **Half-and-Half:** Sort array first. Divide data set in half. It's a way to narrow down the data set to find an element quickly. Solve the divided problems and combin the result to solve the main problem.

#### Trees & Graphs
* **Node - with example code**
* **Directed Graph**
* **Route between Nodes**
* **Binary Search**
* **Binary Search Tree**
* **Binary Search Tree with minimal height**
* **Minimal height in a Tree**
* **Binary Tree**
* **Depth of tree/graph**
* **Graph**
* **Tree**
* **Tries (Prefix Trees)**
* **Null Node**
* **Adjacency List**
* **Adjacency Matrices**
* **Graph Search**
* **Topological sort**
* **Dijkstra's Algo**
* **AVL Trees**
* **Red-Black Trees**
* **In-Order Successor**
* **Types of Trees**
	* **Tree**
	* **Binary Tree**
	* **Binary Search Tree**
	* **Balanced Tree**
	* **Unbalanced Tree**
	* **Complete Binary Tree**
	* **Full Binary Tree**
	* **Perfect Binary Tree**
* **Binary Tree Traversal**
	* **In-Order Traversal**
	* **Pre-Order Traversal**
	* **Post-Order Traversal**
* **Binary Heaps**
	* **Min-Heap**
	* **Max-Heap**
* **Ways to search a Graph**
	* **Depth-first search**
	* **Breadth-first search**
	* **Bidirectional search**


## References
* [Difference between Bottom-Up and Top-Down](https://stackoverflow.com/questions/6164629/what-is-the-difference-between-bottom-up-and-top-down)