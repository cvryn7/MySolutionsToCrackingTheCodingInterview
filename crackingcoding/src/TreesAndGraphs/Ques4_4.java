package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ques4_4 {

	class Tree{
		Node root;

		void createMinBST(int[] ary,int start, int end){
			root = createRecMinBst(ary, start, end);
		}

		Node createRecMinBst(int[] ary, int start, int end){
			if( end < start){
				return null;
			}
			
			int mid = (start+end)/2;
			Node newNode = new Node(ary[mid]);
			System.out.println(ary[mid] +" : added");
			newNode.left = createRecMinBst( ary, start, mid-1);
			newNode.right = createRecMinBst( ary, mid+1, end);
			return newNode;
		}
		
		
		void createLists(Node root, ArrayList<LinkedList<Integer>> aryList, int level){
			if( root == null){
				return;
			}
			
			LinkedList<Integer> newList = null;
			if( aryList.size() == level){
				newList = new LinkedList<Integer>();
				aryList.add(newList);
			}else{
				newList = aryList.get(level);
			}
			
			newList.add(root.data);
			createLists(root.left,aryList,level+1);
			createLists(root.right,aryList,level+1);
		}
	}

	class Node{
		Node left;
		Node right;
		int data;

		Node(int data){
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ques4_4 q4 = new Ques4_4();
		Tree t = q4.new Tree();
		int[] ary = new int[15];
		for(int i = 1; i < 16; i++){
			ary[i-1] = i;
		}
		
		t.createMinBST(ary, 0, ary.length-1);
		
		ArrayList<LinkedList<Integer>> aryList = new ArrayList<LinkedList<Integer>>();
		int level = 0;
		t.createLists(t.root, aryList, level);
		
		for( int i = 0; i < aryList.size(); i++){
			for( int j : aryList.get(i)){
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
	}

}
