
package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


public class Ques4_8 {
	
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
		
		Node findCommonAncester(Node p, Node q){
			Result r = findCommonAncester(root,p,q);
			if( r.isAncester == false) return null;
			else return r.root;
		}
		
		Result findCommonAncester(Node curnt, Node p, Node q){
			if( curnt == null) return new Result(null,false);
			if( curnt == p && curnt == q) return new Result(curnt,false);
			
			Result rLeft = findCommonAncester(curnt.left,p,q);
			if( rLeft.isAncester) return rLeft;
			
			Result rRight = findCommonAncester(curnt.right,p,q);
			if( rRight.isAncester) return rRight;
			
			
			if(rLeft.root != null && rRight.root != null )
				return new Result(curnt,true);
			else if( curnt == p || curnt == q){
				if( rLeft.root != null || rRight.root != null){
					return new Result(curnt,true);
				}else{
					return new Result(curnt,false);
				}
			}else{
				return rLeft.root != null?rLeft:rRight;
			}
		}
		
		
		boolean contains(Tree t){
			if( t.root == null) return false;
			return subtree(root, t.root);
		}
		
		boolean subtree(Node r1, Node r2){
			if( r1 == null) return false;
			if( r1.data == r2.data){
				return match(r1.left,r2.left) && match(r1.right,r2.right);
			}
			
			return subtree(r1.left,r2) || subtree(r1.right,r2);
		}
		
		boolean match(Node r1, Node r2){
			if( r1 == null && r2 == null ) return true;
			if( r1 == null || r2 == null ) return false;
			if( r1.data != r2.data) return false;
			return match(r1.left,r2.left) && match(r1.right,r2.right);
		}
	}

	class Result{
		Node root;
		boolean isAncester;
		
		Result(Node root, boolean isAncester){
			this.root = root;
			this.isAncester = isAncester;
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
		Ques4_8 q8 = new Ques4_8();
		Tree t = q8.new Tree();
		Tree t1 = q8.new Tree();
		
		int[] ary = new int[11];
		ary[0] = 0;
		ary[1] = 1;
		ary[2] = 2;
		ary[3] = 3;
		ary[4] = 4;
		ary[5] = 5;
		ary[6] = 6;
		ary[7] = 7;
		ary[8] = 8;
		ary[9] = 9;
		ary[10] = 11;
		
		int[] ary1 = new int[5];
		ary1[0] = 6;
		ary1[1] = 7;
		ary1[2] = 8;
		ary1[3] = 9;
		ary1[4] = 11;
		t.createMinBST(ary, 0,ary.length-1);
		t1.createMinBST(ary1, 0, ary1.length-1);
		
		ArrayList<LinkedList<Integer>> aryList = new ArrayList<LinkedList<Integer>>();
		int level = 0;
		t.createLists(t.root, aryList, level);
		
		for( int i = 0; i < aryList.size(); i++){
			for( int j : aryList.get(i)){
				System.out.print(j+" ");
			}
			System.out.println();
		}	
		System.out.println(t.contains(t1));
	}

}
