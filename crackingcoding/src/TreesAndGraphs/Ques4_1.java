package TreesAndGraphs;

public class Ques4_1 {

	class Tree{
		Node root = null;
		
		void addNode(int data){
			Node newNode = new Node(data);
			Node ref = root;
			if( ref == null){
				root = newNode;
			}else{
				while(true){
					if( newNode.data > ref.data){
						if(ref.right == null){
							ref.right = newNode;
							break;
						}else{
							ref = ref.right;
						}
					}else{
						if(ref.left == null){
							ref.left= newNode;
							break;
						}else{
							ref = ref.left;
						}
					}
				}
			}
			
			
		}
		
		private int checkBalance(Node root){
			if( root == null){
				return 0;
			}
			int leftHeight = checkBalance(root.left);
			if( leftHeight == -1){
				return -1;
			}
			
			int rightHeight = checkBalance(root.right);
			if( rightHeight == -1){
				return -1;
			}
			
			if( Math.abs( leftHeight - rightHeight) > 1 ){
				return -1;
			}else{
				return leftHeight>rightHeight?leftHeight+1:rightHeight+1;
			}
		}
		
		boolean isBalanced(){
			
			int balanceValue = checkBalance(root);
			if( balanceValue == -1 ){
				return false;
			}else{
				return true;
			}			
		}
		
		
	}
	
	
	class Node{
		Node right;
		Node left;
		int data;
		
		Node(int data){
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ques4_1 q4 = new Ques4_1();
		Tree t = q4.new Tree();
		t.addNode(5);
		t.addNode(2);
		
		t.addNode(1);
		t.addNode(3);
		t.addNode(6);
		//t.addNode(7);
		t.addNode(8);
		
		System.out.println(t.isBalanced());
	}

}
