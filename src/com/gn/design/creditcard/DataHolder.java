package com.gn.design.creditcard;

public interface DataHolder<T> {
	
	
	/**
	 * add new transaction in Holder
	 * @param txn
	 * @return
	 */
	public boolean addTransaction(T txn);
	
	/**
	 * check if transaction is duplicate or unique
	 * @param txn
	 * @return true if duplicate, flase if unique
	 */
	public boolean isDuplicate(T txn);
	
	/**
	 * expire transaction from Holder data structure
	 * @param expireationTimeInSec
	 */
	public void expireTransaction(int expireationTimeInSec);

}
