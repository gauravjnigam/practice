package com.gn.design.lru;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gn.model.Employee;

public class LRUCacheTest {
	
	LRU<Employee.Key, Employee> lruCache;
	
	Employee.Key key1;
	Employee.Key key2;
	Employee.Key key3;
	
	Employee value1;
	Employee value2;
	Employee value3;
	
	@Before
	public void setup() {
		lruCache = new LRUCache<Employee.Key, Employee>(2);
		prepareData();
	}
	
	
	
	private void prepareData() {
		key1 = new Employee.Key(1001);
		value1 = new Employee(key1);
		value1.setName("Name1");
		
		key2 = new Employee.Key(1002);
		value2 = new Employee(key2);
		value2.setName("Name2");
		
		key3 = new Employee.Key(1003);
		value3 = new Employee(key3);
		value3.setName("Name3");
	}



	@Test
	public void testEmptyCacheOnStart() {
		Employee.Key key = new Employee.Key(1);
		Assert.assertEquals(lruCache.get(key), null);
	}

	@Test
	public void testCacheWithPartialFilledData() {
		lruCache.put(key1, value1);
		Assert.assertEquals(lruCache.get(key1), value1);
		Assert.assertEquals(lruCache.get(key2), null);
	}
	
	@Test
	public void testCacheAfterRemovalLeastRecentData() {
		lruCache.put(key1, value1);
		lruCache.put(key2, value2);
		lruCache.put(key3, value3);
		Assert.assertEquals(lruCache.get(key1), null);
		Assert.assertEquals(lruCache.get(key2), value2);
		Assert.assertEquals(lruCache.get(key3), value3);
	}
	
	@Test
	public void testCacheForRenewedEntry() {
		lruCache.put(key1, value1);
		lruCache.put(key2, value2);
		Assert.assertEquals(lruCache.get(key1), value1);
		lruCache.put(key3, value3);
		Assert.assertEquals(lruCache.get(key2), null);
		Assert.assertEquals(lruCache.get(key3), value3);
	}
	
	
}
