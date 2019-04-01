public class Node<E> {
	private E data;
	private Node<E> next,prev;
	public Node(E d) {
		data = d;
	}
	public E getData() {
		return data;
	}
	public Node<E> next() {
		return next;
	}
	public Node<E> prev() {
		return prev;
	}
	public E setData(E d) {
		E old = data;
		data = d;
		return old;
	}
	public void setNext(Node<E> n) {
		next = n;
	}
	public void setPrev(Node<E> p) {
		prev = p;
	}
	public String toString() {
		return "" + data;
	}
}
