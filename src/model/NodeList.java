package model;

/**
 *
 * @author Arístides Pérez & Jesús Duarte
 * @param <T> node can hold any object
 */
public class NodeList<T> {

    private NodeList next;
    private T data;

    protected NodeList(T data) {
        this.next = null;
        this.data = data;
    }

    public NodeList getNext() {
        return next;
    }

    public void setNext(NodeList next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
