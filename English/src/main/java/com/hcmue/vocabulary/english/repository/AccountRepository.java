package com.hcmue.vocabulary.english.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcmue.vocabulary.english.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>{
	@Query("SELECT a FROM Account a WHERE a.username = ?1")
	Account findByUsername(String username);
	@Query("SELECT COUNT(id) FROM Account a")
	public int getRownum();
	@Query("SELECT a FROM Account a WHERE a.id = ?1")
	public Account findOne(int id);
}
