import java.util.Iterator;
/**
 * An interface for a dictionary with distinct search keys.
 * @author Maxwell Frederickson
 *
 */
public interface DictionaryInterface<K, V> {
	/**
	 * Adds a new entry to this dictionary.  If the search key already exists, replaces the value.
	 * @param key an object search key of the new entry.
	 * @param value an object associated with the search key
	 * @return either null if the new entry was added to the dictionary or the value that was associated with the key if replaced.
	 */
	public V add(K key, V value);
	
	/**
	 * Removes a specific entry from this dictionary.
	 * @param key an object search key of the entry to be removed.
	 * @return either the value that was associated with the search key or null if no object exists.
	 */
	public V remove(K key);
	
	/**
	 * Retrieves from this dictionary the value associated with a given search key.
	 * @param an object search key of the entry to be retrieved.
	 * @return either the value that was associated with the search key or null if no object exists.
	 */
	public V getValue(K key);
	
	/**
	 * Sees whether a specific entry is in this dictionary.
	 * @param key an object search key of the desired entry.
	 * @return true if key is associated with an entry.
	 */
	public boolean contains(K key);
	
	/**
	 * Creates an iterator that traverses all search keys in this dictionary.
	 * @return an iterator that provides sequential access to the search keys in the dictionary.
	 */
	public Iterator<K> getKeyIterator();
	
	/**
	 * Sees whether the dictionary is empty.
	 * @return true if dictionary is empty.
	 */
	public boolean isEmpty();
	
	/**
	 * Gets the size of the dictionary.
	 * @return the number of entries (key-value pairs) currently in the dictionary.
	 */
	public int getSize();
	
	/**
	 * Removes all entries from the dictionary.
	 */
	public void clear();
}
