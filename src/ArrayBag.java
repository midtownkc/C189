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
	
	public T remove() {
		return null; // STUB
	}
	
	public void clear() {
		// STUB
	}
	
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
	
	public int getCurrentSize() {
		return numberOfEntries;
	}
	
	
	
	//more functions and partials to be declared in BagInterface
}