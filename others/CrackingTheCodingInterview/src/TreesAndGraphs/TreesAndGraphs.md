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

This takes *O(logN)* time, where *n* is the number of nodes in the heap.


## Extract Minimum Element

Finding the minimum element of a min-heap is easy: it's always at the top. The trickier part is how to remove it.

1. First, we remove the minimum element and swap it with the last element in the heap (the bottommost, rightmost element).
2. Then, we bubble down this element, swapping it with one of its children until the min-heap property is restored.

Do we swap it with the left child or the right child? That depends on their values. There's no inherent ordering between the left and right element, but you'll need to take the smaller one in order to maintain the min-heap ordering.

This algorithm will also take *O(logN)* time.


# Tries (Prefix Trees)

A trie is a variant of an n-ary tree in which characters are stored at each node. Each path down the tree may represent a word.

The * nodes (sometimes called "null nodes") are often used to indicate complete words. The actual implementation of these * nodes might be a special type of child (such as a TerminatingTrieNode, which inherits from TrieNode). Or, we could use just a boolean terminates within the "parent" node. A node in a trie could have anywhere from 0 to *ALPHABET_SIZE + 1* children.

Very commonly, a trie is used to store the entire (English) language for quick prefix lookups. While a hash table can quickly lookup whether a string is a valid word, it cannot tell us if a string is a prefix of any valid words. A trie can do this very quickly, in *O(K)* time, where *K* is the length of the string. This is actually the same runtime as a hash table will take. This is because a hash table must read through all the characters in the input, which takes *O(K)* time in the case of a word lookup.

Many problems involving lists of valid words leverage a trie as an optimization. In situations when we search through the tree on related prefixes repeatedly (e.g., looking up M, then MA, then MAN, then MANY), we might pass around a reference to the current node in the tree. This will allow us to just check if Y is a child of MAN, rather than starting from the root each time.


# Graphs

A tree is actually a type of graph, but not all graphs are trees. Simply put, a tree is a connected graph without cycles.

A graph is simply a collection of nodes with edges between (some of) them.

- Graphs can be either directed or undirected. While directed edges are like a one-way street, undirected edges are like two-way street.
- The graph might consist of multiple isolated subgraphs. If there is a path between every pair of vertices, it is called a "connected graph".
- The graph can also have cycles (or not). An "acyclic graph" is one without cycles.


## Adjacency List

This is the most common way to represent a graph. Every vertex (or node) stores a list of adjacent vertices. In an undirected graph, an edge like (a, b) would be stored twice: once in a's adjacent vertices and once in b's adjacent vertices.

A simple class definition for a graph node could look essentially the same as a tree node.

```java
class Graph {
    public Node[] nodes;
}

class Node {
    public String name;
    public Node[] children;
}
```

The Graph class is used because, unlike in a tree, you can't necessarily reach all the nodes from a single node. You don't necessarily need any additional classes to represent a graph. An array (or a hash table) of lists (arrays, array lists, linked lists, etc.) can store the adjacent list. This is a bit more compact, but it isn't quite as clean. We tend to use node classes unless there's a compelling reason not to.


## Adjacency Matrices

An adjacency matrix is an *NxN* boolean matrix (where *N* is the number of nodes), where a true value at *matrix[i][j]* indicates an edge from node *i* to node *j*. In an undirected graph, an adjacency matrix will be symmetric. In a directed graph, it will not (necessarily) be.

The same graph algorithms that are used on adjacency lists (breadth-first search, etc.) can be performed with adjacency matrices, but they may be somewhat less efficient. In adjacency list representation, you can easily iterate through the neighbors of a node. In the adjacency matrix representation, you will need to iterate through all the nodes to identify a node's neighbors.


# Graph Search


## Depth-first search (DFS)

In depth-first search, we start at the root (or another arbitrarily selected node) and explore each branch completely before moving on to the next branch. That is, we go deep first before we go wide.

Note that pre-order and other forms of tree traversal are a form of DFS. The key difference is that when implementing this algorithm for a graph, we must check if the node has been visited. If we don't, we risk getting stuck in a infinite loop.

```java
void search(Node root) {
    if (root == null) return;
    visit(root);
    root.visited = true
    foreach (Node n in root.adjacent) {
        if (n.visited == false) {
            search(n);
        }
    }
}
```


## Breadth-first search (BFS)

In breadth-first search, we start at the root (or another arbitrarily selected node) and explore each neighbor before going on to any of their children. That is, we go wide before we go deep.

If you are asked to implement BFS, the key thing to remember is the use of the queue.

```java
void search(Node root) {
    Queue queue = new Queue();
    root.marked = true;
    queue.enqueue(root); // Add to the end of queue
    
    while (!queue.isEmpty()) {
        Node r = queue.dequeue(); // Remove from the front of the queue
        visit(r);
        foreach (Node n in r.adjacent) {
            if (n.marked == false) {
                n.marked = true;
                queue.enqueue(n);
            }
        }
    }
}
```

Breadth-first search and depth-first search tend to be used in different scenarios. DFS is often preferred if we want to visit every node in the graph. Both will work just fine, but depth-first search is a bit simpler. However, if we want to find the shortest path (or just any path) between two nodes, BFS is generally better.


## Bidirectional Search

Bidirectional search is used to find the shortest path between a source and destination node. It operates by essentially running two simultaneous breadth-first searches, one from each node. When their searches collide, we have found a path.

The bidirectional search is actually faster by a factor of *k<sup>d/2</sup>*. (each node has at most *k* adjacent nodes, and the shortest path from node *s* to node *t* has length *d*).
