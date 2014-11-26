package com.nayidisha.sticky.domain.service;

import com.nayidisha.sticky.domain.entity.User;


public interface AcmeService {
	
	User createUser(String userId, String name);
	User findByUserId(String userId); 

}
