package com.hcmue.vocabulary.english.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hcmue.vocabulary.english.model.AccountModel;
import com.hcmue.vocabulary.english.repository.AccountRepository;

public class AccountServices implements UserDetailsService{
	
	@Autowired
    private AccountRepository repo;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountModel accountModel = new AccountModel(repo.findByUsername(username));
        if (repo.findByUsername(username) == null) {
            throw new UsernameNotFoundException("Account is not found!");
        }
        return new AccountDetails(accountModel);
    }
 
}