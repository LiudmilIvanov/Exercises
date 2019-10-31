package DataStructures;

import java.util.LinkedList;

//Graph representation - Adjacency list
public class GraphRepresentation {

	int vertex;
	LinkedList<Integer> list[];

	public GraphRepresentation(int vertex) {
		this.vertex = vertex;
		list = new LinkedList[vertex];
		for (int i = 0; i < vertex; i++) {
			list[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int source, int destination) {
		list[source].addFirst(destination);
		// for undirected graph only
		list[destination].addFirst(source);
	}

	public void printGraph() {
		for (int i = 0; i < vertex; i++) {
			if (list[i].size() > 0) {
				System.out.println("Vertext " + i + " is connected to:");
				for (int j = 0; j < list[i].size(); j++) {
					System.out.println(list[i].get(j));
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		GraphRepresentation graph = new GraphRepresentation(4);
		graph.addEdge(1, 3);
		graph.addEdge(3, 1);
		graph.addEdge(1, 7);
		graph.addEdge(3, 5);
		graph.addEdge(3, 7);
		graph.addEdge(7, 3);
		graph.printGraph();
	}
}
