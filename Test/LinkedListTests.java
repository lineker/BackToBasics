package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import DataStructures.LinkedList;

public class LinkedListTests {

	private LinkedList<String> getSampleList() {
		LinkedList<String> list = new LinkedList<String>();
		list.add("item1");
		list.add("item2");
		list.add("item3");
		return list;
	}
	
	@Test
	public void testAdd() {
		LinkedList<String> list = new LinkedList<String>();
		list.add("item1");
		list.add("item2");
		assertEquals(list.length, 2);
		
		list.addToFront("item3");
		assertEquals(list.get(0), "item3");
		
		LinkedList<String> list2 = new LinkedList<String>();
		list2.add(null);
		assertEquals(0, list2.length);
	}
	
	@Test
	public void testGet() {
		LinkedList<String> list = getSampleList();
		assertEquals(list.get(0), "item1");
		assertEquals(list.getFirst(), "item1");
		assertEquals(list.get(list.length-1), "item3");
		assertEquals(list.getLast(), "item3");
		assertEquals(list.get(1), "item2");
		
		LinkedList<String> list2 = new LinkedList<String>();
		assertEquals(list2.get(1), null);
		assertEquals(list2.getFirst(), null);
		assertEquals(list2.getLast(), null);
	}
	
	@Test
	public void testRemove() {
		LinkedList<String> list = getSampleList();
		
		String r = list.remove("item1");
		assertTrue(r != null);
		assertEquals(list.length, 2);
		
		LinkedList<String> list2 = new LinkedList<String>();
		r = list2.remove("item1");
		assertTrue(r == null);
	}
	
	@Test
	public void testIterator() {
		LinkedList<String> list = getSampleList();
		for(String s : list) {
			System.out.println(s);
		}
		
		LinkedList<String> list2 = new LinkedList<String>();
		for(String s : list2) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testInsertAfter() {
		LinkedList<String> list = getSampleList();
		String s = list.insertAfter(null, "item4");
		assertTrue(s != null);
		assertEquals(list.getFirst(),"item4");
		
		s = list.insertAfter("item4", "item5");
		assertTrue(s != null);
		assertEquals(list.get(1), "item5");
		
		s = list.insertAfter("item3", "item6");
		assertTrue(s != null);
		assertEquals("item6", list.getLast());
		
		list = new LinkedList<String>();
		s = list.insertAfter(null, "item4");
		assertTrue(s != null);
		assertTrue(list.length == 1);
		
		list = new LinkedList<String>();
		s = list.insertAfter("item1", "item4");
		assertTrue(s == null);
		assertTrue(list.length == 0);
		
	}
	
	@Test
	public void testMToLast() {
		
		LinkedList<String> list = getSampleList();
		String s = list.getMtoLast(-1);
		assertEquals(null, s);
		s = list.getMtoLast(0);
		assertEquals("item3", s);
		s = list.getMtoLast(1);
		assertEquals("item2", s);
		s = list.getMtoLast(100);
		assertEquals(null, s);
		list = new LinkedList<String>();
		s = list.getMtoLast(1);
		assertEquals(null, s);
	}
}
