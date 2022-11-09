package com.hcmue.vocabulary.english.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmue.vocabulary.english.entity.Account;
import com.hcmue.vocabulary.english.model.AccountModel;
import com.hcmue.vocabulary.english.repository.AccountRepository;


@Service
public class AaccountServices implements Services<AccountModel>{
	
	@Autowired
	private AccountRepository repo;
	
	@Override
	public List<AccountModel> listAll() {
		List<Account> list = repo.findAll();
		List<AccountModel> listAll = list.stream()
				.map(s -> new AccountModel(s))
				.collect(Collectors.toList());
		return listAll;
	}

	@Override
	public AccountModel findOne(int id) {
		if(repo.getOne(id) != null) {
			AccountModel a = new AccountModel(repo.getOne(id));
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
		Account a = repo.getOne(id);
		if(a != null) {
			AccountModel t = new AccountModel(a);
			t.setStatus(false);
			update(t);
		}
		
		
	}

	
}
