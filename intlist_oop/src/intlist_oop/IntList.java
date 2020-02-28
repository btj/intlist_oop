package intlist_oop;

import java.util.Arrays;

/**
 * @invar This object's size equals the number of elements
 *     | getSize() == getElements().length
 */
public class IntList {
	
	/**
	 * @invar {@code elements} is not null
	 *     | elements != null
	 * @invar {@code size} is between 0 and the length of {@code elements}
	 *     | 0 <= size && size <= elements.length
	 */
	private int size;
	private int[] elements = new int[10];
	
	public int getSize() { return size; }

	/**
	 * @post The result equals the element at the given index of this object's list of elements
	 *     | result == getElements()[index]
	 * @throws The given index is between 0 (inclusive) and this object's size (exclusive) 
	 *     | 0 <= index && index < getSize()
	 */
	public int get(int index) { return elements[index]; }
	
	public int[] getElements() {
		return Arrays.copyOf(elements, size);
	}
	
	/**
	 * @post This object's list of elements is empty.
	 *     | getSize() == 0
	 */
	public IntList() {}
	
	/**
	 * @post This object's size equals its old size plus one.
	 *     | getSize() == old(getSize()) + 1
	 * @post This object's existing elements remain unchanged.
	 *     | Arrays.equals(getElements(), 0, old(getSize()), old(getElements()), 0, old(getSize()))
	 * @post This object's last elements equals the given value.
	 *     | getElements()[old(getSize())] == value
	 *     | // get(old(getSize()) == value
	 *     | // get(getSize() - 1) == value
	 * @param value
	 */
	public void add(int value) {
		if (size == elements.length) {
			int[] newElements = new int[elements.length * 2];
			for (int i = 0; i < elements.length; i++)
				newElements[i] = elements[i];
			newElements[elements.length] = value;
			elements = newElements;
			size++;
		} else {
			elements[size] = value;
			size = size + 1;
			// size += 1;
			// size++;
			
			// elements[size++] = value;
		}
	}

}
