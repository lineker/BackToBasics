package DataStructures;

import java.util.Iterator;

/**
 * Single Linked list implementation. 
 * Notice that his implementation does not accepts null values as data since 
 * null values are reserved for error handling. Therefore, if a null is returned to you
 * after a function call, that means that operation wasn't completed successfully.
 * @author Lineker Tomazeli
 *
 * @param <T>
 */
public class LinkedList<T> implements Iterable<T> {

	protected ListNode<T> head = null;
	protected ListNode<T> tail = null;
	public int length = 0;
	
	public LinkedList() { }
	
	/**
	 * Adds object to the end of the list.
	 * Attention: This linkedlist does not accepts null values as tData.
	 * @param tData
	 */
	public void add(T tData) {
		if(tData != null) {
			if(head == null && tail == null) {
				tail = head = new ListNode<T>(tData);
			} else {
				ListNode<T> temp = tail;
				tail = new ListNode<T>(tData);
				temp.setNext(tail);
			}
			this.length++;
		}
	}
	
	/**
	 * add object to the front of the list. Object becomes the "head"
	 * @param tData
	 */
	public void addToFront(T tData) {
		if(head == null && tail == null) {
			tail = head = new ListNode<T>(tData);
		} else {
			ListNode<T> temp = head;
			head = new ListNode<T>(tData,temp);
		}
		this.length++;
	}
	
	public T insertAfter(T tData, T nData) {
		if(tData == null) { 
			this.addToFront(nData);
			return nData;
		}
		else {
			ListNode<T> current = head;
			while(current != null) {
				if(current.getData() == tData) {
					ListNode<T> newN = new ListNode<T>(nData);
					newN.setNext(current.getNext());
					current.setNext(newN);
					if(current == tail) tail = newN;
					return newN.getData();
				}
				current = current.getNext();
			}
		}
		return null;
	}
	
	/**
	 * Remove the first object found that matches the data.
	 * @param tData
	 * @return null if object is not found, otherwise returns the object removed.
	 */
	public T remove(T tData) {
		ListNode<T> current = head;
		ListNode<T> before = null;
		
		while(current != null) {
			if(current.getData() == tData) {
				if(current == head) {
					head = current.getNext();
					break;
				} else if(current == tail) {
					tail = before;
					before.setNext(null);
					break;
				} else if(current.getData() == tData) {
					before.setNext(current.getNext());
					break;
				}
			}
			before = current;
			current = current.getNext();
		}
		if(current != null) { 
			this.length--;
			return current.getData();
		}
		return null;
	}
	
	/**
	 * return the object at position i.
	 * @param i
	 * @return T if found, null is not found.
	 */
	public T get(int i){
		if(i == 0 && head != null) {
			return head.getData();
		} else if(i == this.length-1 && tail != null){
			return tail.getData();
		} else if(i <= this.length-1 && i >= 0) {
			ListNode<T> temp = head;
			int index = 0;
			while(temp != null) {
				if(i == index) {
					return temp.getData();
				}
				temp = temp.getNext();
				index++;
			}
		}
		return null;
	}
	
	/**
	 * Get First object (head) in the list
	 * @return T or null if list is empty
	 */
	public T getFirst() {
		return this.get(0);
	}
	
	/**
	 * Get last object (tail) in the list
	 * @return T or null if list is empty
	 */
	public T getLast() {
		return this.get(this.length-1);
	}
	
	/**
	 * Get object that is m positions before the last. Items are found in O(n)
	 * @param m
	 * @return T if found, otherwise null
	 */
	public T getMtoLast(int m){
		
		if(m < 0 || m > length-1) return null;
		return this.get(this.length-m-1);
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		ListNode<T> temp = head;
		while(temp != null) {
			sb.append(temp.getData().toString());
			sb.append('\n');
			temp = temp.getNext();
		}
		
		return sb.toString();
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> it = new Iterator<T>() {
			ListNode<T> temp = null;
			@Override
			public boolean hasNext() {
				if(head == null) return false;
				if(temp == null && head != null) return true;
				if(temp!= null) return (temp.getNext() != null);
				return false;
			}

			@Override
			public T next() {
				if(temp == null && head != null) {
					temp = head;
					return temp.getData();
				}
				if(temp != null) {
					temp = temp.getNext();
					return temp.getData();
				}
					return null;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub				
			}
		};
		return it;
	}
}