package cz.hynek.krusk;

import java.util.PriorityQueue;
import java.util.Vector;

public class Path implements Comparable<Path>{
	private Graph graf;
	private Vertex lastNode = null;
	private Vector<Vertex> nodes = new Vector<Vertex>();
	private int cost;
	
	public Path(Graph g) {
		this.graf=g;
	}
	public void addNode(String nazevuzlu) {
		Vertex u = graf.getVertext(nazevuzlu);
		
		if(lastNode == null) {
			cost=0;
		}else {
			cost += lastNode.getCost(u);
		}
		lastNode=u;
		nodes.add(u);
	}
	public int getCost() {
		return cost;
	}
	public boolean isAtDestination(String destination) {
		if(lastNode == null) {
			return false;
		}else {
			return destination.equals(lastNode.getName());
		}
	}
	public Path cloneAndAdd(String vortexName) {
		Path copy = new Path(graf);
		copy.lastNode = lastNode;
		copy.cost = cost;
		copy.nodes.addAll(nodes);
		
		copy.addNode(vortexName);
		return copy;
	}
	@Override
	public int compareTo(Path o) {
		Integer c1 = cost;
		Integer c2 = o.getCost();
		return c1.compareTo(c2);
	}
	@Override
	public String toString() {
		String path="";
		for (Vertex vertex : nodes) {
			path=path+"->"+vertex.getName();
		}
		return path;
	}
	public Path getPath(String start, String stop) {
		PriorityQueue<Path> prioFronta = new PriorityQueue<Path>();
		
		Path c = new Path(graf);
		c.addNode(start);
		prioFronta.add(c);
		System.out.print("Shortest_path["+start+"-"+stop+"]: ");
		while(!prioFronta.isEmpty()) {
			Path tmp = prioFronta.remove();
			if(tmp.isAtDestination(stop)) {
				System.out.println(tmp+"    cost="+tmp.getCost());
				return tmp;
			}
			for (Vertex vertex : tmp.getLast().getVertexSet()) {
				Path copy = tmp.cloneAndAdd(vertex.getName());
				prioFronta.add(copy);
			}
		}
		
		return null;
	}
	public Vertex getLast() {
		return lastNode;
	}
}
