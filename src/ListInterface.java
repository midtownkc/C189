/**
 * Interface for the ADT List.
 * Entries in a list have positions that begin with 1.
 * @author Maxwell Frederickson
 *
 */
public interface ListInterface<T> {
	
	/**
	 * Adds a new entry to the end of the list.
	 * Entries currently in the list are unaffected.
	 * The list's size in increased by 1.
	 * @param newEntry The object to be added as new entry.
	 */
	public void add(T newEntry);
	
	/**
	 * Adds a new entry at a specified position within this list.
	 * Entries originally at and above the specified position
	 * are at the next higher position within the list.
	 * The list's size is increased by 1.
	 * @param newPosition An integer that specifies the desired position of a new entry.
	 * @param newEntry The object to be added as a new entry.
	 */
	public boolean add(int newPosition, T newEntry);
	
	/**
	 * Removes the entry at a given position from this list.
	 * Entries originally at positions higher than the given position are are the next lower position within the list, and the list's size is decreased by 1.
	 * @param givenPosition An integer that indicates the position of the entry to be removed.
	 * @return A reference to the removed entry.
	 * @throws IndexOutOfBoundsException if either givenPosition < 1 or givenPosition > getLength().
	 */
	public T remove(int givenPosition);
	
	/**
	 * Removes all entries from this list.
	 */
	public void clear();
	
	
	/**
	 * Replaces the entry at a given position in this list.
	 * @param givenPosition An integer that indicates the position of the entry to be replaced.
	 * @param newEntry The object that will replace the entry at the position givenPosition.
	 * @return The original entry that was replaced.
	 */
	public boolean replace(int givenPosition, T newEntry);
	
	/**
	 * Retrieves the entry at a given position in the list.
	 * @param givenPosition An integer that indicates the position of the desired entry.
	 * @return A reference to the indicated entry.
	 */
	public T getEntry(int givenPosition);
	
	/**
	 * Sees whether this list contains a given entry.
	 * @param anEntry The object that is the desired entry.
	 * @return True if the list contains anEntry, or false if not.
	 */
	public boolean contains(T anEntry);
	
	/**
	 * Gets the length of the list.
	 * @return The integer number of entries currently in the list.
	 */
	public int getLength();
	
	/**
	 * Sees whether the list in empty.
	 * @return True if the list is empty, false if it is not.
	 */
	public boolean isEmpty();
	
	/**
	 * Retrieves all entries that are in this list in the order in which they are in the list.
	 * @return A newly allocated array of all the entries in the list.  IF the list is empty, returned array is empty.
	 */
	public T[] toArray();
	
}//end ListInterface
