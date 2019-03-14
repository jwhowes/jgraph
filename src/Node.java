import java.util.HashMap;
public class Node {
	public int data;
	private HashMap<String, Integer> labels;
	public Node(int data){
		this.data = data;
		labels = new HashMap();
	}
	public void setLabel(String key, Integer data){
		labels.put(key, data);
	}
	public int getLabel(String key){
		return labels.get(key);
	}
}