package LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Iterator;

public class Ques2_6 {

	class LinkedList<T> implements Iterable {
		
		Node<T> head = null;
		Node<T> current = null;
		
		public void addData( T data){
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
		Node<T> next = null;
		
		Node(T data){
			this.data = data;
		}
	}
	
	public Node<Integer> findLoopNode( LinkedList<Integer> list){
		Node<Integer> slow = list.head;
		Node<Integer> fast = list.head;
		
		while( fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if( slow == fast){
				break;
			}
		}
		
		if( fast == null || fast.next == null){
			return null;
		}
		
		slow = list.head;
		
		while( slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
	public static void main(String[] args) throws IOException{
		System.out.println("Enter a linked list");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] listAry = br.readLine().split(" ");
		
		Ques2_6 q6 = new Ques2_6();
		LinkedList<Integer> list = q6.new LinkedList<Integer>();
		
		for( String s : listAry){
			list.addData(Integer.parseInt(s));
		}
		
		System.out.println("Enter the position where you want loop");
		
		int pos = Integer.parseInt(br.readLine());
		
		Node<Integer> runner = list.head;
		
		for( int i = 0; i < pos - 2 && runner != null; i++){
			runner = runner.next;
		}
		
		if( runner == null){
			System.out.println("Wrong position");
			return;
		}
		
		Node<Integer> loopNode = runner.next;
		
		while( runner.next != null){
			runner = runner.next;
		}
		runner.next = loopNode;
		
		Node<Integer> rsltLoopNode = q6.findLoopNode(list);
		
		if( rsltLoopNode != null){
			System.out.println("Loop node is : "+ rsltLoopNode.data);
		}
 	}
}
