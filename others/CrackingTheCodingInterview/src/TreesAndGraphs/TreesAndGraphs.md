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


# Topological Sort

A topological sort of a directed graph is a way of ordering the list of nodes such that is (a, b) is an edge in the graph then *a* will appear before *b* in the list. If a graph has cycles or is not directed, then there is no topological sort.

The algorithm is

1. Create a queue *order*, which will eventually store the valid topological sort. It is currently empty.
2. Create a queue *processNext*. This queue will store the next nodes to process.
3. Count the number of incoming edges of each node and set a class variable *node.inbound*. Nodes typically only store their outgoing edges. However, you can count the inbound edges by walking through each node *n* and, for each of its outgoing edges (n, x), incrementing *x.inbound*.
4. Walk through the nodes again and add to *processNext* any node where *x.inbound == 0*.
5. While *processNext* is not empty, do the following
    - Remove first node *n* from *processNext*.
    - For each edge (n, x), decrement *x.inbound*. If *x.inbound == 0*, append *x* to *processNext*.
    - Append *n* to *order*.
6. If *order* contains all the nodes, then it has succeeded. Otherwise, the topological sort has failed due to a cycle.


# Dijkstra's Algorithm

Dijkstra's algorithm is a way to find the shortest path between two points in a weighted directed graph (which might have cycles). All edges must have positive values.

We first initialize several variables

- *path_weight[node]*: maps from each node to the total weight of the shortest path. All values are initialized to infinity, except for *path_weight[a]* which is initialized to 0.
- *previous[node]*: maps from each node to the previous node in the (current) shortest path.
- *remaining*: a priority queue of all nodes in the graph, where each node's priority is defined by its *path_weight*.

Once we've initialized these values, we can start adjusting the values of *path_weight*. We iterate through the nodes in *remaining* (until remaining is empty), do the following.

1. select the node in *remaining* with the lowest value in *path_weight*. Call this node *n*.
2. For each adjacent node, compare *path_weight[x]* (which is the weight of the current shortest path from *a* to *x*) to *path_weight[n] + edge_weight[(n, x)]*. That is, could we get a path from *a* to *x* with lower weight by going through n instead of our current path? If so, update *path_weight* and *previous*.
3. Remove *n* from *remaining*.

When *remaining* is empty, then *path_weight* stores the weight of the current shortest path from *a* to each node. We can reconstruct this path by tracing through previous.


## Priority Queue and Runtime

In this algorithm, the priority queue can be implemented in different ways, and which is better depends.

- If the graph has a lot of edges, then *v<sup>2</sup>* will be close to *e*. In this case, you might be better off with the array implementation, as *O(v<sup>2</sup>)*.
- If the graph is sparse, then *e* is much less than *v<sup>2</sup>*. In this case, the min heap implementation may be better as *O((v+e) logv)*.


# AVL Trees

An AVL tree is one of two common ways to implement tree balancing. We will only discuss insertions here, but you can look up deletions separately if you're interested.


## Properties

An AVL tree stores in each node the height of the subtrees rooted at this node. Then, for any node, we can check if it is height balanced: that the height of the left subtree and the height of right subtree differ by no more than one. This prevents situations where the tree gets too lopsided.
> balance(n) = n.left.height - n.right.height
> -1 <= balance(n) <= 1


## Insertion

When you insert a node, the balance of some nodes might change to -2 or 2. Therefore, when we "unwind" the recursive stack, we check and fix the balance at each node. We do this through a series of rotations. Rotations can be either left or right rotations. The right rotation is an inverse of the left rotation.

Depending on the balance and where the imbalance occurs, we fix it in a different way.

1. Balance is 2.
    - In this case, the left's height is two bigger than the right's height. If the left side is larger, the left subtree's extra nodes must be hanging to the left (as in LEFT LEFT SHAPE) or hanging to the right (as in LEFT RIGHT SHAPE). If it looks like the LEFT RIGHT SHAPE, transform it with the rotations into the LEFT LEFT SHAPE then into BALANCED. If it looks like the LEFT LEFT SHAPE already, just transform it into BALANCED.
2. Balance is -2.
    - This case is the mirror image of the prior case. The tree will look like either the RIGHT LEFT SHAPE or the RIGHT RIGHT SHAPE. Perform the rotations to transform it into BALANCED.

We recurse up the tree, fixing any imbalances. If we ever achieve a balance of 0 on a subtree, then we know that we have completed all the balances. This portion of the tree will not cause another, higher subtree to have a balance of -2 or 2. If we were doing this non-recursively, then we could break from the loop.


