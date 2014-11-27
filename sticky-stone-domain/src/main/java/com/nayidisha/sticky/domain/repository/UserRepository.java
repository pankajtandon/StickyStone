package com.nayidisha.sticky.domain.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.nayidisha.sticky.domain.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User findByUserId(@Param("userId") String userId);
	List<User> findUsersByName(@Param("name") String name);
}
