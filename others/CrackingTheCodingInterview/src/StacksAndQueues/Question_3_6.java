package StacksAndQueues;

import java.util.LinkedList;

/**
 * Question 3.6
 * An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
 * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they
 * can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
 * They cannot select which specific animal they would like. Create the data structure to maintain this system
 * and implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat. You may use the built-in
 * LinkedList data structure.
 */
public class Question_3_6 {

    private int order;
    private LinkedList<Dog> dogs;
    private LinkedList<Cat> cats;
    
    public Question_3_6() {
        order = 0;
        dogs = new LinkedList<Dog>();
        cats = new LinkedList<Cat>();
    }
    
    public void enqueue(Animal animal) {
        animal.setOrder(order);
        ++order;
        
        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        }
    }
    
    public Animal dequeueAny() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        
        if (dogs.size() == 0) {
            return cats.poll();
        } else if (cats.size() == 0) {
            return dogs.poll();
        }
        
        if (dogs.peek().compareOrder(cats.peek())) {
            return dogs.poll();
        } else {
            return cats.poll();
        }
    }
    
    public Dog dequeueDog() throws EmptyQueueException {
        if (dogs.size() == 0) {
            throw new EmptyQueueException();
        }
        
        return dogs.poll();
    }
    
    public Cat dequeueCat() throws EmptyQueueException {
        if (cats.size() == 0) {
            throw new EmptyQueueException();
        }
        
        return cats.poll();
    }
    
    private boolean isEmpty() {
        return cats.size() + dogs.size() == 0;
    }
}

abstract class Animal {

    private String name;
    private int order;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void setOrder(int order) {
        this.order = order;
    }
    
    public int getOrder() {
        return order;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean compareOrder(Animal animal) {
        return order < animal.getOrder();
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }
}
