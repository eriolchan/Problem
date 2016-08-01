# Type of Trees

A nice way to understand a tree is with a recursive explanation. A tree is a data structure composed of nodes.

- Each tree has a root node. (Actually, this isn't strictly necessary in graph theory, but it's usually how we use trees in programming.)
- The root node has zero or more child nodes.
- Each child node has zero or more child nodes, and so on.

The tree cannot obtain cycles. The nodes may or may not be in a particular order, they could have any data type as values, and they may or may not have links back to their parent nodes.


## Trees vs. Binary Trees

A binary tree is a tree in which each node has up to two children. Not all trees are binary trees. A node is called a "leaf" node if it has no children.


## Binary Tree vs. Binary Search Tree

A binary search tree is a binary tree in which every node fits a specific ordering property: 
> all left descendants <= n < all right descendants.

This must be true for each node *n*. A binary search tree imposes the condition that, for each node, its left descendants are less than or equal to the current node, which is less than the right descendant.


## Balanced vs. Unbalanced

One way to think about it is that a "balanced" tree really means something more like "not terribly imbalanced". It's balanced enough to ensure *O(logN)* times for insert and find, but it's not necessarily as balanced as it could be.

Two common types of balanced trees are red-black tree and AVL trees. 


## Complete Binary Tree

A complete binary tree is a binary tree in which every level of the tree is fully filled, except for perhaps the last level. To the extent that the last level is filled, it is filled left to right.


## Full Binary Tree

A full binary tree is a binary tree in which every node has either zero or two children. That is, no nodes have only one child.


## Perfect Binary Tree

A perfect binary tree is one that is both full and complete. All leaf nodes will be at the same level, and this level has the maximum number of nodes. Note that perfect trees are rare in interviews and in real life, as a perfect tree must have exactly *2<sup>k</sup> - 1* nodes. (where *k* is the number of levels). In an interview, do not assume a binary tree is perfect.


# Binary Tree Traversal


## In-Order Traversal

In-order traversal means to "visit" (often, print) the left branch, then the current node, and finally the right branch. When performed on a binary search tree, it visits the nodes in ascending order (hence the name "in-order").


## Pre-Order Traversal

Pre-order traversal visits the current node before its child nodes (hence the name "pre-order"). In a pre-order traversal, the root is always the first node visited.


## Post-Order Traversal

Post-order traversal visits the current node after its child nodes (hence the name "post-order"). In a post-order traversal, the root is always the last node visited.


# Binary Heaps (Min-Heaps and Max-Heaps)

A min-heap is a complete binary tree (that is, totally filled other than the rightmost elements on the last level) where each node is smaller than its children. The root, therefore, is the minimum element in the tree. We have two key operations on a min-heap: 

- *insert*
- *extract_min*


## Insert

1. When we insert into a min-heap, we always start by inserting the element at the bottom. We insert at the rightmost spot so as to maintain the complete tree property.
2. Then we "fix" the tree by swapping the new element with its parent, until we find an appropriate spot for the element. We essentially bubble up the minimum element.

This takes *O(log n)* time, where *n* is the number of nodes in the heap.


## Extract Minimum Element

Finding the minimum element of a min-heap is easy: it's always at the top. The trickier part is how to remove it.

1. First, we remove the minimum element and swap it with the last element in the heap (the bottommost, rightmost element).
2. Then, we bubble down this element, swapping it with one of its children until the min-heap property is restored.

Do we swap it with the left child or the right child? That depends on their values. There's no inherent ordering between the left and right element, but you'll need to take the smaller one in order to maintain the min-heap ordering.

This algorithm will also take *O(log n)* time.


# Tries (Prefix Trees)

A trie is a variant of an n-ary tree in which characters are stored at each node. Each path down the tree may represent a word.

The * nodes (sometimes called "null nodes") are often used to indicate complete words. The actual implementation of these * nodes might be a special type of child (such as a TerminatingTrieNode, which inherits from TrieNode). Or, we could use just a boolean terminates within the "parent" node. A node in a trie could have anywhere from 0 to *ALPHABET_SIZE + 1* children.

Very commonly, a trie is used to store the entire (English) language for quick prefix lookups. While a hash table can quickly lookup whether a string is a valid word, it cannot tell us if a string is a prefix of any valid words. A trie can do this very quickly, in *O(K)* time, where *K* is the length of the string. This is actually the same runtime as a hash table will take. This is because a hash table must read through all the characters in the input, which takes *O(K)* time in the case of a word lookup.

Many problems involving lists of valid words leverage a trie as an optimization. In situations when we search through the tree on related prefixes repeatedly (e.g., looking up M, then MA, then MAN, then MANY), we might pass around a reference to the current node in the tree. This will allow us to just check if Y is a child of MAN, rather than starting from the root each time.

