package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


public class Ques4_6 {
	
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

		void connectToParent(){
			connectToParent(root,null);
		}

		void connectToParent(Node root, Node parent){
			if( root == null ){
				return;
			}
			root.parent = parent;
			connectToParent(root.left,root);
			connectToParent(root.right,root);
		}
		
		Node searchBST(int n){
			Node runner = root;
			if( n == runner.data) return root;
			while(runner != null){
				if( n < runner.data){
					if( n == runner.left.data) return runner.left;
					runner = runner.left;
				}else{
					if( n == runner.right.data) return runner.right;
					runner = runner.right;
				}
			}
			return null;
		}

		Node findRandom(int min, int max){
			int n = generateRandomNumber(min,max);
			
			return searchBST(n);
		}

		int generateRandomNumber(int min, int max){
			Random r = new Random();
			if( min > max ) throw new IllegalArgumentException();

			int range = max - min;

			return min + (int)(range * r.nextDouble());
		}
		
		Node findInOrderSuccesor(Node curntNode){
			if( curntNode == null) return null;
			
			if( curntNode.right != null){
				return leftMostChild(curntNode.right);
			}
			
			Node q = curntNode;
			Node x = curntNode.parent;
			
			while( x != null && q != x.left){
				q = x;
				x = x.parent;
			}
			
			return x;
		}
		
		
		Node leftMostChild(Node curntNode){
			if( curntNode == null) return null;
			
			while( curntNode.left != null){
				curntNode = curntNode.left;
			}
			
			return curntNode;
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
		Ques4_6 q4 = new Ques4_6();
		Tree t = q4.new Tree();
		int[] ary = new int[7];
		ary[0] = 0;
		ary[1] = 1;
		ary[2] = 2;
		ary[3] = 3;
		ary[4] = 4;
		ary[5] = 5;
		ary[6] = 6;

		t.createMinBST(ary, 0,ary.length-1);
		
		ArrayList<LinkedList<Integer>> aryList = new ArrayList<LinkedList<Integer>>();
		int level = 0;
		t.createLists(t.root, aryList, level);
		
		for( int i = 0; i < aryList.size(); i++){
			for( int j : aryList.get(i)){
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		
		t.connectToParent();
		Node currentNode = t.findRandom(0,6);
		System.out.println(currentNode.data);
		System.out.println(t.checkBST());
		System.out.println(t.findInOrderSuccesor(currentNode).data);
	}

}
