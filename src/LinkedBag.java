/**
 * A class of bags whose entries are stored in a chain of linked nodes.
 * A bag is never full.
 * @author Maxwell Frederickson
 *
 */
public class LinkedBag<T> implements BagInterface<T> {
	private Node<T> firstNode; // reference to the first Node
	private int numberOfEntries;
	public LinkedBag() {
		firstNode = null;
		numberOfEntries = 0;
	}// end default constructor

	public int getCurrentSize() {
		return numberOfEntries;
	}

	// isFull() Always returns false in a linked-chain.  OutOfMemoryError occurs if chain runs out.
	public boolean isFull() {
		return false;
	}

	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	/**
	 * Adds a new entry to this bag.
	 * @param newEntry the object to be added as a new entry.
	 * @return true
	 */
	public boolean add(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry);
		newNode.setNextNode(firstNode);
		firstNode = newNode;
		numberOfEntries++;
		return true;
	}

	/**
	 * Removes one unspecified entry from this bag, if possible.
	 * @return either the removed object if the removal was successful, or null
	 */
	public T remove() {
		T result = null;
		if (firstNode != null) {
			result = firstNode.getData();
			firstNode = firstNode.getNextNode(); // removes first node from the chain.
			numberOfEntries--;
		}//end if
		
		return result;
	}

	/**
	 * Removes one occurrence of a given entry from this bag, if possible
	 * @param anEntry the entry to be removed.
	 * @return true if the removal was successful.
	 */
	public boolean remove(T anEntry) {
		boolean result = false;
		Node<T> nodeN = getReferenceTo(anEntry);
		if (nodeN != null) {
			nodeN.setData(firstNode.getData()); // replace located entry with entry
			// in first node
			remove (); // remove first node
			result = true;
		}
		return result;
	}

	public void clear() {
		while (!isEmpty())
			remove();
	}//end clear

	/**
	 * Counts the number of times an item appears in the bag.
	 * @param anEntry the entry to be counted.
	 * @return the number of times an entry appears.
	 */
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		int counter = 0;
		Node<T> currentNode = firstNode;
		while ((counter < numberOfEntries) && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				frequency++;
				counter++;
				currentNode = currentNode.getNextNode();
		}//end while
		return frequency;
	}

	public boolean contains(T anEntry) {
		boolean found = false;
		Node<T> currentNode = firstNode;
		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}
		return found;
	}

	@SuppressWarnings("unchecked")
	public T[] toArray() {
		// the cast is safe because the new array contains null entries
		T[] result = (T[])new Object[numberOfEntries];
		int index = 0;
		@SuppressWarnings("rawtypes")
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = (T) currentNode.getData();
			index++;
			currentNode = currentNode.getNextNode();
		}//end while
		return result;
	}// end toArray()
	
	private Node<T> getReferenceTo(T anEntry) {
		boolean found = false;
		Node<T> currentNode = firstNode;
		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}// end while
		
		return currentNode;
	}

}// end LinkedBag
