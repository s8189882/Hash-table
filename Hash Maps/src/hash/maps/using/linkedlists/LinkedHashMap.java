package hash.maps.using.linkedlists;

//import java.lang.reflect.Array;
import java.util.ArrayList;

public class LinkedHashMap<K,V> {

	private final int numberOfBuckets;
	ArrayList<LinkedList<K>> bucketArray;
	
	public LinkedHashMap() {
		this.numberOfBuckets = 10;
		this.bucketArray = new ArrayList<LinkedList<K>>(numberOfBuckets);
		
		for(int index = 0; index < numberOfBuckets; index++)
			this.bucketArray.add(null);
	}
	
	public void remove(K key){
		int index = this.getBucketIndex(key);
		LinkedList<K> linkedList = this.bucketArray.get(index);

		if(linkedList == null) {
			System.out.println("\nNo entries!");
		}
		
		linkedList.pop(key);
	}
	
	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		LinkedList<K> linkedList = this.bucketArray.get(index);

		if(linkedList == null) {
			linkedList = new LinkedList<K>();
			this.bucketArray.set(index, linkedList);
		}
		
		MapNode<K, V> mapNode = (MapNode<K, V>) linkedList.search(key);
		if(mapNode == null) {
			mapNode = new MapNode<>(key, value);
			linkedList.append(mapNode);
		}
		else
			mapNode.setValue(value);
	}	
	
	public V get(K key) {
		int index = this.getBucketIndex(key);
		LinkedList<K> linkedList = this.bucketArray.get(index);
		if (linkedList == null)
			return null;
		MapNode<K,V> mapnode = (MapNode<K,V>)linkedList.search(key);
		return (mapnode == null) ? null : mapnode.getValue();
	}

	@Override
	public String toString() {
		return "LinkedHashMap { " + bucketArray + "}";
	}

	private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % numberOfBuckets;
		//System.out.println("Key : \t'" + key + "' \tHashcode : " + hashCode + " \tindex : " + index);
		return index;
	}
}
