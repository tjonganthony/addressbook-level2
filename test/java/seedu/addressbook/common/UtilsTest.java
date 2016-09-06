package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Arrays;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void isAnyNull_emptyItems() {
		assertFalse(Utils.isAnyNull());
	}
	
	@Test
	public void isAnyNull_oneItemNull() {
		assertTrue(Utils.isAnyNull((Object)null));
	}
	
	@Test
	public void isAnyNull_oneItemObject() {
		assertFalse(Utils.isAnyNull(Boolean.FALSE));
	}
	
	@Test
	public void isAnyNull_multiItemOneNull() {
		assertTrue(Utils.isAnyNull(null, Boolean.TRUE));
		assertTrue(Utils.isAnyNull(new Integer(1), null));
	}
	
	@Test
	public void isAnyNull_multiItemNoNull() {
		assertFalse(Utils.isAnyNull(Boolean.FALSE, Boolean.TRUE));
	}
	
	@Test
	public void isAnyNull_multiItemMultiNull() {
		assertTrue(Utils.isAnyNull(Boolean.FALSE, null, Boolean.TRUE, null));
	}
	
	@Test
	public void isAnyNull_multiItemAllNull() {
		assertTrue(Utils.isAnyNull(null, null, null));
	}
	
	@Test
	public void elementsAreUnique_empty() {
		Integer[] testArray = {};
		List<Integer> testList = Arrays.asList(testArray);
		assertTrue(Utils.elementsAreUnique(testList));
	}
	
	@Test
	public void elementsAreUnique_oneElement() {
		Integer[] testArray = {1};
		List<Integer> testList = Arrays.asList(testArray);
		assertTrue(Utils.elementsAreUnique(testList));
	}
	
	@Test
	public void elementsAreUnique_oneDuplicate() {
		Integer[] testArray = {1, 1};
		List<Integer> testList = Arrays.asList(testArray);
		assertFalse(Utils.elementsAreUnique(testList));
	}
	
	@Test
	public void elementsAreUnique_manyElementSingleDuplicate() {
		Integer[] testArray = {1, 1, 1, 1, 1, 2, 3, 4, 5};
		List<Integer> testList = Arrays.asList(testArray);
		assertFalse(Utils.elementsAreUnique(testList));
	}
	
	@Test
	public void elementsAreUnique_manyElementMultipleDuplicate() {
		Integer[] testArray = {1, 1, 1, 1, 1, 2, 2, 2, 3, 4, 5};
		List<Integer> testList = Arrays.asList(testArray);
		assertFalse(Utils.elementsAreUnique(testList));
	}
	
	@Test
	public void elementsAreUnique_manyElementMultipleSingleDuplicate() {
		Integer[] testArray = {1, 1, 2, 2, 3, 4, 5};
		List<Integer> testList = Arrays.asList(testArray);
		assertFalse(Utils.elementsAreUnique(testList));
	}
}
