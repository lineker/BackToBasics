package DataStructures;

/**
 * Implementation of a Stack using a single linked list.
 * @author Lineker Tomazeli
 *
 * @param <T>
 */
public class Stack<T> extends LinkedList<T>{
	
	/**
	 * returns the top object in the stack
	 * @return T
	 */
	public T peek() {
		return this.head.getData();
	}
	
	/**
	 * removes the top object from the stack
	 * @return T : the object removed
	 */
	public T pop() {
		return this.remove(this.getFirst());
	}
	
	/**
	 * add object to the top of the stack
	 * @param tData
	 */
	public void push(T tData) {
		this.addToFront(tData);
	}
}
