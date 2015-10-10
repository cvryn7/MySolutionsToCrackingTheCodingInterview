package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Ques2_4 {

	class LinkedList<T> implements Iterable{

		Node<T> head = null;
		Node<T> current = null;
		
		LinkedList(){
			
		}
		
		void addData( T data){
			if( head == null){
				head = new Node<>(data);
			}else{
				Node<T> newNode = new Node<>(data);
				Node<T> runner = head;
				
				while( runner.next != null){
					runner = runner.next;
				}
				runner.next = newNode;
			}
		}
		
		
		@Override
		public Iterator<Node<T>> iterator() {
			// TODO Auto-generated method stub
			current = head;
			Iterator<Node<T>> itr = new Iterator<Node<T>>(){

				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return (current != null);
				}

				@Override
				public Node<T> next() {
					// TODO Auto-generated method stub
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
		Node<T> next;
		
		Node(T data){
			this.data = data;
		}
	}
	
	void partitionList( LinkedList<Integer> list, int x){
		LinkedList<Integer> beforeList = new LinkedList<>();
		LinkedList<Integer> afterList = new LinkedList<>();
		
		if( list.head == null){
			return;
		}
		
		Node<Integer> runner = list.head;
		Node<Integer> next = null;
		while( runner != null) {
			next = runner.next;
			if( runner.data <= x){
				if( beforeList.head == null){
					runner.next = null;
					beforeList.head = runner;
				}else{
					runner.next = beforeList.head;
					beforeList.head = runner;
				}
			}else{
				if( afterList.head == null){
					runner.next = null;
					afterList.head = runner;
				}else{
					runner.next = afterList.head;
					afterList.head = runner;
				}
			}
			runner = next;
		}
		if( beforeList.head == null){
			list.head = afterList.head;
			return;
		}
		
		runner = beforeList.head;
		
		while( runner.next != null){
			runner = runner.next;
		}
		runner.next = afterList.head;
		list.head = beforeList.head;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter list to partition");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] listAry = br.readLine().split(" ");
		
		Ques2_4 q4 = new Ques2_4();
		LinkedList<Integer> list = q4.new LinkedList<>();
		for( String s : listAry){
			list.addData(Integer.parseInt(s));
		}
		
		System.out.println("Enter number to partition around");
		int x = Integer.parseInt(br.readLine());
		
		q4.partitionList(list,x);
		
		Iterator<Node<Integer>> itr = list.iterator();
		
		while( itr.hasNext() ){
			System.out.print(itr.next().data + " ");
		}
	}

}
