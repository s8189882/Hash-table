package hash.maps.using.linkedlists;

public class Node<K> implements INode<K> {

	private K key;
	private INode<K> next;
	
	public Node(K key) {
		this.key = key;
		this.next = null;
	}
	
	public Node() {
		
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public void setKey(K key) {
		this.key = key;
	}

	public INode<K> getNext() {
		return next;
	}

	public void setnext(INode<K> next) {
		this.next = next;
	}
}