public interface StackInterface<T> {
	
	/**
	 * Adds a new entry to the top of the stack.
	 * @param newEntry an object to be added to the stack
	 */
	public void push(T newEntry);
	
	/**
	 * Removes and returns the stack's top entry.
	 * @return either the object at the top of the stack, or if the stack is empty before the operation: null
	 */
	public T pop();
	
	/**
	 * Retrives this stack's top entry.
	 * @return either the object at the top of the stack or null if the stack is empty.
	 */
	public T peek();
	
	/**
	 * Detects whether the stack is empty.
	 * @return true if the stack is empty.
	 */
	public boolean isEmpty();
	
	/**
	 * Removes all the entries from the stack
	 */
	public void clear();
}