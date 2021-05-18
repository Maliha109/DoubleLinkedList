
package javaapplication104;


public class Node {
    public Object value;
	public Node next;
	public Node previous;
	
	public Node(Object value, Node next, Node previous) {
		this.value = value;
		this.next = next;
		this.previous = previous;
	}
}
