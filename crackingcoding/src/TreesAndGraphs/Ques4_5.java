package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;



public class Ques4_5 {
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
		
		boolean checkBST(){
			return checkBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
		}
		
		boolean checkBST(Node root, int min, int max){
			if(root == null) return true;
			
			if( root.data <= min || root.data > max) return false;
			
			if( !checkBST(root.left,min,root.data)|| !checkBST(root.right,root.data,max)){
				return false;
			}
			return true;
		}
	}

	class Node{
		Node left;
		Node right;
		Node parent;
		int data;

		Node(int data){
			this.data = data;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ques4_5 q4 = new Ques4_5();
		Tree t = q4.new Tree();
		int[] ary = new int[7];
		ary[0] = 1;
		ary[1] = 1;
		ary[2] = 2;
		ary[3] = 3;
		ary[4] = 5;
		ary[5] = 6;
		ary[6] = 7;
		
		t.createMinBST(ary, 0,ary.length-1);
		
		System.out.println(t.checkBST());
	}

}
