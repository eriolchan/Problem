# Implementing a Stack

A stack uses LIFO (last in first out) ordering. It provides the following operations.

- pop()
- push(item)
- peek()
- isEmpty()

Unlike an array, a stack does not offer constant time access to the i<sub>th</sub> item. However, it does allow constant time to add and remove, as it doesn't require shifting elements around.

One case where stacks are often useful is in certain recursive algorithms. Sometimes you need to push temporary data onto a stack as you recurse, but then remove them as you backtrack. A stack offers an intuitive way to do this. A stack can also be used to implement a recursive algorithm iteratively.


# Implementing a Queue

A queue implements FIFO (first in first out) ordering. It provides the following operations.

- add(item)
- remove()
- isEmpty()

A queue can also be implemented with a linked list. In fact, they are essentially the same thing, as long as items are added and removed from opposite sides.

It is especially easy to mess up the updating of the first and last nodes in a queue. Be sure to double check this.

One place where queues are often used is in breadth-first search or in implementing a cache. In BFS, each time we process a node, we add its adjacent nodes to the back of the queue. This allows us to process nodes in the order in which they are viewed.
