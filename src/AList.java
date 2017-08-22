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
		// Is initialCapacity too small?
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else // Is initial Capacity too big?
			checkCapacity(initialCapacity);
		
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempList = (T[])new Object[initialCapacity + 1];
		list = tempList;
		numberOfEntries = 0;
		initialized = true;
	}//end constructor
	
	public void add(T newEntry) {
		checkInitialization();
		list[numberOfEntries + 1] = newEntry;
		numberOfEntries++;
		ensureCapacity();
	}// end add
	
	public void add(int newPosition, T newEntry) {
		// TODO create add
	}

	public T remove(int givenPosition) {
		return null;
		// TODO Implementation deferred for remove.
	}
	
	public void clear() {
		//TODO create clear
	}
	
	public T replace(int givenPosition, T newEntry) {
		//TODO Implementation of replace deferred.
		return null;
	}
	
	public T getEntry(int givenPosition) {
		//TODO Implementation of getEntry
		return null;
	}
	
	public T[] toArray() {
		checkInitialization();
		
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = list[index + 1];
		}
		
		return result;
	}//end toArray()
	
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
	
	// Doubles the capacity of the array list if it's full.
	// Precondition: checkInitialization has been called.
	private void ensureCapacity() {
		int capacity = list.length - 1;
		if (numberOfEntries >= capacity) {
			int newCapacity = 2 * capacity;
			checkCapacity(newCapacity);
			list = Arrays.copyOf(list,  newCapacity + 1);
		}
	}
	
	//This class will also implement checkCapacity, checkInitialization & two more private methods to be introduced later.
	

}//end class
