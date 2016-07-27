# Hash Tables
A hash table is a data structure that maps keys to values for highly efficient lookup. Here is a simple implementation, we use an array of linked list and a hash code function.

To insert a key and value, do following

1. Compute the key's hash code, which will usually be an int or long. Note that two different keys could have the same hash code, as there may be an infinite number of keys and a finite number of ints.

2. Map the hash code to an index in the array. This could be done with something like *hash(key) % array_length*.

3. At this index, there is a linked list of keys and values. Store the key and value in this index. We must use a linked list because of collisions: you could have two different keys with the same hash code, or two different hash codes that map to the same index.

To retrieve the value pair by its key, you could

1. Compute the hash code from the key.

2. Compute the index from the hash code.

3. Search through the linked list for the value with this key.


## Alternative
We can implement the hash table with a balance binary search tree. This gives us an *O(logN)* lookup time. The advantage of it is potentially using less space, since we no longer allocate a large array. We can also iterate through the keys in order.


## Hash Table Collision Resolution
- *Chaining with Linked Lists*. Hash table's array maps to a linked list of items. We just add items to this linked list. As long as the number of collisions is fairly small, this will be quite efficient. In the worst case, lookup is *O(n)*.
- *Chaining with Binary Search Trees*. We could also store collisions in a binary search tree instead of linked list. This will bring the worst-case runtime to *O(logN)*. In practice, we would rarely take this approach.
- *Open Addressing with Linear Probing*. When a collision occurs, we just move on to the next index in the array until we find an open spot. (Or sometimes, some other fixed distance, like *index + 5*). One obvious drawback is that the total number of entries in the hash table is limited by the size of the array. And another issue is clustering.
- *Quadratic Probing and Double Hashing*. You could increase the probe distance quadratically. Or use a second hash function to determine the probe distance.


# ArrayList (Dynamically Resizing Array)
An ArrayList is an array that resizes itself as needed while still providing *O(1)* access. A typical implementation is that when the array is full, the array doubles in size. Each doubling takes *O(n)* time, but happens so rarely that its amortized time is still *O(1)*.


# StringBuffer / StringBuilder
StringBuilder simply creates a resizable array of all the strings, copying them back to a string only when necessary. StringBuffer is synchronized, but StringBuilder is not.

# Rabin-Karp Substring Search
The brute force way to search for a substring *S* in a larger string *B* takes *O(s(b - s))* time. The Rabin-Karp algorithm optimize this with a little trick: if two strings are the same, they must have the same hash value. (The converse, however, is not true). Therefore if we efficiently precompute a hash value for each sequence of s characters within *B*, we can find the locations of *S* in *O(b)* time. We then just need to validate that those locations really do match *S*.

In practice, we would use a better rolling hash function, such as Rabin fingerprint. This essentially treats a string like does as a base 128 number. e.g.
> hash('doe') = code('d') * 1282 + code('o') * 1281 + code('e') * 1280

Using a good hash function like this will give us expected time complexity of *O(s + b)*, although the worst case is *O(sb)*.
