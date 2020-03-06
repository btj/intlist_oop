package intlist_oop;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class IntListTest {

	@Test
	void test() {
		IntList myList = new IntList();
		myList.add(7);
		myList.add(42);
		
		assertEquals(2, myList.getSize());
		assertEquals(7, myList.get(0));
		assertEquals(42, myList.get(1));
		assertTrue(Arrays.equals(myList.getElements(), new int[] {7, 42}));
		
		myList.add(33);
		myList.remove(1);
		assertEquals(2, myList.getSize());
		assertEquals(7, myList.get(0));
		assertEquals(33, myList.get(1));
		assertTrue(Arrays.equals(myList.getElements(), new int[] {7, 33}));
		
		myList.remove(0);
		assertTrue(Arrays.equals(myList.getElements(), new int[] {33}));
	}
	
	@Test
	void bigTest() {
		IntList myList = new IntList();
		for (int i = 0; i < 1000; i++)
			myList.add(13 * i);
		assert myList.getSize() == 1000;
		for (int i = 0; i < 1000; i++)
			assert myList.get(i) == 13 * i;
	}

}
