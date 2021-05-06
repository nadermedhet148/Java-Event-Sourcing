package com.accountService.repository;

import com.accountService.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAccountRepo extends JpaRepository<Account, Integer> {
    List<Account> findByUserId(Integer userId);

}
