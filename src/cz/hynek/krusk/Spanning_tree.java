package cz.hynek.krusk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Vector;

public class Spanning_tree{
	private Graph graf;
	private int cost=0;
	private PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
	private Vector<Edge> stEdges = new Vector<Edge>();
	private HashMap<Vertex,Integer> sets = new HashMap<Vertex, Integer>();
	
	public Spanning_tree(Graph graf) {
		super();
		this.graf = graf;
		getEdgesFromGraph();
	}
	
	public PriorityQueue<Edge> getEdges() {
		return edges;
	}
	public Vector<Edge> getstEdges() {
		return stEdges;
	}
	public void getEdgesFromGraph() {
		Vertex tmp;
		for (Map.Entry<String, Vertex> set : graf.getMap().entrySet()) {
			tmp=set.getValue();
			for (Map.Entry<Vertex, Integer> nextVertex : tmp.getCosts().entrySet()) {
				if(!containsEdge(tmp.getName(), nextVertex.getKey().getName())) {
					edges.add(new Edge(tmp.getName()+nextVertex.getKey().getName(),nextVertex.getValue(),tmp,nextVertex.getKey()));
				}
			}
		}
	}
	public boolean containsEdge(String first, String second){
		for (Edge edge : edges) {
			if(edge.getName().equals(first+second)||edge.getName().equals(second+first)){
				return true;
			}
		}
		return false;
	}
	public void printEdges() {
		PriorityQueue<Edge> tmp = new PriorityQueue<Edge>();
		tmp.addAll(edges);
		while(!tmp.isEmpty()) {
			System.out.println(tmp.poll());
		}
	}
	public void printSTEdges() {
		System.out.print("Spanning_tree: ");
		for (Edge edge : stEdges) {
			System.out.print("->"+edge.getName());
		}
		System.out.println("     cost: "+cost);
	}
	public Vector<Edge> getStEdges() {
		return stEdges;
	}
	public void setStEdges(Vector<Edge> stEdges) {
		this.stEdges = stEdges;
	}
	public void setEdges(PriorityQueue<Edge> edges) {
		this.edges = edges;
	}
	public void giveSetToVertex() {
		int i=0;
		for (Map.Entry<String, Vertex> vertex : graf.getMap().entrySet()) {
			sets.put(vertex.getValue(), i);
			vertex.getValue().setSet(i);
			i++;
		}
	}
	public void findSpTree() {
		giveSetToVertex();
		while(!edges.isEmpty()) {
			if(!(edges.peek().getLeft().getSet()==edges.peek().getRight().getSet())){
				for (Map.Entry<Vertex, Integer> vertex : sets.entrySet()) {
					if(vertex.getValue()==edges.peek().getLeft().getSet()) {
						vertex.getKey().setSet(edges.peek().getRight().getSet());
					}
				}
				edges.peek().getLeft().setSet(edges.peek().getRight().getSet());
				stEdges.add(edges.peek());
				cost+=edges.peek().getCost();
			}
			edges.poll();
		}
	}

	
	
	
	
	
	
}
