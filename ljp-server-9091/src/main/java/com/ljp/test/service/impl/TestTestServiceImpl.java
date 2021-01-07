package com.ljp.test.service.impl;

import com.ljp.test.dao.UserDAO;
import com.ljp.test.dto.UserDTO;
import com.ljp.test.service.TestTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTestServiceImpl implements TestTestService {

    @Autowired
    private UserDAO userDAO;

    @Transactional(readOnly = true)
    @Override
    public UserDTO helloWorld() {
        // Page<UserDTO> userDTOPage = userDAO.selectPage(new Page<>(), null);
        // System.out.println("userDTOPage:" + userDTOPage);
        return userDAO.selectById(1L);
    }

}
