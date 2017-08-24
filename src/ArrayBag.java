/**
A class of bags whose entries are stored in a fixed-size array.
@author Maxwell Frederickson
 */
public class ArrayBag<T> implements BagInterface<T> 
{
	private final T[] bag;
	private static final int DEFAULT_CAPACITY = 25;
	private int numberOfEntries;
	//Creates an empty bag whose initial capacity is 25.
	public ArrayBag()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayBag(int capacity) {
		numberOfEntries = 0;
		
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[capacity];
		bag = tempBag;
	}
	
	//Add a new entry to the bag
	public boolean add(T newEntry) {
		boolean result = true;
		if (isFull()) {
			result = false;
		}
		else {
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		}
		return result;
	}
	
	//see whether bag is full
	public boolean isFull() {
		return numberOfEntries == bag.length;
	}
	
	//retrieves all entries in the bag.  Puts a new array of all entries in bag
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = bag[index];
		}
		return result;
	}
	
	public boolean contains(T anEntry) {
		return getIndexOf(anEntry) > -1;
	}
	
	private T removeEntry(int givenIndex) {
		T result = null;
		if (!isEmpty() && (givenIndex >= 0)) {
			result = bag[givenIndex];
			numberOfEntries--;
			bag[givenIndex] = bag[numberOfEntries];
			bag[numberOfEntries] = null;
		}
		return result;
	}
	
	private int getIndexOf(T anEntry) {
		int where = -1;
		boolean stillLooking = true;
		for (int index = 0; stillLooking && (index < numberOfEntries); index++) {
			if (anEntry.equals(bag[index])) {
				stillLooking = false;
				where = index;
			}
		}
		return where;
	}
	
	public T remove() {
		T result = removeEntry(numberOfEntries - 1);
		return result;
	}
	
	public boolean remove(T anEntry) {
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	}
	
	public void clear() {
		while (!isEmpty())
			remove();
	}//end clear
	
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
	
	public int getCurrentSize() {
		return numberOfEntries;
	}
	
	/**
	 * Counts the number of times a given entry appears in this bag.
	 * @param anEntry the entry to be counted
	 * @return the number of times anEntry appears in the bag.
	 */
	
	public int getFrequencyOf(T anEntry) {
		int counter = 0;
		for (int index = 0; index < numberOfEntries; index++) {
			if (anEntry.equals(bag[index])) {
				counter ++;
			}//end if
		}//end for
		return counter;
	}//end getFrequencyOf
} // end ArrayBag