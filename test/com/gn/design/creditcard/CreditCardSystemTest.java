package com.gn.design.creditcard;

import java.util.Random;
import java.util.stream.IntStream;

public class CreditCardSystemTest {
	
	/*
	Credit card transactions data is coming in real-time. The data coming in has duplicates that need to be ignored for the billing system.
	
	You need to design and implement a system that takes the credit card transactions data, one transaction at a time, and then prints UNIQUE or DUPLICATE for every tuple.
	
	The duplicates are expected only within 1 hour from the transaction time.  As the program is running 24x7, you need to clear the older data that is no longer required. You need to flush stale data once a minute.
	
	Data:
	- Incoming data has transaction ID and timestamp along with other transactional information.
	- Incoming data is unordered.
	- For simplicity assume
	  - Timestamp is integer.
	  - Timestamp is at second level.
	  - The reference current time is the timestamp of the transaction with the highest time so far.
	 
	 */
	
	public static void main(String[] args) {

		int transactionBaseTime = 2002201000;
		DataHolder<Transaction> dataHolder = new TransactionHolder();

		Random r = new Random();
		int T = 50;
		while (T-- > 0) {
			Transaction txn = new Transaction(r.nextInt(50), transactionBaseTime++);

			dataHolder.addTransaction(txn);

			System.out.println(txn);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	

}
