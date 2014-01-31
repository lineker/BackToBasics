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
		tree.insert(8);
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
		tree.insert(7);
		tree.insert(8);
		System.out.println(tree.toString());
		System.out.println("----");
		tree.remove(5);
		System.out.println(tree.toString());
		assertEquals(7, tree.getRoot().getKey());
	}
	
	@Test
	public void testCommonAncestor() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>(20);
		tree.insert(22);
		tree.insert(8);
		assertEquals(20, tree.MinCommonAncestor(8, 20).getKey());
		assertEquals(20, tree.MinCommonAncestor(22, 20).getKey());
		tree.insert(4);
		assertEquals(8, tree.MinCommonAncestor(12, 4).getKey());
		assertEquals(20, tree.MinCommonAncestor(4, 22).getKey());
		tree.insert(12);
		assertEquals(20, tree.MinCommonAncestor(12, 22).getKey());
		tree.insert(10);
		assertEquals(8, tree.MinCommonAncestor(10, 4).getKey());
		tree.insert(14);
		assertEquals(8, tree.MinCommonAncestor(4, 4).getKey());
		System.out.println(tree);
		assertEquals(8, tree.MinCommonAncestor(4, 12).getKey());
		
	}

}
