package LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;


public class Ques2_7 {

	class LinkedList<T> implements Iterable{
		Node<T> head;
		Node<T> current;

		public void addData(T data){
			if( head == null){
				head = new Node<T>(data);
			}else{
				Node<T> runner = head;
				while( runner.next != null){
					runner = runner.next;
				}
				runner.next = new Node<T>(data);
			}
		}

		public Iterator<Node<T>> iterator(){
			current = head;
			Iterator<Node<T>> itr = new Iterator<Node<T>>(){
				public boolean hasNext(){
					return (current != null);
				}

				public Node<T> next(){
					Node<T> c = current;
					current = current.next;
					return c;
				}
			};
			return itr;
		}
	}

	class Node<T>{
		T data;
		Node<T> next =null;
		Node(T data){
			this.data = data;
		}
	}

	class NodePass{
		Node<Integer> node;
		boolean notPalin = false;
	}
	
	public boolean findPalinStack(LinkedList<Integer> list){
		boolean rslt = true;
		Node<Integer> fast = list.head;
		Node<Integer> slow = list.head;
		Stack<Integer> stack = new Stack<Integer>();
		
		
		while( fast != null && fast.next != null){
			stack.push(slow.data);
			fast = fast.next.next;
			slow = slow.next;
			
		}
		
		if( fast != null){
			slow = slow.next;
		}
		
		while( slow != null){
			int top = stack.pop().intValue();
			if( top != slow.data.intValue()){
				rslt = false;
				break;
			}
			slow = slow.next;
		}
		return rslt;
	}
	
	public void findPalinRecurse(Node<Integer> node, int len, NodePass np){
		if( len == 0){
			np.node = node;
			return;
		}else if( len == 1){
			np.node = node.next;
			return;
		}
		
		findPalinRecurse(node.next,len-2,np);
		if(np.notPalin){
			return;
		}
		if( node.data != np.node.data){
			np.notPalin = true;
		}
		np.node = np.node.next;
	}
	
	public static void main(String[] args) throws IOException{
		System.out.println("Enter linked list to check palindrome");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] listAry = br.readLine().split(" ");

		Ques2_7 q7 = new Ques2_7();
		LinkedList<Integer> list = q7.new LinkedList<Integer>();

		for( String s : listAry){
			list.addData(Integer.parseInt(s));
		}

		System.out.println("Enter 1 to find palindrome using stack");
		System.out.println("Enter 2 to find palindrome using recursion");
		int opt = Integer.parseInt(br.readLine());

		boolean rslt = false;
		
		switch(opt){
		case 1:
			rslt = q7.findPalinStack(list);
			break;
		case 2:
			NodePass np = q7.new NodePass();
			
			int length = 0;
			Node<Integer> runner = list.head;
			while( runner != null){
				runner = runner.next;
				length++;
			}
			Node<Integer> headNode = list.head;
			q7.findPalinRecurse(headNode,length,np);
			
 			rslt = np.notPalin?false:true;
 			System.out.println(np.notPalin);
			break;
		}
		
		System.out.println("Is List palindrome ? : "+rslt);
	}

}
