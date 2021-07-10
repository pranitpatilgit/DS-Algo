package com.pranit.binaryTrees;

/**
 *              5  
 *       2            7      
 *    1     3      6     8
 *            4            9
 */
public class BSTFromArray {

	private static int[] input = {1,2,3,4,5,6,7,8,9};
	
	public static void main(String[] args) {
		
		BinaryTree root = createTree(0, input.length-1);
		System.out.println("Root is - "+root.data);
		System.out.print("DFS is -");
		TreeTraversal.depthFirstSearch(root);
		System.out.println();
		System.out.print("BFS is -");
		TreeTraversal.breadthFirstSearch(root);
	}
	
	private static BinaryTree createTree(int start, int end){
		if(start > end) return null;
		
		int index = (start + end) / 2;
		System.out.println(input[index]);
		BinaryTree node = new BinaryTree(null, null, null, input[index]+"");
		node.left = createTree(start, index-1);
		node.right = createTree(index+1, end);
		
		return node;
	}

}
