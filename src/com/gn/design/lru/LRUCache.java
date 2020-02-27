package com.gn.design.lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

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
		size = 0;
	}

	/**
	 * 
	 */
	@Override
	public void put(K key, V value) {
		Objects.requireNonNull(key, "Key is null");
		Objects.requireNonNull(value, "Value is null");

		if (!dataMap.containsKey(key)) {
			// if data can be accommodated 
			if (size < capacity) {
				// insert into map and add into dqueue front
				dataMap.put(key, value);
				dataList.addFirst(key);
				size++;

			} else {
				K keyToDelete = dataList.removeLast();
				dataMap.remove(keyToDelete);
				dataList.addFirst(key);
				dataMap.put(key,value);
				
			}
		}
	}

	/**
	 * 
	 */
	@Override
	public V get(K key) {
		if(dataMap.containsKey(key)) {
			dataList.remove(key);
			dataList.addFirst(key);
			return dataMap.get(key);
		}
		return null;
	}

	
}
