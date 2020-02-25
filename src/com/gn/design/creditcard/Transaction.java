package com.gn.design.creditcard;

public class Transaction {
	
	private int transactionId;
	private int timeStamp;
	
	public Transaction(int transactionId, int timeStamp) {
		super();
		this.transactionId = transactionId;
		this.timeStamp = timeStamp;
	}

	public int getTimeStamp() {
		return timeStamp;
	}
	
	public int getTransactionId() {
		return transactionId;
	}
	
	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + transactionId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", timeStamp=" + timeStamp + "]";
	}
	
	

	
	

}
