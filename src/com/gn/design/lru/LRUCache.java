package com.gn.design.lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * 
 * @author Gaurav Nigam
 *
 * @param <K>
 */
public class LRUCache<K, V> implements LRU<K, V> {
	
	private Map<K,V> dataMap;
	private Deque<K> dataList;
	private int size;
	private int capacity;
	
	public LRUCache(int n) {
		this.capacity = n;
		dataMap = new HashMap<>();
		dataList = new LinkedList<>();
	}

	/**
	 * 
	 */
	@Override
	public void put(K key, V value) {
		Objects.requireNonNull(key, "Key is null");
		Objects.requireNonNull(value, "Value is null");
		
		if(size < capacity) {
			dataMap.put(key, value);
			dataList.push(key);
			size++;
			
		} else {
			
		}
	}

	/**
	 * 
	 */
	@Override
	public Optional<V> get(K key) {
		return null;
	}

	
}
