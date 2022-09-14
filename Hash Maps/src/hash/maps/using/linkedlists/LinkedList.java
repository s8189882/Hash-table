package hash.maps.using.linkedlists;

public class LinkedList<K> {

	public INode<K> head;
	public INode<K> tail;
	
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public void append(INode<K> newNode) {	
		if(this.head == null) {
			this.head = newNode;
		}
		
		if (this.tail == null) {
			this.tail = newNode;
		}
		else {
			this.tail.setnext(newNode);
			this.tail = newNode;
		}
	}
	
	public void add(K element) {
		Node<K> newNode = new Node<K>(element);
		
		if(this.tail == null) {
			this.tail = newNode;
		}
		
		if (this.head == null) {
			this.head = newNode;
		}
		else {
			INode<K> tempNode = this.head;
			this.head = newNode;
			this.head.setnext(tempNode);
		}
	}
	
	public void printNodes() {
		StringBuffer nodes = new StringBuffer("My nodes : ");
		
		INode<K> tempNode = head;
		while(tempNode.getNext() != null) {
			nodes.append(tempNode.getKey());
			if(!tempNode.equals(tail))
				nodes.append("->");
			tempNode = tempNode.getNext();
		}
		nodes.append(tempNode.getKey());
		System.out.println(nodes);
	}
	
	public INode<K> search(K findElement) {
		INode<K> thisNode = head;
		
		while (thisNode != null) {
			if (thisNode.getKey().equals(findElement)) {
				return thisNode;
			}
			thisNode = thisNode.getNext();
		}	
		return null;
	}
	
	public void insert(INode<K> node, K insertElement) {
		Node<K> newNode = new Node<K>(insertElement);
		INode<K> tempNode = node.getNext();
		
		node.setnext(newNode);
		newNode.setnext(tempNode);
	}
	
	public  int getSize() {
		INode<K> thisNode = this.head;
		int count = 0;
		
		if (thisNode == null) 
			count = 0;
		else {
			while (thisNode != null) {
				count++;
				thisNode = thisNode.getNext();
			}
		}
		return count;
	}
	
	public INode<K> pop() {
		INode<K> tempNode = this.head;
		this.head = head.getNext();
		return tempNode;
	}
	
	public INode<K> popLast() {
		INode<K> tempNode = head;
		
		while(!tempNode.getNext().equals(tail)) {
			tempNode = tempNode.getNext();
		}
		this.tail = tempNode;
		tempNode = tempNode.getNext();
		return tempNode;
	}
}
