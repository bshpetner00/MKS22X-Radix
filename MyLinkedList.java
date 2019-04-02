public class MyLinkedList {
	public Integer length;
	public Node<Integer> start,end;
	public MyLinkedList() {
		length = 0;
	}
	public Integer size() {
		return length;
	}
	public boolean add(Integer value) { //adds a value to the end of the list
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
		return true;
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
	private Node getNode(Integer i) throws IndexOutOfBoundsException { //finds node of list at given index
		if (i > length-1 || i < 0) {
			throw new IndexOutOfBoundsException("Node with given index not found");
		}
		Node nod = start;
		while (i > 0) { //loops through the list - linear
			nod = nod.next();
			i--;
		}
		return nod;
	}
	public Integer get(Integer i) throws IndexOutOfBoundsException { //finds value of node at given index
		if (i > length-1 || i < 0) {
			throw new IndexOutOfBoundsException("Given index not found");
		}
		Node<Integer> node = getNode(i);
		return node.getData();
	}
	public Integer set(Integer i, Integer val) throws IndexOutOfBoundsException { //sets value of node at given index
		if (i > length-1 || i < 0) {
			throw new IndexOutOfBoundsException("No node at given index");
		}	
		Node<Integer> node = getNode(i);
		Integer old = node.getData();
		node.setData(val);
		return old;
	}
	public boolean contains(Integer val) {
		if (length == 0) { //empty list
			return false;
		}
		Node i = start;
		while (i != null) { //goes through entire list - linear
			if (i.getData() == val) {
				return true;
			}
			else {
				i = i.next();
			}
		}
		return false;
	}
	public Integer indexOf(Integer val) {
		if (length == 0) { //empty list
			return -1;
		}
		Node i = start;
		Integer index = 0;
		while (i != null) { //goes through entire list - linear
			if (i.getData() == val) {
				return index;
			}
			i = i.next();
			index++;
		}
		return -1;
	}
	public void add(Integer i, Integer val) throws IndexOutOfBoundsException { //inserts value into given index of list
		if (i > length-1 || i < 0) {
			throw new IndexOutOfBoundsException("Given index not found");
		}
		Node noob = new Node(val);
		if (i == length-1) { //adds to end
			end.setNext(noob);
			noob.setPrev(end);
			end = noob;
			length++;
		}
		else if (i == 0) { //adds to beginning
			noob.setNext(start);
			start.setPrev(noob);
			start = noob;
			length++;
		}
		else { //adds not at end or beginning
			noob.setPrev(this.getNode(i-1));
			noob.setNext(this.getNode(i));
			this.getNode(i-1).setNext(noob);
			this.getNode(i).setPrev(noob);
			length++;
		}
	}
	public Integer remove(int i) throws IndexOutOfBoundsException { //removes given index from list
		if (i > length-1 || i < 0) {
			throw new IndexOutOfBoundsException("Given index not found");
		}
		if (length <= 1) {
			start = null;
			end = null;

		}
		Integer removed = this.get(i);
		if (i == 0) {
			start = start.next();
			start.setPrev(null);
		}
		else if (i == length-1) {
			end = end.prev();
			end.setNext(null);
		}
		else {
			this.getNode(i+1).setPrev(this.getNode(i-1));
			this.getNode(i-1).setNext(this.getNode(i+1));
		}
		length--;
		return removed;
	}
	public boolean remove(Integer val) {
		if (!this.contains(val)) {
			return false;
		}
		else {
			Integer indToRemove = this.indexOf(val);
			this.remove(indToRemove);
			return true;
		}
	}
	public void extend(MyLinkedList nuu) {
		if (nuu.length != 0) {
			if (this.length != 0) {
				this.end.setNext(nuu.start);
			}
			else {
				this.start = nuu.start;
			}
			nuu.start.setPrev(this.end);
			this.length += nuu.length;
			this.end = nuu.end;
			nuu.length = 0;
		}
	}
}
