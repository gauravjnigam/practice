package com.gn.design.lru;

public interface LRU<K, V> {
	
	public void put(K key, V value);
	
	public V get(K key);

}
