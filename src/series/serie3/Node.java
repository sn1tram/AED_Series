package series.serie3;


public class Node<E> {
    public Node<E> left;
    public Node<E> right;
    public E value;

    public Node() {
    }

    public Node(E e) {
        value = e;
    }

    public boolean equals(Object o){

        Node<E> node = (Node<E>) o;
        return value == node.value;

    }

}
