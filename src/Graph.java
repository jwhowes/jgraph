import java.util.HashMap;
import java.util.LinkedList;
public class Graph{
	private HashMap<Integer, Node> adjacency_list;
	public Graph(){
		adjacency_list = new HashMap();
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
	public LinkedList<Edge> neighbours(Node node){
		return node.neighbours;
	}
	public LinkedList<Edge> neighbours(int data){
		return getNode(data).neighbours;
	}
	public void addEdge(int from, int to, int weight){
		addEdge(getNode(from), getNode(to), weight);
	}
	public void addEdge(Node from, Node to, int weight){
		from.addNeighbour(to, weight);
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
	public Node[] nodes(){
		Node[] result = new Node[adjacency_list.size()];
		int i = 0;
		for(int data : adjacency_list.keySet()){
			result[i] = getNode(data);
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