package com.ashu.utils.ds.Tree;

import java.util.ArrayList;

public class BinarySearchTree {
	
	private Node root;
	
	
	public boolean insert(int data) {
			return insert(root, data);
	}
	
	
	public boolean insert(Node node, int data) {
		
		if (node !=null ) {
			if (data == node.getData() ) {
					return false;
			} else 
			if( data > node.getData()){
				if (node.getRight() == null)
					node.setRight(new Node(data));
				else
					insert(node.getRight(), data);
			} else
			if (data < node.getData()) {
				if(node.getLeft() == null) 
					node.setLeft(new Node(data));
				else
					insert(node.getLeft(), data);
			}
			
		} else {
			root = new Node(data);
		}
		return true;
	}
	
	
	
	
	
	public Node delete(int data) {
		return null;
	}
	
	public String preOrderTraversal() {
		
		ArrayList<Integer> order = new ArrayList<Integer>();
		preOrderTraversal(root, order);
		
		return order.toString();
	}
	
	public void preOrderTraversal(Node tree, ArrayList list) {
		
		list.add(tree.getData());
		
		if ( tree.getLeft()!=null ) {
			preOrderTraversal(tree.getLeft(), list);
		}
		if (tree.getRight()!=null) {
			preOrderTraversal(tree.getRight(), list);
		}

	}
	
	
	public void postOrderTraversal(Node tree, ArrayList list) {
		
		
		if ( null != tree.getLeft()) {
			postOrderTraversal(tree.getLeft(), list );
		}
		if (null != tree.getRight() ) {
			postOrderTraversal(tree.getRight(), list);
		}
		list.add(tree.getData());
	}
	
	
	public Node display(int[] sequence) {
		
		root = new Node(sequence[0]);
		
		for ( int i = 0; i < sequence.length ; i++ ) {
			insert(sequence[i]);
		}
		return root;
	}
	
	
	
	
	
	public boolean compare ( BinarySearchTree bst )  {
		
		String t1 = this.preOrderTraversal();
		t1 = t1.substring(1, t1.length()-1);
		String t2 = bst.preOrderTraversal();
		t2 = t2.substring(1, t2.length()-1);
		if (t1.length() > t2.length()) {
			if (t1.contains(t2))
				return true;
		}
		return false;
	}
	
	
	private class Node {
		
		private int data;
		private Node left,right;
		
		Node(int data) {
			this.data = data;
			this.right = null;
			this.left = null;
		}
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		
		private boolean isLeaf() {
			if (null == left && null == right) {
				return true;
			} else {
				return false;
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		//insertion
	      Integer[] a = {11, 6, 8, 19, 4, 10, 5, 17, 43, 49, 31};
	      BinarySearchTree bst = new BinarySearchTree();
	      for(Integer n : a) 
	    	  bst.insert(n.intValue());
	      
	      
	    //traversal - preOrder
	      System.out.println("preOrder - " + bst.preOrderTraversal() ) ;
	      System.out.println();
	      
	      
	      //Comparision
	      BinarySearchTree t1 = new BinarySearchTree();
	      t1.insert(11);
	      t1.root.setLeft(t1.new Node(6));
	      t1.root.getLeft().setLeft(t1.new Node(4));
	      t1.root.getLeft().setRight(t1.new Node(8));
	      t1.root.getLeft().getRight().setRight(t1.new Node(10));
	      t1.root.getLeft().getLeft().setRight(t1.new Node(5));
	      t1.root.setRight(t1.new Node(19));
	      t1.root.getRight().setLeft(t1.new Node(17));
	      t1.root.getRight().setRight(t1.new Node(43));
	      t1.root.getRight().getRight().setLeft(t1.new Node(31));
	      t1.root.getRight().getRight().setRight(t1.new Node(49));
	      
	      System.out.println("preOrder - " + t1.preOrderTraversal() ) ;
	      
	      BinarySearchTree t2 = new BinarySearchTree();
	      t2.insert(19);
	      t2.root.setLeft(t2.new Node(17));
	      t2.root.setRight(t2.new Node(43));
	      t2.root.getRight().setLeft(t2.new Node(31));
	      t2.root.getRight().setRight(t2.new Node(49));
	      System.out.println("preOrder - " + t2.preOrderTraversal() ) ;
	      
	      
	      System.out.println("is t2 a sub-tree of bst ? " + t1.compare(t2));
/*
	      //testing comparator
	      //build a mirror BST with a rule:  Left > Parent > Right
	      //code for the comparator at the bottom of the file
	      bst = new BST<Integer>(new MyComp1());
	      for(Integer n : a) bst.insert(n);

	      bst.preOrderTraversal();
	      System.out.println();
	      bst.inOrderTraversal();
	      System.out.println();


	      for(Integer n : bst) System.out.print(n);
	      System.out.println();

	      System.out.println(bst);

	      //testing restoring a tree from two given traversals
	      bst.restore(new Integer[] {11,8,6,4,7,10,19,43,31,29,37,49},
	                      new Integer[] {4,6,7,8,10,11,19,29,31,37,43,49});
	      bst.preOrderTraversal();
	      System.out.println();
	      bst.inOrderTraversal();
	      System.out.println();

	      //testing diameter
	      System.out.println("diameter = " + bst.diameter());
	      //testing width
	      System.out.println("width = " + bst.width());
	     */
	      
	   }


}
