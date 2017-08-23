/**
 * A linked implementation of the ADT List.
 * @author Maxwell Frederickson
 *
 */
public class LList<T> implements ListInterface<T> {
	private Node firstNode; // reference to the first node.
	private int numberOfEntries;
	public LList() {
		clear();
	} // end default constructor
	
	// note the 'final' method blow:
	public final void clear () {
		firstNode = null;
		numberOfEntries = 0;
	}
	
	// implementations of public methods go here:
	
	// Returns a reference to the node at a given position.
	// Precondition: List is not empty;
	// 1 <= givenPosition <= numberOfEntries.
	private Node getNodeAt(int givenPosition) {
		// TODO stub
		return null;
	}
	
	// private inner class
	private class Node {
		//TODO Stub
	}
}
