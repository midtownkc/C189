
public class LinkedStack<T> implements StackInterface<T> {
	private Node<T> topNode; // references first node in the chain
	
	public LinkedStack() {
		topNode = null;
	}// end default constructor

	public void push(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry, topNode);
		topNode = newNode;
	}

	public T pop() {
		T top = topNode.getData();
		if (topNode != null) {
			top = topNode.getData();
			topNode = topNode.getNextNode();
		}
			return top;
	}

	public T peek() {
		T top = null;
		if (topNode != null)
			top = topNode.getData();
			return top;
	}

	public boolean isEmpty() {
		return topNode == null;
	}

	public void clear() {
		topNode = null;
	}

}
