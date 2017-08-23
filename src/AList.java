import java.util.Arrays;
/**
 * A class implementing a list of objects by using an array.
 * The first entry in list begins with index 1.
 * Duplicate entries are not to be allowed.
 * 
 * @author Maxwell Frederickson
 *
 */
public class AList<T> implements ListInterface<T> {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private T[] list; // Array of list entries; ignore list[0]
	private int numberOfEntries;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	public AList() {
		this(DEFAULT_CAPACITY); // Call next constructor
	} // End default constructor
	
	public AList(int initialCapacity) {
		numberOfEntries = 0;
		
		//the cast is safe beause the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempList = (T[])new Object[initialCapacity];
		list = tempList;
	}//end constructor
	
	public void add(T newEntry) {
		ensureCapacity();
		list[numberOfEntries + 1] = newEntry;
		numberOfEntries++;
	}// end add
	
	public boolean add(int newPosition, T newEntry) {
		return false;
	}//end add

	public T remove(int givenPosition) {
		return null;
		// TODO Implementation deferred for remove.
	}
	
	public void clear() {
		//TODO create clear
	}
	
	public boolean replace(int givenPosition, T newEntry) {
		//TODO Implementation of replace deferred.
		return false;
	}
	
	public T getEntry(int givenPosition) {
		//TODO Implementation of getEntry
		return null;
	}
	
	public boolean contains(T anEntry) {
		//TODO implementation deferred
		return false;
	}
	
	public int getLength() {
		return numberOfEntries;
	}
	
	public boolean isEmpty() {
		return numberOfEntries == 0; // or getLength() == 0
	}
	
	public T[] toArray() {
		
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = list[index + 1];
		}// end for
		return result;
	}//end toArray()
	
	// Doubles the capacity of the array list if it's full.
	private void ensureCapacity() {
		if (numberOfEntries == list.length) 	
		list = Arrays.copyOf(list, 2 * list.length);
	}
	
	// Makes room for a new entry at newPosition.
	// Precondition: 1 <= newPosition <= numberOfEntries + 1;
	//		numberOfEntries is list's length before addition;
	//		checkInitialization has been called.
	private void makeRoom(int newPosition) {
		assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);
		
		int newIndex = newPosition;
		int lastIndex = numberOfEntries;
		
		// Move each entry to next higher index, starting at the end of the list and continuing till the entry at newIndex is moved
		for (int index = lastIndex; index >= newIndex; index--) 
			list[index + 1] = list[index];
	}//end makeRoom
	
	//This class will also implement checkCapacity & two more private methods to be introduced later.
	
}//end class
