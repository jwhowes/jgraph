import java.util.HashMap;
import java.util.LinkedList;
public class Graph{
	private HashMap<Integer, LinkedList<Node>> adjacency_list;
	public Graph(){
		adjacency_list = new HashMap();
	}
	public void addNode(int data){
		LinkedList<Node> node = new LinkedList();
		node.add(new Node(data));
		adjacency_list.put(data, node);
	}
	public void addNodesFrom(int[] data){
		for(int item : data){
			addNode(item);
		}
	}
	public Node getNode(int data){
		return adjacency_list.get(data).get(0);
	}
	public Node getNode(Node node){
		return adjacency_list.get(node.data).get(0);
	}
	public Node[] neighbours(int data){
		Node[] result = new Node[adjacency_list.get(data).size() - 1];
		int i = 0;
		for(Node node : adjacency_list.get(data)){
			if(i != 0){
				result[i - 1] = node;
			}
			i++;
		}
		return result;
	}
	public Node[] neighbours(Node node){
		return neighbours(node.data);
	}
	public void addEdge(int from, int to){
		adjacency_list.get(from).add(getNode(to));
	}
	private void addEdge(int from, int to, boolean directed){
		addEdge(from, to);
		if(!directed){
			addEdge(to, from);
		}
	}
	public void debug(){
		for(int data : adjacency_list.keySet()){
			System.out.print(data + ": ");
			for(Node node : neighbours(data)){
				System.out.print(node.data + ", ");
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
		adjacency_list.get(data).get(0).setLabel(key, value);
	}
	public void setLabel(Node node, String key, int value){
		setLabel(node.data, key, value);
	}
	public int getLabel(int data, String key){
		return getNode(data).getLabel(key);
	}
	public int getLabel(Node node, String key){
		return getLabel(node.data, key);
	}
}