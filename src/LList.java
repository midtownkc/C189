///**
// * A linked implementation of the ADT List.
// * @author Maxwell Frederickson
// *
// */
//public class LList<T> implements ListInterface<T> {
//	private Node<T> firstNode; // reference to the first node.
//	private int numberOfEntries;
//	public LList() {
//		clear();
//	} // end default constructor
//	
//	// note the 'final' method blow:
//	public final void clear () {
//		firstNode = null;
//		numberOfEntries = 0;
//	}
//	
//	public void add(T newEntry) {
//		Node<T> newNode = new Node(newEntry);
//		if (isEmpty())
//			firstNode = newNode;
//		else {
//			Node<T> lastNode = getNodeAt(numberOfEntries);
//			lastNode.setNextNode(newNode); // make last node reference new node.
//		}
//		
//		
//	}
//	
//	// implementations of public methods go here:
//	
//	// Returns a reference to the node at a given position.
//	// Precondition: List is not empty;
//	// 1 <= givenPosition <= numberOfEntries.
//	private Node<?> getNodeAt(int givenPosition) {
//		// TODO stub
//		return null;
//	}
//
//	@Override
//	public boolean add(int newPosition, T newEntry) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public T remove(int givenPosition) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean replace(int givenPosition, T newEntry) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public T getEntry(int givenPosition) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean contains(T anEntry) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public int getLength() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public boolean isEmpty() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public T[] toArray() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	// private inner class
//}
