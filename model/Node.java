package model;

/**
 *
 * @author Arístides Pérez & Jesús Duarte
 * @param <T> node can hold any object
 */
public class Node<T> {

    private Node next;
    private T data;

    Node(T data) {
        this.next = null;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
