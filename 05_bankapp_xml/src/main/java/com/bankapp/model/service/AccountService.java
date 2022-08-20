package com.bankapp.model.service;

//Business Logic = FR + NFR
import java.util.List;

import com.bankapp.model.persistence.Account;

public interface AccountService {

	public List<Account> getAll();

	public Account getById(int id);

	public void updateAccount(Account account);

	public void transfer(int fromAccNo, int toAccountNo, double amount);

	public void deposit(int accNo, double amount);

	public void withdraw(int accNo, double amount);

}
