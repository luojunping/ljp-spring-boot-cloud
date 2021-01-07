package com.ljp.test.service.impl;

import com.ljp.test.dao.UserDAO;
import com.ljp.test.dto.UserDTO;
import com.ljp.test.service.TestTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTestServiceImpl implements TestTestService {

    @Autowired
    private UserDAO userDAO;

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public UserDTO helloWorld() {
        UserDTO userDTO = new UserDTO();
        userDTO.setLoginName("1");
        userDTO.setLoginPassword("1");
        userDTO.setUserName("1");
        userDTO.setUserEmail("1");
        userDAO.insert(userDTO);
        this.hahaha();
        System.out.println(1 / 0);
        userDTO = new UserDTO();
        userDTO.setLoginName("4");
        userDTO.setLoginPassword("4");
        userDTO.setUserName("4");
        userDTO.setUserEmail("4");
        userDAO.insert(userDTO);
        return userDAO.selectById(2L);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void hahaha() {
        UserDTO userDTO = new UserDTO();
        userDTO.setLoginName("2");
        userDTO.setLoginPassword("2");
        userDTO.setUserName("2");
        userDTO.setUserEmail("2");
        userDAO.insert(userDTO);
        userDTO = new UserDTO();
        userDTO.setLoginName("3");
        userDTO.setLoginPassword("3");
        userDTO.setUserName("3");
        userDTO.setUserEmail("3");
        userDAO.insert(userDTO);
    }

}
