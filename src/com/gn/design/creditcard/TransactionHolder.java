package com.gn.design.creditcard;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author gnigam
 *
 */
public class TransactionHolder implements DataHolder<Transaction> {
	
	private static final int DEFAULT_EXPIRATION_TIME = 10;
	private int expirationTime;
	
	public TransactionHolder() {
		this.expirationTime = DEFAULT_EXPIRATION_TIME;
	}
	
	public TransactionHolder(int expireationTime) {
		this.expirationTime = expireationTime;
	}

	private Set<Transaction> transactionData = new HashSet<>();	
	
	ExecutorService executor = Executors.newFixedThreadPool(1);
	
	@Override
	public boolean addTransaction(Transaction txn) {
		if(txn != null) {
			int latestTransactionTime = txn.getTimeStamp();
			if(isDuplicate(txn)) {
				System.out.println("DUPLICATE");
			} else {
				System.out.println("UNIQUE");
				transactionData.add(txn);
				
			}
			expireTransaction(latestTransactionTime);
		}
		
		return false;
	}

	@Override
	public boolean isDuplicate(Transaction txn) {
		if(txn != null && transactionData.contains(txn)) {
			return true;
		}
		return false;
	}

	@Override
	public void expireTransaction(int lastTransactionTime) {
		System.out.print("Size [Before]: " + transactionData.size());
		transactionData.removeIf(t -> (lastTransactionTime - t.getTimeStamp() ) > expirationTime);
		System.out.println(" ==> [After]: " + transactionData.size());
	}
	
	

}
