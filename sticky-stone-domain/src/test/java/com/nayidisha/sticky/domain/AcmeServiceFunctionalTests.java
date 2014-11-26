package com.nayidisha.sticky.domain;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.nayidisha.sticky.domain.entity.User;
import com.nayidisha.sticky.domain.service.AcmeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@Transactional
@TransactionConfiguration
@EnableAutoConfiguration
public class AcmeServiceFunctionalTests {

    @Inject
    AcmeService acmeService;
    
    @Before
    public void setup(){
    	acmeService.createUser("aUserId", "aUserName");
    }
    
    @Test
    public void testUserCreation(){
    	User u = acmeService.findByUserId("aUserId");
    	Assert.isTrue(u != null, "User with userId 'aUserId' does not exist in db!");
    }

}
