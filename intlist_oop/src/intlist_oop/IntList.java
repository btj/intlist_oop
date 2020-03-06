package intlist_oop;

import java.util.ArrayList;
import java.util.Arrays;

class Node {
	int value;
	Node next;
}

/**
 * @invar This object's size equals the number of elements
 *     | getSize() == getElements().length
 */
public class IntList {
	
	/**
	 * @invar {@code firstNode} is not null
	 *     | firstNode != null
	 * @invar The linked list does not have a cycle
	 *     | !isCyclic()
	 */
	private Node firstNode;
	
	private boolean isCylic() {
		ArrayList<Node> nodesSeen = new ArrayList<Node>();
		for (Node currentNode = firstNode; currentNode != null; currentNode = currentNode.next) {
			if (nodesSeen.contains(currentNode))
				return true;
			nodesSeen.add(currentNode);
		}
		return false;
	}
	
	public int getSize() {
		int size = 0;
		Node currentNode = firstNode.next;
		while (currentNode != null) {
			size++;
			currentNode = currentNode.next;
		}
		return size;
	}

//	 * @pre The index is within bounds
//	 *     | 0 <= index && index < getSize()
	/**
	 * Returns the value at the given index (zero-based)
	 * in this list of integers.
	 * 
	 * @throws IllegalArgumentException if the index is out of range
	 *     | !(0 <= index && index < getSize())
	 * @post The result equals the element at the given index of this object's list of elements
	 *     | result == getElements()[index]
	 */
	public int get(int index) {
		if (!(0 <= index && index < getSize()))
			throw new IllegalArgumentException("index out of range");
		
		Node currentNode = firstNode.next;
		for (int i = 0; i < index; i++)
			currentNode = currentNode.next;
		return currentNode.value;
	}
	
	public int[] getElements() {
		int[] elements = new int[getSize()];
		Node currentNode = firstNode.next;
		for (int i = 0; i < elements.length; i++) {
			elements[i] = currentNode.value;
			currentNode = currentNode.next;
		}
		return elements;
	}
	
	/**
	 * @post This object's list of elements is empty.
	 *     | getSize() == 0
	 */
	public IntList() {
		firstNode = new Node();
	}
	
	/**
	 * Adds the given value to the end of this list of integers.
	 * 
	 * @post This object's size equals its old size plus one.
	 *     | getSize() == old(getSize()) + 1
	 * @post This object's existing elements remain unchanged.
	 *     | Arrays.equals(getElements(), 0, old(getSize()), old(getElements()), 0, old(getSize()))
	 * @post This object's last elements equals the given value.
	 *     | getElements()[old(getSize())] == value
	 */
	public void add(int value) {
		Node currentNode = firstNode;
		while (currentNode.next != null)
			currentNode = currentNode.next;
		currentNode.next = new Node();
		currentNode.next.value = value;
	}

	/**
	 * Removes the element at the given index from this list of integers.
	 * 
	 * @throws IllegalArgumentException if the index is out of range
	 *     | !(0 <= index && index < getSize())
	 * @post This object's size equals its old size minus one.
	 *     | getSize() == old(getSize()) - 1
	 * @post The elements of this list at indices less than the given index have remained unchanged.
	 *     | Arrays.equals(getElements(), 0, index, old(getElements()), 0, index)
	 * @post The elements of this list at indices not less than the given index equal
	 *       the old elements at the next greater index.
	 *     | Arrays.equals(getElements(), index, getSize(), old(getElements()), index + 1, old(getSize()))
	 */
	public void remove(int index) {
		if (!(0 <= index && index < getSize()))
			throw new IllegalArgumentException("index out of range");
		
		Node currentNode = firstNode;
		for (int i = 0; i < index; i++, currentNode = currentNode.next) {
		}
		currentNode.next = currentNode.next.next;
	}

}
