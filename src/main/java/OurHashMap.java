import java.util.LinkedList;

/**
 * The class represents own implementation of HashMap.
 * @author Alexey Aksionov
 * @param <K> type parameter for key.
 * @param <V> type parameter for value.
 */
public class OurHashMap<K, V> {
    /**
     *Default array size.
     */
    public static final int DEFAULT_CAPACITY=16;
    /**
     *Number of elements in the collection.
     */
    private int size;
    private LinkedList<Entry<K, V>>[]buckets;
    public OurHashMap(){
        this(DEFAULT_CAPACITY);
    }
    public OurHashMap(int capacity){
        buckets=new LinkedList[capacity];
        for(int i=0;i<capacity;i++){
            buckets[i]=new LinkedList<>();
        }
    }
    /**
     *A helper class that stores a key-value pair.
     */
    private static class Entry<K,V>{
        K key;
        V value;
        Entry(K key, V value){
            this.key=key;
            this.value=value;
        }
    }
    /**
     *The method used to determine the index in an array where the key-value pair should be placed.
     * @param key given key
     * @return index in an array
     */
    private int getIndex(K key){
        return Math.abs(key.hashCode())%buckets.length;
    }
    /**
     *The method adds a key-value pair to the collection.
     * @param key given key
     * @param value the value that is associated with given key.
     */
    public void put(K key, V value){
        int index = getIndex(key);
        LinkedList<Entry<K,V>>bucket = buckets[index];
        for(Entry<K,V>entry :bucket){
            if(entry.key.equals(key)){
                entry.value=value; //обновление ключа, если он существует
                return;
            }
        }
        bucket.add(new Entry<>(key,value));
        size++;
    }
    /**
     *The method returns the value by key.
     * @param key given key
     * @return the value that is associated with given key
     * return null if the key is not found
     */
    public V get(K key){
        int index=getIndex(key);
        LinkedList<Entry<K, V>>bucket=buckets[index];
        for(Entry<K,V> entry : bucket){
            if(entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;
    }
    /**
     *The method returns number of elements in the collection.
     * @return number of pairs of elements in the collection.
     */
    public int size(){
        return size;
    }
    /**
     *The method remove an element from a collection.
     * @param key given key
     * @return the value that is associated with given key
     * return null if the key is not found
     */
    public V remove(K key){
        int index= getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        for(Entry<K,V>entry :bucket){
            if(entry.key.equals(key)){
                bucket.remove(entry);
                size--;
                return entry.value;
            }
        }
        return null;
    }
    /**
     *The method removes all elements of the collection
     */
    public  void clear(){
        for (int i = 0; i < buckets.length ; i++) {
            buckets[i] =new LinkedList<>();
        }
    }
    /**
     *The method checks for the presence of a key in the collection.
     * @param key given key
     * @return true, if key found
     */
    boolean ContainsKey(K key){
        int index=getIndex(key);
        LinkedList<Entry<K, V>>bucket=buckets[index];
        for(Entry<K,V> entry : bucket){
            if(entry.key.equals(key)){
                return true;
            }
        }
        return false;
    }
    /**
     *The method checks for the presence of a value in the collection.
     * @param value given value
     * @return true, if value found
     */
    boolean ContainsValue(V value){
        for (int i = 0; i < buckets.length; i++) {
            LinkedList<Entry<K, V>> bucket = buckets[i];
            for (Entry<K, V> entry : bucket) {
                if (entry.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     *The method checks whether the collection is empty or not
     * @return true, if  the collection is empty
     */
    boolean isEmpty(){
        return size==0;
    }

}

