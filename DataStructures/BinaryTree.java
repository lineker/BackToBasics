package DataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.Box.Filler;

public class BinaryTree<T> {
	int height;
	private BinaryTreeNode<T> root;
	
	public BinaryTree() {}
	public BinaryTree(int key){
		insert(key);
	}
	
	public void insert(int key) {
		if(this.getRoot() == null) {
			this.setRoot(new BinaryTreeNode<T>(key));
			this.height++;
		} else {
			try {
				fillLevel(height, this.getRoot(), new BinaryTreeNode<T>(key));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<BinaryTreeNode<?>> toArray() {
		
		return BinaryTree.toArray(this.root, new ArrayList<BinaryTreeNode<?>>());
	}
	
	protected static ArrayList<BinaryTreeNode<?>> toArray(BinaryTreeNode<?> node, ArrayList<BinaryTreeNode<?>> array) {
		
		if(node != null) {
			BinaryTreeNode <?> newNode = node.clone();
			newNode.setLeft(null);
			newNode.setRight(null);
			array.add(newNode);
		}
		if(node.getLeft() != null) array = BinaryTree.toArray(node.getLeft(), array);
		if(node.getRight() != null) array = BinaryTree.toArray(node.getRight(), array);
		
		return array;
	}
	
	public static BinaryTree<?> heapfy(BinaryTree<?> tree, boolean minHeap) throws Exception {
		//TreeToArray
		ArrayList<BinaryTreeNode<?>> array = tree.toArray();
		
		//sort
		Collections.sort(array, new Comparator<BinaryTreeNode>() {
		    public int compare(BinaryTreeNode o1, BinaryTreeNode o2) {
		        return new Integer(o2.getKey()).compareTo(new Integer(o1.getKey()));
		    }
		});
		if(minHeap) Collections.reverse(array);
		int numLevels = array.size() / 2;
		BinaryTree newTree = null;
		if(array.size() > 0) {
			newTree = new BinaryTree(); //create new heap/tree and add root;
			newTree.setRoot(array.get(0));
		} 
		int currLevel = 1;
		int arrayIndex = 1;
		while(currLevel <= numLevels) {
			arrayIndex = newTree.fillLevel(currLevel, newTree.getRoot(), array, arrayIndex);
			currLevel++;
		}
		return newTree;
	}
	/**
	 * TODO: Don't use array to sort and build tree. Heapfication is done in place
	 * @param tree
	 * @param minHeap
	 * @return
	 * @throws Exception
	 */
	public static BinaryTree<?> heapfyInPlace(BinaryTree<?> tree, boolean minHeap) throws Exception {
		
		return null;
	}
	
	public void fillLevel(int level, BinaryTreeNode<T> root, BinaryTreeNode<T> item) throws Exception {
		 ArrayList<BinaryTreeNode<T>> array = new ArrayList<BinaryTreeNode<T>>();
		 array.add(item);
		 fillLevel(level, root, array, 0);
	}
	public int fillLevel(int level, BinaryTreeNode<T> root, ArrayList<BinaryTreeNode<T>> items, int arrayIndex) throws Exception {
		if(root == null) {
			if(level == 0 && items.size() > 0) this.setRoot(items.get(0));
			else throw new Exception("Can't added levels without root");
		}
		int currIndex = 0;
		BinaryTreeNode <T> node = root;
	
		while(currIndex < level-1 && node.getLeft() != null) {
			node = node.getLeft();
			currIndex++;
		}
		if(node == null) throw new Exception("trying to add children on NULL");
		arrayIndex = addChildren(node, items, arrayIndex);
		int levelfull = 0;
		if(node.getLeft() != null && node.getRight() != null) levelfull++;
		currIndex = 0;
		node = root;
	
		while(currIndex < level-1 && node.getRight() != null) {
			node = node.getRight();
			currIndex++;
		}
		if(node == null) throw new Exception("trying to add children on NULL");
		arrayIndex = addChildren(node, items, arrayIndex);
		if(node.getLeft() != null && node.getRight() != null) levelfull++;
		
		if(levelfull == 2){ //it means this level is full
			this.height++;
		}
		return arrayIndex;
	}
	public int addChildren(BinaryTreeNode<T> node, ArrayList<BinaryTreeNode<T>> items, int arrayIndex){
		if(node.getLeft() == null) {
			if(arrayIndex <= items.size()-1 && arrayIndex <= items.size()-1) {
				node.setLeft(items.get(arrayIndex));
				arrayIndex++;
			}
		}
		if(node.getRight() == null) {
			if(arrayIndex <= items.size()-1 && arrayIndex <= items.size()-1) {
				node.setRight(items.get(arrayIndex));
				arrayIndex++;
			}
		}
		return arrayIndex;
	}
	
	@Override
	public String toString() {
		return this.getRoot().toString();
	}
	
	BinaryTreeNode<T> getRoot() {
		return root;
	}
	void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}
}
