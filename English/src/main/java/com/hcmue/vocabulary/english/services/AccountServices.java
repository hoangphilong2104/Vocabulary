package com.hcmue.vocabulary.english.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hcmue.vocabulary.english.entity.Account;
import com.hcmue.vocabulary.english.model.AccountModel;
import com.hcmue.vocabulary.english.repository.AccountRepository;

public class AccountServices implements UserDetailsService{
	
	@Autowired
    private AccountRepository repoAccount;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Account account = repoAccount.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Account is not found!");
        }
        AccountModel accountModel = new AccountModel(account);
        return new AccountDetails(accountModel);
    }
 
}