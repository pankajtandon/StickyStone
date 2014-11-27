package com.nayidisha.sticky.domain.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nayidisha.sticky.domain.entity.User;
import com.nayidisha.sticky.domain.repository.UserRepository;


@Service
@Transactional
public class AcmeServiceImpl implements AcmeService {

	private UserRepository userRepository;
	
	@Inject
	public AcmeServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	
	@Override
	public User createUser(String userId, String name) {
        User user = new User(userId, name);
        this.userRepository.save(user); 
        return user;
	}

	@Override
	public User findByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}

}
