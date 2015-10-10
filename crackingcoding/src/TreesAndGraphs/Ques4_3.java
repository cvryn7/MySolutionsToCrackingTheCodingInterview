package TreesAndGraphs;

public class Ques4_3 {

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
		Ques4_3 q4 = new Ques4_3();
		Tree t = q4.new Tree();
		int[] ary = new int[10];
		for(int i = 0; i < 10; i++){
			ary[i] = i;
		}
		
		t.createMinBST(ary, 0, ary.length-1);
	}

}
