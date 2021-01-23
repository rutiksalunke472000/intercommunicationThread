package com.csi.threadconcept;

import java.util.Scanner;

class customer {

	int accountbalance = 10000;

	synchronized public void withdrawAmount(int amount) {

		System.out.println("\n going to withdrawAmount : ");
		if (this.accountbalance < amount) {

			System.out.println("Insufficient Funds, Please Update Your Funds.");

			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		this.accountbalance -= accountbalance;
		System.out.println("Amount Withdraw Successfully...");
	}

	synchronized public void depositAmount(int amount) {
		System.out.println("Going To Deposit Amount : ");
		this.accountbalance += accountbalance;

		System.out.println("Amount Deposited Successfully");

		notify();
	}
}

public class InterThreadCommunication {

	public static void main(String[] args) {
		InterThreadCommunication dd= new InterThreadCommunication();
		System.out.println("\n Please enter amount to witdraw: ");

		Scanner sc = new Scanner(System.in);

		int withdrawAmnt = sc.nextInt();
		customer cc = new customer();
		new Thread() {

			public void run() {
				cc.withdrawAmount(withdrawAmnt);

			};
		}.start();

		new Thread() {

			
			public void run() {
				
				cc.depositAmount(dp());
			};
		}.start();
	}

	static int dp() {
		System.out.println("\n Please enter amount to deposit: ");

		Scanner sc = new Scanner(System.in);

		int dpAmnt = sc.nextInt();
		
		return dpAmnt;
	}
}