# Red-Black Trees

Red-black trees (a type of self-balancing binary search tree) do not ensure quite as strict balancing, but the balancing is still good enough to ensure *O(logN)* insertions, deletions, and retrievals. They require a bit less memory and can rebalance faster (which means faster insertions and removals), so they are often used in situations where the tree will be modified frequently.

Red-black trees operate by enforcing a quasi-alternating red and black coloring (under certain rules) and then requiring every path from a node to its leaves to have the same number of black nodes. Doing so leads to a reasonably balanced tree.


## Properties

1. Every node is either red or black.
2. The root is black.
3. The leaves, which are NULL nodes, are considered black.
4. Every red node must have two black children. That is, a red node cannot have red children (although a black node can have black children).
5. Every path from a node to its leaves must have the same number of black children.


## Why It Balances

Property #4 means that two red nodes cannot be adjacent in a path. Therefore, no more than half the nodes in a path can be red.

Consider two paths from a node (say, the root) to its leaves. The paths must have the same number of black nodes, so let's assume that their read node counts are as different as possible.

1. Path 1 (Min Red): The minimum number of red nodes is zero. Therefore Path 1 has *b* nodes total.
2. Path 2 (Max Red): The maximum number of red nodes is *b*, since red nodes must have black children and there are *b* black nodes. Therefore, path 2 has *2b* nodes total.

Therefore, even in the most extreme case, the lengths of paths cannot differ by more than a factor of two. That's good enough to ensure an *O(logN)* find and insert runtime.


## Insertion

Inserting a new node into a red-black tree starts off with a typical binary search tree insertion.

- New nodes are inserted at a leaf, which means that they replace a black node.
- New nodes are always colored red and are given two black leaf (NULL) nodes.

Once we've done that, we fix any resulting red-black property violations.

- Red violations: A red node has a red child (or the root is red).
- Black violations: One path has more blacks than another path.

In the special case that where the root is red, we can always just turn it black to satisfy property #2, without violating the other constraints.

Let's call N the current node. P is N's parent. G is N's grandparent. U is N's uncle and P's sibling. We know that

- N is red and P is red, since we have a red violation.
- G is definitely black, since didn't previously have a red violation.

The unknown parts are

- U could be either red or black.
- U could be either a left or right child.
- N could be either a left or right child.

By simple combinations, that's eight cases to consider. Fortunately some of these cases will be equivalent.

1. U is red.
    - It doesn't matter whether U is a left or right child, nor whether P is a left or right child. We can merge four of our eight cases into one.
    - If U is red, we can just toggle the colors of P, U and G. Flip G from black to red. Flip P and U from red to black. We haven't changed the number of black nodes in any path.
    - However, by making G red, we might have created a red violation with G's parent. If so, we recursively apply the full logic to handle a red violation, where this G becomes the new N.
    - Note that in the general recursive case, N, P and U may also have subtrees in place of each black NULL. In this case, these subtrees stay attached to the same parents, as the tree structure remains unchanged.
2. U is black.
    - We'll need to consider the configurations (left vs. right child) of N and U. In each case, our goal is to fix up the red violation without
        - Messing up the ordering of the binary search tree.
        - Introducing a black violation.
    - In each of the cases, the red violation is fixed with rotations that maintain the node ordering. Further, it maintain the exact number of black nodes in each path through the affected portion of the tree that were in place beforehand. The children of the rotating section are either NULL leaves or subtrees that remain internally unchanged.
    - Case A: N and P are both left children.
        - We resolve the red violation with rotation of N, P and G and associated recoloring.  If you picture the in-order traversal, the order is a <= N <= b <= P <= c <= G <=U. The tree maintains the same, equal number of black nodes in the path down to each subtree a, b, c and U (which may all be NULL).
    - Case B: P is a left child, and N is a right child.
        - The rotation resolve the red violation and maintain the in-order property of a <= P <= b <= N <= c <= G <= U.
    - Case C: N and P are both right children.
        - This is a mirror image of case A.
    - Case D: N is a left child, and P is a right child.
        - This is a mirror image of case B.

In each of Case 2's subcases, the middle element by value of N, P and G is rotated to become the root of what was G's subtree, and that element and G swap colors.

Do not try to memorize these cases. Rather, study why they work. How does each one ensure no red violations, no black violations and no violation of the binary search tree property?
