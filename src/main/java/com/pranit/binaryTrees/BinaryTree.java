package com.pranit.binaryTrees;

public class BinaryTree {

	public BinaryTree left;
	public BinaryTree right;
	public BinaryTree parent;
	public String data;
	

	public BinaryTree(BinaryTree left, BinaryTree right, BinaryTree parent,
			String data) {
		super();
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.data = data;
	}
}
