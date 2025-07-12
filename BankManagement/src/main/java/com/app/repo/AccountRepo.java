package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Account;


public interface AccountRepo extends JpaRepository<Account, Long> {

}
