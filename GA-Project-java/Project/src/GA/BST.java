package GA;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
	
	private Node root;
	
	private class Node{
		private double dou;
		private int[] in;
		private Node left,right;
		public int count ;
		
		public Node(double dou, int[] in,int count) {
			this.dou = dou;
			this.in = in;
			this.count = count;
		}	
	}
	
	public int[] get(double dou) {
		Node x = root;
		while(x!=null) {
			int cmp = compare(dou,x.dou);
			if		(cmp < 0) x = x.left;
			else if	(cmp > 0) x = x.right;
			else		return x.in;
		}
		return null;
	}
	
	public void put(double dou,int[] in) {
		root = put(root,dou,in);
	}
	
	private Node put(Node x, double dou,int[] in) {
		if(x == null) return new Node(dou,in,1);
		int cmp = compare(dou,x.dou);
		if(cmp<0)
			x.left = put(x.left,dou,in);
		else if(cmp>0)
			x.right = put(x.right,dou,in);
		else
			x.in = in;
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

	public Iterable<int[]> ints(){
		Queue<int[]> q = new LinkedList<int[]>();
		inorder(root,q);
		return q;
	}

	private void inorder(Node x, Queue<int[]> q) {
		if(x == null) return;
		inorder(x.left,q);
		q.add(x.in);
		inorder(x.right,q);
		
	}

	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x) {
		if(x.left ==null) return x.right;
		x.left = deleteMin(x.left);
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if(x==null) return 0;
		return x.count;
	}

	private int compare(double douf,double dous) {
		if(douf>dous)	return 1;
		else if(douf<dous)	return -1;
		else return 0;
	}

}

//package GA;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class BST {
//	
//	private Node root;
//	
//	private class Node{
//		private double dou;
//		private IndividualUnit ind;
//		private Node left,right;
//		
//		public Node(double dou, IndividualUnit ind) {
//			this.dou = dou;
//			this.ind = ind;
//		}	
//	}
//	
//	public IndividualUnit get(double dou) {
//		Node x = root;
//		while(x!=null) {
//			int cmp = compare(dou,x.dou);
//			if		(cmp < 0) x = x.left;
//			else if	(cmp > 0) x = x.right;
//			else		return x.ind;
//		}
//		return null;
//	}
//	
//	public void put(double dou,IndividualUnit ind) {
//		root = put(root,dou,ind);
//	}
//	
//	private Node put(Node x, double dou,IndividualUnit ind) {
//		if(x == null) return new Node(dou,ind);
//		int cmp = compare(dou,x.dou);
//		if(cmp<0)
//			x.left = put(x.left,dou,ind);
//		else if(cmp>0)
//			x.right = put(x.right,dou,ind);
//		else
//			x.ind = ind;
//		return x;
//	}
//
//	public Queue<int[]> ints(){
//		Queue<int[]> q = new LinkedList<int[]>();
//		inorder(root,q);
//		return q;
//	}
//
//	private void inorder(Node x, Queue<int[]> q) {
//		if(x == null) return;
//		inorder(x.left,q);
//		q.add(x.in);
//		inorder(x.right,q);
//		
//	}
//
//	public void deleteMin() {
//		root = deleteMin(root);
//	}
//	
//	private Node deleteMin(Node x) {
//		if(x.left ==null) return x.right;
//		x.left = deleteMin(x.left);
//		return x;
//	}
//	
//	private int compare(double douf,double dous) {
//		if(douf>dous)	return 1;
//		else if(douf<dous)	return -1;
//		else return 0;
//	}
//
//}
