public class Node<E> {
		private E data;
		private Node next,prev;
		public Node(E d) {
			data = d;
		}
		public E getData() {
			return data;
		}
		public Node next() {
			return next;
		}
		public Node prev() {
			return prev;
		}
		public E setData(E d) {
			E old = data;
			data = d;
			return old;
		}
		public void setNext(Node n) {
			next = n;
		}
		public void setPrev(Node p) {
			prev = p;
		}
		public String toString() {
			return "" + data;
		}
	}