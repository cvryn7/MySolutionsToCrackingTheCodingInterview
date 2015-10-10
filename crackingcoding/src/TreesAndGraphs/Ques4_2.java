package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ques4_2{

	public enum State{
		notVisited, visiting, visited
	}

	class Graph{
		ArrayList<Node> nodeList = new ArrayList<Node>();

		void addNode(Node node){
			nodeList.add(node);
		}


		boolean findPath(Node start, Node end){
			LinkedList<Node> q = new LinkedList<Node>();

			for( Node n : nodeList){
				n.state = State.notVisited;
			}

			start.state = State.visiting;
			Node temp;
			q.addLast(start);

			while( !q.isEmpty()){
				temp = q.removeFirst();
				if( temp != null){
					if( temp == end){
						return true;

					}
					else{
						for( Node n : temp.adjacent){
							if( n.state == State.notVisited){
								n.state = State.visiting;
								q.addLast(n);
							}
						}
					}
				}
				temp.state = State.visited;
			}
			return false;
		}
	}

	class Node{
		int data;
		ArrayList<Node> adjacent = new ArrayList<Node>();
		State state = null;
		
		Node(int data){
			this.data = data;
		}
		void addAdjacent(Node node){
			adjacent.add(node);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ques4_2 q4 = new Ques4_2();
		Graph g = q4.new Graph();
			
		Node n1 = q4.new Node(1);
		Node n2 = q4.new Node(2);
		Node n3 = q4.new Node(3);
		Node n4 = q4.new Node(4);
		Node n5 = q4.new Node(5);
		
		n1.addAdjacent(n2);
		n1.addAdjacent(n3);
		n2.addAdjacent(n3);
		n2.addAdjacent(n4);
		n5.addAdjacent(n4);
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		
		System.out.println(g.findPath(n2,n4));
		
	}

}
