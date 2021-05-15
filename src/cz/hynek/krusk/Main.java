package cz.hynek.krusk;

import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		g.add("A", "B", 11);
		g.add("A", "E", 9);
		g.add("A", "C", 4);
		g.add("B", "E", 2);
		g.add("C", "E", 2);
		g.add("E", "D", 8);
		g.add("B", "D", 2);
		g.add("C", "G", 14);
		g.add("D", "G", 1);
		g.add("D", "F", 6);
		g.add("F", "G", 3);
		g.add("F", "H", 2);
		g.add("G", "H", 6);
		
		
		Path c = new Path(g);
		c.getPath("A", "H");
		Spanning_tree st = new Spanning_tree(g);
		st.findSpTree();
		st.printSTEdges();
	}

}
