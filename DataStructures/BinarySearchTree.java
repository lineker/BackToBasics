package DataStructures;

public class BinarySearchTree<T> {
	
	private BinaryTreeNode<T> root;
	
	public BinarySearchTree() { }
	public BinarySearchTree(BinaryTreeNode<T> tRoot) {
		this.setRoot(tRoot);
	}
	public BinarySearchTree(int key) {
		
		this.setRoot(new BinaryTreeNode<T>(key));
	}
	
	public void insert(BinaryTreeNode<T> tnode) { insert(tnode, this.root); }
	public void insert(int key) { insert(key, this.root); }
	public void insert(int key, BinaryTreeNode<T> root) {
		BinaryTreeNode<T> node = new BinaryTreeNode<T>(key);
		insert(node, root);
	}
	//Add Node using recursion
	public void insert(BinaryTreeNode<T> tnode, BinaryTreeNode<T> root) {
		if(root != null) {
			if(tnode.getKey() <= root.getKey()){
				if(root.getLeft() == null) root.setLeft(tnode);
				else insert(tnode, root.getLeft());
			} else if(tnode.getKey() >= root.getKey()) {
				if(root.getRight() == null) root.setRight(tnode);
				else insert(tnode, root.getRight());
			} 
		}
	}
	
	protected boolean isLeaf( BinaryTreeNode<T> node) {
		if(node != null) {
			return (node.getRight() == null && node.getLeft() == null);
		}
		return false;
	}
	
	protected BinaryTreeNode<T> findBestFit(BinaryTreeNode<T> node) {
		if(node == null) return null;
		if(node.getRight() != null) {
			
			if(isLeaf(node.getRight())) {
				BinaryTreeNode<T> retVal = node.getRight();
				node.setRight(null);
				return retVal;
			}
			
			node = node.getRight();
			while(node.getLeft() != null) {
				if(isLeaf(node.getLeft())) {
					BinaryTreeNode<T> retVal = node.getLeft();
					node.setLeft(null);
					return retVal;
				}
			}
			return findBestFit(node);
		}
		if(node.getLeft() != null) {
			if(isLeaf(node.getLeft())) {
				BinaryTreeNode<T> retVal = node.getLeft();
				node.setLeft(null);
				return retVal;
			}
					
			return findBestFit(node.getLeft());
		}
		return null;
	}
	
	//Remove Node
	public BinaryTreeNode<T> remove(int key){ return remove(key, this.root, null); }
	public BinaryTreeNode<T> remove(int key, BinaryTreeNode<T> node, BinaryTreeNode<T> parent){
		BinaryTreeNode<T> retVal = null;
		
		if(node == this.root && key == node.getKey()) { //root case
			BinaryTreeNode<T> replacement = findBestFit(node);
			replacement.setLeft(node.getLeft());
			replacement.setRight(node.getRight());
			retVal = node;
			this.root = replacement;
			return retVal;
		}
		
		if(node.getLeft().getKey() == key) {
			BinaryTreeNode<T> replacement = findBestFit(node);
			replacement.setLeft(node.getLeft().getLeft());
			replacement.setRight(node.getLeft().getRight());
			retVal =  node.getLeft();
			node.setLeft(replacement);
			return retVal;
		}
		
		if(node.getRight().getKey() == key) {
			BinaryTreeNode<T> replacement = findBestFit(node);
			replacement.setLeft(node.getRight().getLeft());
			replacement.setRight(node.getRight().getRight());
			retVal = root.getRight();
			node.setRight(replacement);
			return retVal;
		}
		return null;
	}
	
	public BinaryTreeNode<T> MinCommonAncestor(int key1, int key2) {
		
		return MinCommonAncestor(key1, key2, this.root);
	}
	
	/**
	 * Assumes key1 and key2 exist in the tree
	 * @param key1
	 * @param key2
	 * @param node
	 * @return
	 */
	public BinaryTreeNode<T> MinCommonAncestor(int key1, int key2, BinaryTreeNode<T> node) {
		if(node != null)  {
			if(key1 < node.getKey() && key2 < node.getKey()) {
				if(key1 == key2 && node.getLeft().getKey() == key1) return node;
				return MinCommonAncestor(key1, key2, node.getLeft());
			} else if(key1 > node.getKey() && key2 > node.getKey()) {
				if(key1 == key2 && node.getRight().getKey() == key1) return node;
				return MinCommonAncestor(key1, key2, node.getRight());
			} else if((key1 <= node.getKey() && key2 >= node.getKey()) || 
					  (key1 >=node.getKey() && key2 <= node.getKey())){
				return node;
			}
		}
		return null;
	}
	
	public BinaryTreeNode<T> getRoot() {
		return root;
	}
	
	
	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}
	
	@Override
	public String toString() {
		return this.root.toString();
	}
	
	//Find Node
	
}
