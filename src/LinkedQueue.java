/**
 * A class that implements a queue of objects by using a chain of linked nodes.
 * @author Maxwell Frederickson
 *
 */
public class LinkedQueue<T> implements QueueInterface<T> {
	private Node<T> firstNode;
	private Node<T> lastNode;
	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
	}
	
	public void enqueue(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry, null);
		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
			lastNode = newNode;
	}
	
	public T dequeue() {
		T front = null;
		if (!isEmpty()) {
			front = firstNode.getData();
			firstNode = firstNode.getNextNode();
			if (firstNode == null)
				lastNode = null;
		}//end if
		return front;
	}
	
	public T getFront() {
		T front = null;
		if (!isEmpty())
			front = firstNode.getData();
		return front;
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}//end of class
