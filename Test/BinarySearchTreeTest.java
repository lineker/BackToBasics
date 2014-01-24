package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import DataStructures.BinarySearchTree;
import DataStructures.BinaryTreeNode;

public class BinarySearchTreeTest {
	
	public BinaryTreeNode<String> getExampleTree() {
		BinarySearchTree<String> treeUtil = new BinarySearchTree<String>();
		BinaryTreeNode<String> root = new BinaryTreeNode<String>(5);
		treeUtil.insert(3, root);
		treeUtil.insert(4, root);
		treeUtil.insert(2, root);
		treeUtil.insert(7, root);
		treeUtil.insert(6, root);
		treeUtil.insert(8, root);
		
		return root;
	}
	
	@Test
	public void testInsert() {
		BinaryTreeNode<String> root = getExampleTree();
		System.out.println(root.toString());
	}
	
	@Test
	public void testRemove() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>(5);
		tree.insert(3);
		tree.insert(7);
		System.out.println(tree.toString());
		System.out.println("----");
		tree.remove(5);
		assertEquals(7, tree.getRoot().getKey());
		
		tree = new BinarySearchTree<String>(5);
		tree.insert(3);
		System.out.println(tree.toString());
		System.out.println("----");
		tree.remove(5);
		System.out.println(tree.toString());
		assertEquals(3, tree.getRoot().getKey());
		
		tree = new BinarySearchTree<String>(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		tree.insert(10);
		System.out.println("----");
		tree.remove(5);
		System.out.println(tree.toString());
		assertEquals(10, tree.getRoot().getKey());
		
		
	}

}
