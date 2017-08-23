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
	private static final int DEFAULT_INITIAL_CAPACITY = 25;
	
	public AList() {
		this(DEFAULT_INITIAL_CAPACITY); // Call next constructor
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
		boolean isSuccessful = true;
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			ensureCapacity();
			makeRoom(newPosition);
			list[newPosition - 1] = newEntry;
			numberOfEntries++;
		}
		else
			isSuccessful = false;
			return isSuccessful;
	}//end add

	public T remove(int givenPosition) {
		T result = null; // return value
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			result = list[givenPosition - 1]; // get and entry to be moved.  Move subsequent entries toward entry to be removed, unless it's last in the list.
			if (givenPosition < numberOfEntries)
				removeGap(givenPosition);
			numberOfEntries--;
		}//end if		
		return result; // return reference to removed entry, or null if either list is empty or givenPosition is invalid.
	}//end remove
	
	public void clear() {
		//TODO create clear
	}
	
	public boolean replace(int givenPosition, T newEntry) {
		boolean isSuccessful = true;
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			list[givenPosition - 1] = newEntry;
		}
		else 
			isSuccessful = false;
			return isSuccessful;
	}
	
	public T getEntry(int givenPosition) {
		T result = null;
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)){
			assert !isEmpty();
			result = list[givenPosition - 1];
		}
		return result;
	}
	
	public boolean contains(T anEntry) {
		boolean found = false;
		for (int index = 0; !found && (index < numberOfEntries); index++) {
			if (anEntry.equals(list[index]))
				found = true;
		}
		return found;
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
			result[index] = list[index];
		}// end for
		return result;
	}//end toArray()
	
	// Doubles the capacity of the array list if it's full.
	private void ensureCapacity() {
		if (numberOfEntries == list.length) 	
		list = Arrays.copyOf(list, 2 * list.length);
	}
	
	// Shifts entries that are beyond the entry to be removed to the next lower position.
	// Precondition: 1 <= givenPosition < numberOfEntries;
	// numberOfEntries is list's length before removal.
	private void removeGap(int givenPosition) {
		assert (givenPosition >= 1) && (givenPosition < numberOfEntries);
		int removedIndex = givenPosition - 1;
		int lastIndex = numberOfEntries -1;
		for (int index = removedIndex; index < lastIndex; index++)
			list[index] = list[index + 1];
	}
	
	// Makes room for a new entry at newPosition.
	// Precondition: 1 <= newPosition <= numberOfEntries + 1;
	//		numberOfEntries is list's length before addition;
	//		checkInitialization has been called.
	private void makeRoom(int newPosition) {		
		int newIndex = newPosition - 1;
		int lastIndex = numberOfEntries - 1;
		
		// Move each entry to next higher index, starting at the end of the list and continuing till the entry at newIndex is moved
		for (int index = lastIndex; index >= newIndex; index--) 
			list[index + 1] = list[index];
	}//end makeRoom
	
	//This class will also implement checkCapacity & two more private methods to be introduced later.
	
}//end class
