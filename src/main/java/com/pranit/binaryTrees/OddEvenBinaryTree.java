package com.pranit.binaryTrees;

public class OddEvenBinaryTree {
	
	public static Boolean isEven = false;
	public static String even = "";
	public static String odd = "";

	public static void main(String[] args) {
		
		BinaryTree root = createTree();
		
		traverseTree(root, isEven);
		
		System.out.println("Even = "+even);
		System.out.println("Odd = "+odd);
	}

	private static void traverseTree(BinaryTree node , Boolean isEven) {
		
		isEven = isEven ? false : true;
		
		if(node.left != null){
			traverseTree(node.left, isEven);
		}
		
		if (node.right != null) {
			traverseTree(node.right, isEven);
		}
		
		//System.out.print(node.data);
		
		if (isEven) {
			even = even + "," +node.data;
		}
		else{
			odd = odd + "," + node.data;
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
		
		BinaryTree root = new BinaryTree(one, two, null, "ROOT");
		
		return root;
	}

}
