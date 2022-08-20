package com.bankapp.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="account_table")
	public class Account {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		private double balance;


		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public Account(int id, String name, double balance) {
			super();
			this.id = id;
			this.name = name;
			this.balance = balance;
		}

		public Account(String name, double balance) {
			this.name = name;
			this.balance = balance;
		}
		public Account() {
		}

		@Override
		public String toString() {
			return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
		}


}
