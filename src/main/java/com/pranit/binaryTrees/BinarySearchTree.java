package com.pranit.binaryTrees;


/*
 *            9  
 *       6         15      
 *    4     7   12    18
 *   2 5     8
 * 
 */
public class BinarySearchTree {

	BSTNode root;
	BSTNode closest;
	int diff;
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.createData();
		bst.inOrder(bst.root);
		System.out.println();
		
		bst.diff = Integer.MAX_VALUE;
		bst.closest = bst.root;
		bst.findClosest(bst.root, 3);
		System.out.println(bst.closest.data);
		
		bst.diff = Integer.MAX_VALUE;
		bst.closest = bst.root;
		bst.findClosest(bst.root, 13);
		System.out.println(bst.closest.data);
		
		System.out.println("Min in this BST is - " + bst.findMin(bst.root).data);
		
		bst.delete(bst.root, 6);
		bst.inOrder(bst.root);
	}
	
	public void createData(){
		insert(9);
		insert(5);
		insert(15);
		insert(4);
		insert(7);
		insert(12);
		insert(18);
		insert(2);
		insert(6);
		insert(8);
	}
	
	public void findClosest(BSTNode node, int data){
		if (node == null)
			return;
		
		int difference = Math.abs(data - node.data);
		if(difference < diff){
			diff = difference;
			closest = node;
		}
		
		if(data > node.data)
			findClosest(node.right, data);
		else if(data < node.data)
			findClosest(node.left, data);
		else
			return;
	}
	
	public BSTNode insert(int data){
		if (root == null) {
			root = new BSTNode(null, data, null);
			return root;
		}
		
		return insert(root, data);
	}
	
	private BSTNode insert(BSTNode parent, int data){
		if (parent ==  null) {
			return new BSTNode(null, data, null);
		}else if (parent.data > data) {
			parent.left = insert(parent.left, data);
		}else if (parent.data < data){
			parent.right = insert(parent.right, data);
		}
		
		return parent;
	}
	
	public void inOrder(BSTNode node){
		if(node.left != null)
			inOrder(node.left);
		System.out.print(node.data +" ");
		if (node.right != null)
			inOrder(node.right);
	}
	
	public BSTNode delete(BSTNode node, int key) {
		if (node == null) return null;
		
		if(key < node.data)
			node.left = delete(node.left, key);
		else if(key > node.data)
			node.right = delete(node.right, key);
		else{
			if(node.right == null) return node.left;
			if(node.left == null) return node.right;
			
			BSTNode min = findMin(node.right);
			int tempData = min.data;
			delete(node.right, tempData);
			node.data = tempData;
		}
		
		return node;
	}
	
	public BSTNode findMin(BSTNode node){
		if(node == null) 
			return null;
		
		if(node.left == null) return node;
		
		return findMin(node.left);
	}

}

class BSTNode{
	int data;
	BSTNode left;
	BSTNode right;
	
	public BSTNode(BSTNode left, int data, BSTNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
}
