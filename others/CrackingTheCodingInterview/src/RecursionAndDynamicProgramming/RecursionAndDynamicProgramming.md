A good hint that a problem is recursive is that it can be built off of sub-problems.


# How to Approach

Recursive solutions mean simply to compute *f(n)* by adding something, removing something, or otherwise changing the solution of *f(n-1)*. In other cases, you might solve the problem for the first half of the data set, then the second half, and then merge those results.


## Bottom-Up Approach

The bottom-up approach is often the most intuitive. We start with knowing how to solve the problem for a simple case, like a list with only one element. Then we figure out how to solve the problem for two elements, then for the three elements, and so on. The key here is to think about how you can build the solution for one case off of the previous case (or multiple previous cases).


## Top-Down Approach

The top-down approach can be more complex since it's less concrete. But sometimes, it's the best way to think about the problem.

In these problems, we think about how we can divide the problem for case *N* into sub-problems. Be careful of overlap between the cases.


## Half-and-Half Approach

In addition to top-down and bottom-up approaches, it's often effective to divide the data set in half.

For example, binary search works with a "half-and-half" approach. When we look for an element in a sorted array, we first figure out which half of the array contains the value. Then we recurse and search for it in that half. Merge sort is also a "half-and-half" approach. We sort each half of the array and then merge together the sorted halves.


# Recursive vs. Iterative Solutions

Recursive algorithms can be very space inefficient. Each recursive call adds a new layer to the stack, which means that if your algorithm recurse to a depth of *n*, it uses at least *O(n)* memory.

For this reason, it's often better to implement a recursive algorithm iteratively. All recursive algorithms can be implemented iteratively, although sometimes the code to do so is much more complex.


# Dynamic Programming & Memoization

Dynamic programming is mostly just a matter of taking a recursive algorithm and finding the overlapping sub-problems (that is, the repeated calls). You then cache those results for future recursive calls.

Alternatively, you can study the pattern of the recursive calls and implement something iterative. You still "cache" previous work.

Drawing the recursive calls as a tree is a great way to figure out the number of a recursive algorithm.
