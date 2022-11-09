package com.hcmue.vocabulary.english.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcmue.vocabulary.english.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>{
	@Query("select a from account a where a.username = ?1")
	public Account findByUsername(String username);
}
