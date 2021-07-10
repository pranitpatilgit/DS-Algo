package com.pranit.binaryTrees;

public class RBTree {

	public int data;
	public RBTree left;
	public RBTree right;
	public boolean color = false;

	public static boolean RED = true;
	public static boolean BLACK = false;

	public RBTree(int data, RBTree left, RBTree right, boolean color) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.color = color;
	}
	
	public static void main(String[] args) {
		RBTree root = createTree();
		System.out.println("Inorder is - ");
		inOrder(root);
	}

	private static RBTree createTree() {
		RBTree root = null;
		root = insert(root, 1);
		root = insert(root, 15);
		root = insert(root, 5);
		root = insert(root, 6);
		root = insert(root, 90);
		root = insert(root, 4);
		root = insert(root, 18);
		root = insert(root, 20);
		root = insert(root, 3);
		
		return root;
	}

	public static RBTree rotateRight(RBTree node) {
		
		RBTree temp = node.left;
		node.left = temp.right;
		temp.right = node;
		temp.color = node.color;
		node.color = RED;
		
		return temp;
	}

	public static RBTree rotateLeft(RBTree node) {
		
		RBTree temp = node.right;
		node.right = temp.left;
		temp.left = node;
		temp.color = node.color;
		node.color = RED;
		return temp;
	}
	
	public static RBTree flipColors(RBTree node) {
		node.left.color = BLACK;
		node.right.color = BLACK;
		node.color = RED;
		
		return node;
	}
	
	public static RBTree insert(RBTree node, int data){
		if(node == null) return new RBTree(data, null, null, RED);
		
		if(data < node.data) node.left = insert(node.left, data);
		else if(data > node.data) node.right = insert(node.right, data);
		
		if(!isRed(node.left) && isRed(node.right))
			node = rotateLeft(node);
		if(isRed(node.left) && isRed(node.left.left))
			node = rotateRight(node);
		if(isRed(node.left) && isRed(node.right))
			flipColors(node);
		
		return node;
	}
	
	public static void inOrder(RBTree node){
		if(node.left != null)
			inOrder(node.left);
		System.out.print(node.data +" ");
		if (node.right != null)
			inOrder(node.right);
	}
	
	public static boolean isRed(RBTree node){
		if(node == null)
			return BLACK;
		else 
			return node.color;
	}
}
