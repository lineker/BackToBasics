package DataStructures;

public class BinaryTreeNode<T> implements Cloneable {
	private BinaryTreeNode<T> left = null;
	private BinaryTreeNode<T> right = null;
	private int key;
	private T data;
	
	public BinaryTreeNode(int tKey) {
		this.key = tKey;
	}
	
	public BinaryTreeNode(int tKey, BinaryTreeNode<T> tLeft, BinaryTreeNode<T> tRight){
		this.key = tKey;
		this.left = tLeft;
		this.right = tRight;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public BinaryTreeNode<T> getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
	public BinaryTreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}
	
	public String toString() {
		return toString(this, 0);
	}
	public String toString(BinaryTreeNode<T> current, int indentation) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < indentation; i++) { sb.append(" "); }
		sb.append(current.getKey());
		sb.append('\n');
		indentation++;
		if(current.getLeft() != null) sb.append(toString(current.getLeft(), indentation));
		if(current.getRight() != null) sb.append(toString(current.getRight(), indentation));
		return sb.toString();
	}
	
	@Override
	public BinaryTreeNode<?> clone() {
		BinaryTreeNode<T> newN = new BinaryTreeNode<T>(this.key,this.left, this.right);
		newN.setData(this.getData());
		return newN;
	}
}
