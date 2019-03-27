import java.util.HashMap;
import java.util.LinkedList;
public class Node {
	public int data;
	public LinkedList<Edge> neighbours;
	public HashMap<String, Integer> labels;
	public Node(int data){
		this.data = data;
		labels = new HashMap();
		neighbours = new LinkedList();
	}
	public void addNeighbour(Node to, int weight){
		neighbours.add(new Edge(this, to, weight));
	}
	public void setLabel(String key, Integer data){
		labels.put(key, data);
	}
	public int getLabel(String key){
		return labels.get(key);
	}
}