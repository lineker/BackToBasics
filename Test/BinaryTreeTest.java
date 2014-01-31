package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import DataStructures.BinaryTree;
import DataStructures.BinaryTreeNode;

public class BinaryTreeTest {
	
	@Test
	public void testInsert() {
		
		BinaryTree<String> tree = new BinaryTree<String>(9);
		tree.insert(10);
		tree.insert(7);
		tree.insert(8);
		tree.insert(15);
		tree.insert(14);
		
		//System.out.println(tree);
	}
	
	@Test
	public void testHeapfy() throws Exception {
		BinaryTree<String> tree = new BinaryTree<String>(9);
		tree.insert(10);
		tree.insert(7);
		tree.insert(8);
		tree.insert(15);
		tree.insert(14);

		System.out.println(tree);
		BinaryTree heap = BinaryTree.heapfy(tree, true);
		System.out.println(heap);
		
		
		tree = new BinaryTree<String>(9);
		tree.insert(10);
		tree.insert(7);

		System.out.println(tree);
		heap = BinaryTree.heapfy(tree, true);
		System.out.println(heap);
	}
}