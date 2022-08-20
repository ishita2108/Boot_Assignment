package com.bankapp.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entity.Account;

@RestController
@RequestMapping(path="api")
public class TransactionRestController {
//	@GetMapping(path ="hi")
//	public String hello() {
//		return "hello to bank app";
//		}
	
	@GetMapping(path ="accounts")
	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account(1,"Ishita",90000));
		accounts.add(new Account(2,"Gaurav",90000));
		return accounts;
		}
	
}
