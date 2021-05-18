
package javaapplication104;

    public class DoublyLinkedList<T> {

	private Node headerNode;

	public DoublyLinkedList() {
		headerNode = null;
	}

	public void addLast(T item) {
		Node addedNode = new Node((T) item, null, null);

		if (headerNode == null) {
			headerNode = addedNode;
			return;
		}

		Node node = headerNode;

		while (node.next != null) {
			node = node.next;
		}

		node.next = addedNode;
		addedNode.previous = node;
	}

	public void addFirst(T item) {
		Node node = new Node((T) item, null, null);

		if (headerNode == null) {
			headerNode = node;
			return;
		}

		headerNode.previous = node;
		node.next = headerNode;
		headerNode = node;
	}

	public void AddwithIndex(int index, T item) {
		Node addedNode = new Node((T) item, null, null);

		if (index == 0) {
			addFirst(item);
			return;
		}

		if (index == length()) {
			addLast(item);
			return;
		}

		Node node = headerNode;

		for (int i = 1; i < index; i++) {
			node = node.next;
		}

		addedNode.next = node.next;
		node.next.previous = addedNode;
		addedNode.previous = node;
		node.next = addedNode;
	}

	public void removeLast() {
		Node node = headerNode;

		while (node.next != null) {
			node = node.next;
		}

		if (node == headerNode) {
			headerNode = null;
			return;
		}

		node.previous.next = null;
	}

	public void removeFirst() {
		Node node = headerNode;

		if (node.next == null) {
			headerNode = null;
			return;
		}

		headerNode = node.next;
		node.next.previous = null;
	}

	public void removeWithIndex(int index) {
		Node node = headerNode;

		if (index == 0) {
			removeFirst();
			return;
		}

		if (index == length() - 1) {
			removeLast();
			return;
		}

		for (int i = 1; i < index; i++) {
			node = node.next;
		}
		
		node.next = node.next.next;
		node.next.previous = node;
	}
	
	public void clear() {
		headerNode = null;
	}

	public int length() {
		Node node = headerNode;

		int result = 0;
		while (node != null) {
			node = node.next;
			result++;
		}
		return result;
	}

	public void printList() {
		Node node = headerNode;

		System.out.print("[");

		while (node != null) {
			String symbol = (node.next == null) ? "" : ", ";
			System.out.print(node.value + symbol);
			node = node.next;
		}

		System.out.println("]");
	}
}
