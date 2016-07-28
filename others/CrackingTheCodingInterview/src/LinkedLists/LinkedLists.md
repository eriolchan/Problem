A linked list is a data structure that represents a sequence of nodes.

- In a singly linked list, each node points to the next node in the linked list.
- A doubly linked list gives each node pointers to both the next node and the previous node.

Unlike an array, a linked list does not provide constant time access to a particular "index" within the list. That means you need to iterate through *K* elements to find the *K<sub>th</sub>* element. The benefit is that you can add and remove items from the beginning of the list in constant time.

- Create a linked list.
  - Note that the head of linked list may be changed, we could implement a LinkedList class that wraps the Node class. This would essentially just have a single member variable: the head Node to resolve the issue.
- Delete a node from a singly linked list.
  - Check for the null pointer.
  - Update the head or tail pointer as necessary.


# The Runner Technique

The runner (or second pointer) technique is used in many linked list problems. It means that you iterate through the linked list with two pointers simultaneously, with one ahead of the other.
- The fast node might be ahead by a fixed amount.
- It might be hopping multiple nodes for each one node that the slow node iterates through.


# Recursive Problems
If you're having trouble solving a linked list problem, you should explore if a recursive approach will work. However, you should remember that recursive algorithms take at least *O(n)* space, where n is the depth of the recursive call. All recursive algorithms can be implemented iteratively, although they may be much more complex.
