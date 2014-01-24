package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import DataStructures.Stack;

public class StackTests {

	@Test
	public void testPush() {
		Stack<String> stack = new Stack<String>();
		stack.push("item1");
		stack.push("item2");
		assertEquals(stack.length, 2);
	}
	
	@Test
	public void testPop() {
		Stack<String> stack = new Stack<String>();
		stack.push("item1");
		stack.push("item2");
		stack.push("item3");
		stack.push("item4");
		stack.push("item5");
		assertEquals(stack.pop(), "item5");
		assertEquals(stack.length, 4);
	}
	
	@Test
	public void testPeek() {
		Stack<String> stack = new Stack<String>();
		stack.push("item1");
		stack.push("item2");
		assertEquals(stack.peek(), "item2");
		assertEquals(stack.length, 2);
	}

}
