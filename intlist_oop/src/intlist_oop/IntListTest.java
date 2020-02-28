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
		
		assert myList.getSize() == 2;
		assert myList.get(0) == 7;
		assert myList.get(1) == 42;
		assert Arrays.equals(myList.getElements(), new int[] {7, 42});
		//assert myList.getElements() == new int[] {7, 42}; // NOT CORRECT
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
