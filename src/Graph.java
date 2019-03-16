import java.util.HashMap;
import java.util.LinkedList;
public class Graph{
	private HashMap<Integer, Node> adjacency_list;
	private LinkedList<Edge> edges;
	public Graph(){
		adjacency_list = new HashMap();
		edges = new LinkedList();
	}
	public void addNode(int data){
		adjacency_list.put(data, new Node(data));
	}
	public void addNodesFrom(int[] data){
		for(int item : data){
			addNode(item);
		}
	}
	public Node getNode(int data){
		return adjacency_list.get(data);
	}
	public Edge[] neighbours(Node node){
		Edge[] edges = new Edge[node.neighbours.size()];
		int i = 0;
		for(Edge edge : node.neighbours){
			edges[i] = edge;
			i++;
		}
		return edges;
	}
	public Edge[] neighbours(int data){
		return neighbours(getNode(data));
	}
	public void addEdge(int from, int to, int weight){
		addEdge(getNode(from), getNode(to), weight);
	}
	public void addEdge(int from, int to, int weight, boolean directed){
		addEdge(from, to, weight);
		if(!directed){
			addEdge(to, from, weight);
		}
	}
	public void addEdge(Node from, Node to, int weight, boolean directed){
		addEdge(from, to, weight);
		if(!directed){
			addEdge(to, from, weight);
		}
	}
	public void addEdge(Node from, Node to, int weight){
		from.addNeighbour(to, weight);
		edges.add(new Edge(to, from, weight));
	}
	public void addEdge(Edge edge){
		addEdge(edge.from, edge.to, edge.weight);
	}
	public void addEdgesFrom(Edge[] edges){
		for(Edge edge : edges){
			addEdge(edge);
		}
	}
	public void debug(){
		for(int data : adjacency_list.keySet()){
			System.out.print(data + ": ");
			for(Edge edge : neighbours(data)){
				System.out.print(edge.to.data + " (" + edge.weight + "), ");
			}
			System.out.println();
		}
	}
	public Edge[] edges(){
		Edge[] result = new Edge[edges.size()];
		int i = 0;
		for(Edge edge : edges){
			result[i] = edge;
			i++;
		}
		return result;
	}
	public Node[] nodes(){
		Node[] result = new Node[adjacency_list.keySet().size()];
		int i = 0;
		for(int key : adjacency_list.keySet()){
			result[i] = adjacency_list.get(key);
			i++;
		}
		return result;
	}
	public void setLabel(int data, String key, int value){
		getNode(data).setLabel(key, value);
	}
	public void setLabel(Node node, String key, int value){
		node.setLabel(key, value);
	}
	public int getLabel(int data, String key){
		return getNode(data).getLabel(key);
	}
	public int getLabel(Node node, String key){
		return getLabel(node.data, key);
	}
}