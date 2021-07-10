package com.pranit.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

	/*
	 * 
	 *            0
     *		1         2
     *    3   4     5    6
     *  7   8      9  10
	 * 
	 *  
	 * 
	 * */
	
	public static void main(String[] args) {
		BinaryTree root = createTree();
		
		System.out.println("Printing DFS...");
		depthFirstSearch(root);
		
		System.out.println("\nPrinting BFS...");
		breadthFirstSearch(root);
		
		System.out.println("\nPrinting ZigZag...");
		printZigZag(root);
	}

	private static void printZigZag(BinaryTree root) {
		Stack<BinaryTree> right = new Stack();
		Stack<BinaryTree> left = new Stack();
		
		right.push(root);
		
		while(!right.isEmpty() || !left.isEmpty()){
			
			while(!right.isEmpty()){
				BinaryTree temp = right.pop();
				System.out.print(temp.data + " ");
				if(temp.right != null) left.push(temp.right);
				if(temp.left != null) left.push(temp.left);
			}
			
			while(!left.isEmpty()){
				BinaryTree temp = left.pop();
				System.out.print(temp.data + " ");
				if(temp.left != null) right.push(temp.left);
				if(temp.right != null) right.push(temp.right);
			}
		}
	}

	/**
	 * Implementing inorder traversal
	 */
	public static void depthFirstSearch(BinaryTree node){
		if(node.left != null)
			depthFirstSearch(node.left);
		System.out.print(node.data + " ");
		if(node.right != null)
			depthFirstSearch(node.right);
	}
	
	public static void breadthFirstSearch(BinaryTree node){
		Queue<BinaryTree> queue = new LinkedList();
		queue.add(node);
		while(!queue.isEmpty()){
			BinaryTree temp = queue.poll();
			System.out.print(temp.data + " ");
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
		}
		
	}
	
	private static BinaryTree createTree() {

		BinaryTree ten = new BinaryTree(null, null, null, "10");
		BinaryTree nine = new BinaryTree(null, null, null, "9");
		BinaryTree eight = new BinaryTree(null, null, null, "8");
		BinaryTree seven = new BinaryTree(null, null, null, "7");
		BinaryTree six = new BinaryTree(null, null, null, "6");
		BinaryTree five = new BinaryTree(nine, ten, null, "5");
		BinaryTree four = new BinaryTree(null, null, null, "4");
		BinaryTree three = new BinaryTree(seven, eight, null, "3");
		BinaryTree two = new BinaryTree(five, six, null, "2");
		BinaryTree one = new BinaryTree(three, four, null, "1");

		BinaryTree root = new BinaryTree(one, two, null, "0");

		return root;
	}

}
