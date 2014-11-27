package com.nayidisha.sticky.domain.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.nayidisha.sticky.domain.entity.Account;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

	List<Account> findByName(@Param("name") String name);
	List<Account> findByAccountType(@Param("accountType") String accountType);

}
