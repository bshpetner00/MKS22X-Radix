public class MyLinkedList<E> {
	public int length;
	public Node start,end;
	public MyLinkedList() {
		length = 0;
	}
	public int size() {
		return length;
	}
	public void clear() {
		length = 0;
	}
	public void add(E value) { //adds a value to the end of the list
		Node newbie = new Node(value);
		if (length == 0) { //for empty list
			start = newbie;
			end = newbie;
		}
		else { //for list of 1 or more items
			end.setNext(newbie);
			newbie.setPrev(end);
			end = newbie;
		}
		length++;
	}
	public String toString() { //makes a String representation of the list
		if (length == 0) { //for empty list
			return "{}";
		}
		if (length == 1) { //for list of 1 item
			return "{" + start.toString() + "}";
		}
		Node i = start.next();
		String output = "{" + start.toString();
		while (i != null) {
			output = output + ", " + i.toString();
			i = i.next();
		}
		return output + "}";
	}
	public E removeFirst() { //removes front
		E removed = (E) start.getData();
		if (length <= 1) {
			start = null;
			end = null;
			length = 0;
		}
		else {
			start = start.next();
			start.setPrev(null);
			length--;
		}
		return removed;
	}
	public void extend(MyLinkedList nuu) {
		if (nuu.length != 0) {
			if (this.length != 0) {
				this.end.setNext(nuu.start);
				nuu.start.setPrev(this.end);
				this.length += nuu.length;
				this.end = nuu.end;
				nuu.length = 0;
			}
			else {
				this.start = nuu.start;
				this.end = nuu.end;
				this.length = nuu.length; 
			}
		}
	}
}
