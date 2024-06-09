package model;

import java.util.NoSuchElementException;

/**
 * A classical Queue, it inserts at the end and removes at the beginning
 *
 * @author Arístides Pérez
 * @param <T> nodes can hold any object
 */
public class Queue<T> {

    private final LinkedList<T> queue;

    public Queue() {
        this.queue = new LinkedList<>();
    }

    /**
     * Get the head of the queue without dequeuing, the next element to dequeue
     *
     * @return head of the queue
     */
    public T getHead() {
        return queue.getFirst();
    }

    /**
     * Enqueue the element to the tail of the queue, it is inserted at the end.
     * Complexity: O(1)
     *
     * @param data object to enqueue
     */
    public void enqueue(T data) {
        queue.insert(data);
    }

    /**
     * Dequeue the element from the head of the queue, it is removed at the
     * beginning. Complexity: O(1)
     *
     * @return the element dequeued
     */
    public T dequeue() {
        if (!isEmpty()) {
            T aux = queue.getFirst();
            queue.delete(0);
            return aux;
        }

        throw new NoSuchElementException("The queue is empty; cannot dequeue");
    }

    /**
     * Checks whether the queue is empty or not
     *
     * @return boolean value
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * String representation of queue
     *
     * @return StringList
     */
    @Override
    public String toString() {
        return queue.toString();
    }

    /**
     * Current enqueued nodes
     *
     * @return integer value
     */
    public int getSize() {
        return queue.getSize();
    }
}
