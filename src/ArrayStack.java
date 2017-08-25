import java.util.Arrays;

/**
 * A class of stacks whose entries are stored in an array.
 * @author Maxwell Frederickson
 *
 */
public class ArrayStack<T> implements StackInterface<T> {
	private T[] stack; // array of stack entries
	private int topIndex; // index of top entry
	private static final int DEFAULT_INITIAL_CAPACITY = 50;
	
	public ArrayStack() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	public ArrayStack(int initialCapacity) {
		// the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		
		stack = tempStack;
		topIndex = -1;
	}

	public void push(T newEntry) {
		ensureCapacity();
		topIndex++;
		stack[topIndex] = newEntry;
	}

	public T pop() {
		T top = null;
		if (!isEmpty()) {
			top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
		}
		return top;
	}

	public T peek() {
		T top = null;
		if (!isEmpty())
			top = stack[topIndex];
		return top;
	}// this operation is O(1)

	public boolean isEmpty() {
		return topIndex < 0;
	}

	public void clear() {
		while (!isEmpty()) {
			pop();
		}
	}
	
	private void ensureCapacity() {
		if (topIndex == stack.length - 1)// if array is full, double the size of array
			stack = Arrays.copyOf(stack, 2 * stack.length);
	}
}
