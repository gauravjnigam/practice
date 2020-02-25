package com.gn.design.lru;

import java.util.Optional;


public interface LRU<K, V> {
	
	public void put(K key, V value);
	
	public Optional<V> get(K key);

}
