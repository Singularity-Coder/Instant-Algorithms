![alt text](https://github.com/Singularity-Coder/Instant-Algorithms/blob/main/assets/banner_algorithm.png)
# Instant Algorithms
List of Algorithm topics and their code snippets!

------------------------------------------------------------------------------------------------------------------------

# 📦 Data Structures
## Arrays
Linear Data Structure.
* CRUD ops in Array


## Linked List
Linear Data Structure.
* CRUD ops in linked list
* **Doubly Linked List**
* **Circular Linked List**


## Stack
Data Structure.
* CRUD ops in stack


## Queue
Data Structure.
* CRUD ops in queue


## Heap
Data Structure.
* CRUD ops in heap


## Tree DS
* **Binary Tree**
* **Binary Search Tree**
* **AVL Tree**
* **Red Black Tree**
* **Threaded Binary Tree**
* **Expression Tree**
* **B Tree**


## Graph DS
Data Structure.
* CRUD ops in Graphs

------------------------------------------------------------------------------------------------------------------------

# 🧩 Algorithms

## Sorting
* **Bubble Sort**
* **Insertion Sort**
* **Quick Sort**
* **Merge Sort**
* **Selection Sort**

## Searching
* **Binary Search**

## Graph
* **Breadth First Search (BFS)**
* **Depth First Search (DFS)**
* **Back Tracking**
* **Dijkstra’s Shortest Path Algorithm**
* **Adjacency matrix**
* **Adjacency list**
* **Path matrix**
* **Warshall’s Algorithm**

## Dynamic Programming
* **Memoization**
* **Divide-And-Conquer**

## Tree & Graph
* **Prim's Algorithm**
* **Kruskal's Algorithm**

## Others
* **Hashing**
* **Recursion**
* **Iteration**
* **Matrices**
* **Sets**
* **Hash Maps**
* **Tries**
* **Bit Manipulation**
* **String**
* **Multile Pointer**
* **Sliding Windows**
* **Greedy Algorithms**

------------------------------------------------------------------------------------------------------------------------

# 📜 Proofs
## Contrapositive
## Contradiction
## Proof by Cases
## Induction

------------------------------------------------------------------------------------------------------------------------

# 🎲 Game Logic
* **Chess:**
* **Othello:**
* **Su-Do-Ku:**
* **Poker:**

------------------------------------------------------------------------------------------------------------------------

# ✍️ Problem Theory
* **Fibonacci Series:** Each number is the sum of the 2 preceding ones, starting from 0 and 1. Ex: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144... where 8 is a sum of 5 and 3, its preceding 2 numbers.
* **Factorial** A function that multiplies a number by every number below it. Ex: 5!= 5 * 4 * 3 * 2 * 1 = 120. The function is used, among other things, to find the number of ways “n” objects can be arranged.
* **Programming Paradigm:** A way to classify programming languages based on their features. Recursion is especially observed in pure functional programming languages like Haskell, Clojure, Scala, etc.
* **Permutation:**
* **Combination:**
* **Axiom:** Statement that is taken to be true. Ex: Earth is spherical in shape.
* **Probable Outcomes:**
* **Leap Year:**
* **Hashing:** 
* **Zig Zag Sequence** A sequence is a zig zag sequence if the first k elements in the sequence are in increasing order and the last k elements are in decreasing order.
* **Permuting**
* **Lexicographically**
* **Percentage:**
* **Divisibility by 2:**
* **Three way deadlock:**

------------------------------------------------------------------------------------------------------------------------

# ⏱ Aymptotic Analysis
* **Asymptotic Analysis Notes** [Link](https://github.com/Singularity-Coder/Code-Snippets-Algorithms/blob/main/assets/notes/AsymptoticAnalysis.pdf)
* Language and metric used to define efficiency of algorithm.
* Asymptotic runtime is a.k.a Big O time.
* Algorithmic runtime example - Large file transfer:
	* Electronic transfer is O(s) time where "s" is file size. Time to transfer file == file size.
	* Airplane transfer is O(1) time as even if the file size increases the time taken to transfer the file remains the same.
* Why constant time is considered better than all? In general, no matter how big the constant and how slow the linear increase, Linear will surpass cosntant time.

------------------------------------------------------------------------------------------------------------------------

# 🏄‍♂️ Algorithmic Techniques

## 2 Pointer
* Problem

## Dynamic Programming
* Problem

------------------------------------------------------------------------------------------------------------------------

# 🤔 Problem Solving Techniues
## Sorted array Qs
* Use Binary Search and 2 pointer technique

## Linked List Qs
* Use 2 pointer (Slow and Fast pointers)

## Top / Least K items Qs
* Use Heap

## Tree or Graph Qs
* Use BFS or DFS

## Frequency / Duplicates
* Use HashMap

## Max / Min subarray or subset Qs
* Use Dynamic Programming

## Permutations / Subsets Qs
* Use Recursion or Backtracking

------------------------------------------------------------------------------------------------------------------------

# 🧠 Terminology

## Recursion
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


## Trees & Graphs
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


## Miscellaneous
* **Data:** The quantities, characters or symbols on which operations are performed by a computer, which may be stored and transmitted in the form of electrical signals and recorded on magnetic, optical or mechanical recording media.
* **Expression:** A function with return value or a variable. They are things that have values. You assign expressions to variables.
* **Statement:** Code with an assignment operator. They are things that have effects. You write statements to assign things to other things.
* **Pascal Case:** KotlinCodeSnippets  
* **Camel Case:** kotlinCodeSnippets  
* **Snake Case:** kotlin_code_snippets 
* **Main Function:** Entry point in our app.  
* **Compiler:** Translates high level language to low level language that machine can understand. Also checks for syntax errors.  
* **Run Kotlin Program:** Converts Kotlin code to Java byte code to run it on JVM. JVM further converts the Java byte code into machine code that <a href=""></a> platform like Mac or Windows can understand.  
* **Statically Typed Programming Language:** Type of a variable is known at compile-time. So once variable is declared with a type, it cannot ever be assigned to a variable of different type and doing so will result in a type error at compile-time. So you CANNOT build the app without fixing the bugs. Fast & Efficient. Ex: Kotlin, Java, C, C++, etc.  
* **Dynamically Typed Programming Language:** Type of a variable is known at run-time. Variables are bound to objects at run-time. You can assign a variable with a different an Integer type even if it was initially assigned String type. So you CAN build the app without fixing the bugs. Slow & less optimized but has its own advantages like dynamic dispatch, late binding, down-casting, reflection. Ex: JavaScript, Objective-C, PHP, Python, Ruby, Lisp, etc.  
* **Type Checking:** The process of verifying and enforcing the constraints of types.  
* **Static check:** Type check happening at compile-time.  
* **Dynamic check:** Type check happening at run-time.  
* **Strongly-typed language:** Variables are bound to specific data types, and will result in type errors if types do not match up as expected in the expression - regardless of when type checking occurs. Ex: Java, Python, etc.  
* **Weakly-typed language:** Variables are not bound to a specific data type; they still have a type, but type safety constraints are lower compared to strongly-typed languages. Ex: PHP, C, C++, etc.  
* **Top-Level function:** A function that is not enclosed in a class.  
* **Double Type:** Double-precision floating-point. More exact than Float numbers.
* **Number System:** A way of representing numbers. The value of any digit in a number can be known if we know:
    1. The Digit 
    2. Its position in the number
    3. The base/radix of the number system
* **Radix/Base:** Available numbers in a number system (or) numbers used in a system (or) number of digits used in a positional number system. Ex: base-10 numbering system or decimal numbers (0,1,2,3,4,5,6,7,8, and 9) is most common. So the radix/base for Decimal numbers is 10. Computers deal with base-2 or binary which only deals with numbers 0 and 1. So for binary numbers the radix/base is 2.
* **Types of base or Types of Number Systems:** 
    1. Base-2 (Binary): Uses only 0, 1
    2. Base-8 (Octal): Uses only 0, 1, 2, 3, 4, 5, 6, 7
    3. Base-10 (Decimal): Uses only 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    4. Base-16 (Hexadecimal): Uses only 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F
* **Signed Integer:** Whole range of integers negative, zero and positive integers. Ex: -∞...-3, -2, -1, 0, 1, 2, 3...∞
* **Unsigned Integer:** Non-negative integers including 0. Ex: 0, 1, 2, 3...∞
* **ASCII:** American Standard Code for Information Interchange.
* **ASCII Characters:** Start from 0 to 127. Consist of commonly used characters like upper and lower case english letters, numbers, etc. Each character is exactly 8 bits or 1 byte.
* **Extended ASCII Characters:** Start from 128 to 256. Extended set of ASCII characters that include famous currency symbols, etc.
* **Unicode Characters:** Emojis, Math symbols, Spoken Language characters, etc.
* **ISO:** International Standards Organization.
* **1 bit:** A bit is a binary digit. It can hold either a 0 value or 1 value.
* **1 byte:** 8 bits form a byte. It can store a single ASCII character like 'C'. Since each bit can hold either a 0 or 1, the character 'C' will have 01000011 values where each bit out of the 8 holds a 0 or 1.
* **1 kilobyte (KB):** 1024 bytes form a kilobyte.
* **1 megabyte (MB):** 1024 kilobytes form a megabyte.
* **1 gigabyte (GB):** 1024 megabytes form a gigabyte.
* **1 terabyte (TB):** 1024 gigabytes form a terabyte.
* **1 petabyte (PB):** 1024 terabytes form a petabyte.
* **1 exabyte (EB):** 1024 petabytes form a exabyte.
* **1 zettabyte (ZB):** 1024 exabytes form a zettabyte.
* **1 yottabyte (YB):** 1024 zettabytes form a yottabyte.
* **1 Mbps:** Lowercase 'b' means 1 megabits per second. Broadband connection terminology.
* **1 MBps:** Uppercase 'B' means 1 megabytes per second. Broadband connection terminology.
* **Operator:** A symbol that tells the compiler or interpreter to perform specific mathematical, relational or logical operation and produce a result. Ex: +, -, &&, ||, etc.
* **Operand:** The element(s) we are operating on.
* **Unary Operator:** Operate on a single operand or element. Ex: a++
* **Binary Operator:** Operate on 2 operands or elements. Ex: a + b
* **Ternary Operator:** Operate on 3 operands or elements. Ex: a ? b : c
* **Infix Operator:** Operator is inbetween 2 operands. Like the + in a + b
* **Prefix Operator:** Operator to the left of an operand. Like ++a
* **Postfix Operator:** Operator to the right of an operand. Like a++
* **Operator Overloading or ad hoc polymorphism:** A specific case of polymorphism, where different operators have different implementations depending on their arguments. Ex: + can behave like -, etc.
* **Module:** A module encapsulates complex functionality away from user, provides a well defined interface for a user and it should have a plug-and-play setup.
* **Abstract Data Type:** A set of rules on how something should behave and operate. Ex: A linked list can implement the stack abstract data type (ADT).
* **Data Structure:** A particular way of organizing data. Its a concrete implementation of an Abstract Data Type.
* **Abstract in Programming:** Set of rules that must be followed. Like an interface. No implementation. Like an idea that is not tangible until implemented.
* **Client/Server Model:** Client makes a request. Server responds to that request.
* **Proxy:** Software that makes a request on behalf of Client.
* **Application Programming Interface (API):** Mediator software that allows 2 apps to communicate. (OR) A set of publicly exposed methods that allow access to the data layer.
* **Software Development Kit (SDK):** Collection of APIs. Ex: To build Android Apps, you need an Android SDK.
* **Cache:** A quicker way of accessing something. Ex: Kitchen Pantry is a cache for the grocery store. Programs currently running on a computer are cache for all the big files saved in the hard drive. Files saved on hard drive of a computer is a cache for all the things saved on the cloud.
* **Compilation:** Converting human readable code like Java, Kotlin, Python into machine readable code.
* **Open Device:** MacBook Pro. General purpose. Its the system.
* **Embedded Device:** iPod. Specific purpose. Its a subset of the system.
* **Deeply Embedded Device:** Nest thermostat. Super specific purpose. Its a subset of another subset.
* **Middleware:** Software that acts as a bridge between an operating system or database and applications, especially on a network.
* **Serialization:** Converting object to byte stream.
* **Deserialization:** Converting byte stream to object.
* **Parse:** Process of findng the meaning of a sentence by breaking it into parts that are syntactically and grammatically correct.
* **Traversal:** Visiting each element in a data structure exactly once.
* **Fibonacci Numbers:** Each number is the sum of the 2 preceding ones, starting from 0 and 1. Ex: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144... where 8 is a sum of 5 and 3, its preceding 2 numbers.
* **Palindrome:** A word, number, phrase, or other sequence of characters which reads the same backward as forward, such as madam or racecar. There are also numeric palindromes, including date/time stamps using short digits 11/11/11 11:11 and long digits 02/02/2020. Refer Wikipedia.
* **Factorial:** A function that multiplies a number by every number below it. Ex: 5!= 5 * 4 * 3 * 2 * 1 = 120. The function is used, among other things, to find the number of ways “n” objects can be arranged.
* **Armstrong Number:** A number that is equal to the sum of cubes of its digits. Ex: 0, 1, 153, 370, 371, 407, etc. If we take 153 -> 1^3 = 1, 5^3 = 125, 3^3 = 27. So 1 + 125 + 27 = 153. 
* **Natural Numbers (N):** Also called as Positive Integers, Counting Numbers. 1, 2, 3...∞
* **Whole Numbers (W) or Non-Negative Integers (Z Star):** Set of Natural Numbers, plus Zero. 0, 1, 2, 3...∞
* **Integers (Z):** Set of Negative numbers and Whole Numbers. -∞...-3, -2, -1, 0, 1, 2, 3...∞   
* **Rational Numbers (Q):** Can be expressed as ratio of two integers. All the fractions where the top and bottom numbers are integers. The denominator cannot be 0, but the numerator can be. 1/2, 3/4, 7/2, ⁻4/3, 4/1.
* **Unit Fractions:** If numerator of a fraction is one. 1/2, 1/3, 1/4, 1/5.
* **Decimal Fractions:** Decimal numbers (such as 0.3,  0.32, -2.7) can be called decimal fractions, because they can be written in a fractional form (e.g., 3/10, 32/100, -27/10).
* **Irrational Numbers (Q' or Q Prime):**
* **Real Numbers (R):** 
* **Complex Numbers (C):**
* **Prime Numbers:**
* **Composite Numbers:**
* **Dynamic Memory Allocation:**
* **Preprocessor:**
* **Matrix:**
* **2D Matrix:**
* **3D Matrix:**
* **Numeric Characters:** 
* **Alphanumeric Characters:** Subsets of ASCII characters. Depends on the implementation and requirements. Some allow all ASCII characters while others use a subset of them. Generally Alphabets, Numbers and few Special characters. 0 to 9, A to Z(both uppercase and lowercase), @ # * & etc.
* **Enumeration:** List things one by one. To count. A synonym to the verb "list". It emphasizes the fact that things are being specifically identified and listed one at a time. In mathematics and computer science, enumeration is a complete, ordered listing of all the items in a collection. Used to refer to a listing of all of the elements of a set. 
* **Protobuf:** Protocol buffers are Google's language-neutral(any programming language), platform-neutral(any OS like Mac or Windows), extensible mechanism for serializing structured data.
* **Encoding:** Converting or Transforming (information or an instruction) into another form.
* **Decoding:** Converting or Translating (coded or encoded info) into an understandable form.
* **Cipher:** Secret or disguised way of writing; a code.
* **Callback:** You tell it to do something and it will let you know when its done.
* **DSL:** Domain-Specific Language.
* **Main Memory:** Random Access Memory (RAM). 
* **Data Structure:** A way to arrange data in main memory (RAM) for efficient usage. Ex: Arrays, LinkedLists, Stacks, etc.
* **Algorithm:** Sequence of steps that solves a problem.
* **Database:** Collections of data stored in permanent storage that can be added, fetched, updated and deleted.
* **Data Warehousing:** 
* **Big Data:** 
* **Binary to Decimal Conversion:** Binary numeral system: 1 is ON and 0 is OFF. 0s don't matter. 1s only matter so add the 2^placeValue values. So 1001011 is 75 in binary. Read from right to left.
```
Binary Number:             1     0     0     1     0     1     1
Place Value:               6     5     4     3     2     1     0
2 power Place Value:       2^6   2^5   2^4   2^3   2^2   2^1   2^0
Solve the above:           64    32    16    8     4     2     1

Add the 1 bit values:      64 + 8 + 2 + 1 = 75
```
* **Hexadecimal to Decimal Conversion:**
* **Octal to Decimal Conversion:**
* **Test Driven Development (TDD):** Write the test for the feature you want to build first before building the actual feature. Make it fail and then make it pass the test.
* **binary operator - needs 2 operands:**
* **Unary operator - single operand:**
* **Signed:**
* **Unsigned:**
* **one’s complement:**
* **2’s complement:**
* **Unix Time:**
* **Even Odd:** If you add odd to odd, odd to even, even to even, even to odd. Rules of Odd Even multiplication, division.


# New
* Pointer: 
* In-Place Operations:
* Multiple pointer technique:

# Basic Math
* Division: 
	* Ex: 105/8 -> 8 * 13 = 104. What remains of 105 after dividing into 8 parts is 1. Here 105 is Dividend. 8 is the Divisor. 13 is the Quotient. 1 is the Remainder.
	* Dividend = Divisor * Quotient + Remainder -----> 105 = 8 * 13 + 1
* Factor: A number x that divides another number y evenly without leaving a remainder. Ex: 8 is a factor of 32 since 8 divides 32 into 4 equal parts. 
* Common factor: If a number x divides more than 1 number say y and z evenly without leaving a reminder then x is a common factor of y and z. Ex: 2 is a factor of 4 and 8, hence 2 is a common factor.
* GCD (Greatest common divisor) or HCF (Highest common factor): Largest common factor btw 2 or more numbers that divides those numbers evenly without leaving any reminder. Ex: 10 and 15 have 5 as the largest number that divides both of them without leaving a reminder. 10/5 = 2 and 15/5 = 3.
* LCM - Least common multiple
* Find the factors of a number say 35? A.k.a find numbers that divide 35 without leaving a reminder.


------------------------------------------------------------------------------------------------------------------------

# 🙏 References
* [Scaler - Data Structures and Algorithms Full Course with Interview Q & A](https://www.youtube.com/watch?v=PlJHXayxQzE)
* [Difference between Bottom-Up and Top-Down](https://stackoverflow.com/questions/6164629/what-is-the-difference-between-bottom-up-and-top-down)
* https://leetcode.com/problemset/all/
* https://projecteuler.net/
* https://icpc.global/worldfinals/problems
* https://medium.com/codechef-vit/how-to-identify-which-data-structure-to-use-5a1c66ad2742

------------------------------------------------------------------------------------------------------------------------

# 🛠 How to edit?
* Use VS Code
* To preview in VS Code: Cmd + Shift + v
* View preview in split window
* VS Code extensions:
	* Markdown Emoji
	* Markdown Math
* VS Code Reference for markdown: https://code.visualstudio.com/docs/languages/markdown