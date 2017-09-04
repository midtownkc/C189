/**
 * A class that implements a deque of objects by using
 * a chain of doubly linked nodes.
 * @author Maxwell Frederickson
 *
 */
public class LinkedDeque<T> implements DequeInterface<T> {
	private DLNode firstNode; // references the node for the front of the deque;
	private DLNode lastNode; // references the back of the deque;
	
	public LinkedDeque() {
		firstNode = null;
		lastNode = null;
	}// end default constructor

	public void addToFront(T newEntry) {
		DLNode newNode = new DLNode(null, newEntry, firstNode);
		if (isEmpty())
			lastNode = newNode;
		else
			firstNode.setPreviousNode(newNode);
		firstNode = newNode;
		
	}

	public void addToBack(T newEntry) {
		DLNode newNode = new DLNode(lastNode, newEntry, null);
		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode = newNode;
	}

	public T removeFront() {
		T front = null;
		if (!isEmpty()) {
			front = firstNode.getData();
			firstNode = firstNode.getNextNode();
			if (firstNode == null)
				lastNode = null;
			else
				firstNode.setPreviousNode(null);
		} // end if
		return front;
	}

	public T removeBack() {
		T back = null;
		if (!isEmpty()) {
			back = lastNode.getData();
			lastNode = lastNode.getPreviousNode();
			if (lastNode == null)
				firstNode = null;
			else
				lastNode.setNextNode(null);
		}// end if
		return back;
	}

	public T getFront() {
		T front = null;
		if (!isEmpty())
			front = firstNode.getData();
		return front;
	}

	public T getBack() {
		T back = null;
		if (!isEmpty())
			back = lastNode.getData();
		return back;
	}

	public boolean isEmpty() {
		return (firstNode == null) && (lastNode == null);
	}

	public void clear() {
		while (!isEmpty()) {
			removeFront();
		}
	}
	
	private class DLNode {
		private T data; // deqeue entry
		private DLNode next; // link to next node
		private DLNode previous; // link to previous node
		
		private DLNode(T dataPortion){
			this(null, dataPortion, null);
		}
		private DLNode(DLNode previousNode, T newEntry, DLNode nextNode) {
			data = newEntry;
			previous = previousNode;
			next = nextNode;
		}
		
		T getData() {
			return data;
		}
		
		void setData(T newData) {
			data = newData;
		}
		
		DLNode getNextNode() {
			return next;
		}
		
		void setNextNode(DLNode nextNode) {
			next = nextNode;
		}
		
		DLNode getPreviousNode() {
			return previous;
		}
		
		void setPreviousNode(DLNode previousNode) {
			previous = previousNode;
		}
		
	}

}
