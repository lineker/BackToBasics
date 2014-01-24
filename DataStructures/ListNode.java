package DataStructures;

/**
 * The linked list is built from Nodes where each node has 
 * a "data" property and a reference to the next Node.
 * @author Lineker Tomazeli
 *
 * @param <T>
 */
public class ListNode<T> {
	private T data = null;
	private ListNode<T> next = null;
	
	public ListNode(T tData) {
		this.data = tData;
	}
	
	public ListNode(T tData, ListNode<T> tNext){
		this.data = tData;
		this.next = tNext;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T tData) {
		this.data = tData;
	}
	
	public ListNode<T> getNext() {
		return this.next;
	}
	
	public void setNext(ListNode<T> tNext) {
		this.next = tNext;
	}
}
