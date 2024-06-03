package model;

/**
 *
 * @author jesus
 */
public class Stack {
    private Node<T> first;
    private int size;

    public Stack() {
        this.first = null;
        this.size = 0;
    }

    /**
     * Inserts a node to the end of the list
     *
     * @param data data of the node that will be inserted
     */
    public void stack(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            first = newNode;
        } else {
            first.next = newNode;
            newNode = first;
        }
        size++;
    }
    
    public Node unstack(T data) {
        Node<T> newNode = new Node<>(data);

        if (!isEmpty()) {
            newNode = first;
            first = first.next;
        }
        size--;
        return newNode;
    }
    
    /**
     *
     * @return true if the list is empty (size equals zero)
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
