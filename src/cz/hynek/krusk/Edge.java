package cz.hynek.krusk;

public class Edge implements Comparable<Edge>{
	private String name;
	private int cost;
	private Vertex left;
	private Vertex right;
	private int set;
	
	public Edge(String name, int cost, Vertex left, Vertex right) {
		super();
		this.name = name;
		this.cost = cost;
		this.left = left;
		this.right = right;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String id) {
		this.name = id;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Vertex getLeft() {
		return left;
	}
	public void setLeft(Vertex left) {
		this.left = left;
	}
	public Vertex getRight() {
		return right;
	}
	public void setRight(Vertex right) {
		this.right = right;
	}
	public int getSet() {
		return set;
	}
	public void setSet(int set) {
		this.set = set;
	}
	@Override
	public int compareTo(Edge edge) {
		Integer e1 = this.cost;
		Integer e2 = edge.cost;
		return e1.compareTo(e2);
	}
	@Override
	public String toString() {
		return "Edge [name=" + name + ", cost="+cost+"]";
	}
	
}
