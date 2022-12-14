package com.hcmue.vocabulary.english.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hcmue.vocabulary.english.entity.Account;
import com.hcmue.vocabulary.english.model.AccountModel;
import com.hcmue.vocabulary.english.repository.AccountRepository;


@Service
public class AaccountServices implements Services<AccountModel>{
	
	@Autowired
	private AccountRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public List<AccountModel> listAll() {
		List<Account> list = repo.findAll();
		if(list != null) {
			List<AccountModel> listAll = list.stream()
					.map(s -> new AccountModel(s))
					.collect(Collectors.toList());
			return listAll;
		}
		return null;
	}

	@Override
	public AccountModel findOne(int id) {
		Account t = repo.findOne(id);
		if(t != null) {
			AccountModel a = new AccountModel(t);
			return a;
		}
		return null;
	}

	@Override
	public void update(AccountModel t) {
		if(t != null) {
			Account a = new Account(t);
			repo.save(a);
		}
	}

	@Override
	public void delete(int id) {
		AccountModel a = findOne(id);
		if(a != null) {
			a.setStatus(false);
			update(a);
		}
	}
	
	public AccountModel findOne(String username) {
		Account s = repo.findByUsername(username);
		if(s!=null) {
			AccountModel accountModel = new AccountModel(s);
			return accountModel;
		}
		return null;
	}
	
	public boolean register(AccountModel t, String MatKhauXN) {
		if(!t.getPassword().equals(MatKhauXN)) {
			return false;
		}
		
		if(t.getUsername().equals("admin")) {
			return false;
		}
		AccountModel k = findOne(t.getUsername());
		if(k != null) {
			return false;
		}
		try {
			if(t != null) {
				passwordEncoder = new BCryptPasswordEncoder();
				t.setPassword(passwordEncoder.encode(t.getPassword()));;
				update(t);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int getRownum() {
		return repo.getRownum();
	}
}
