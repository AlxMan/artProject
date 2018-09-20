package com.art.service.impl;

import com.art.common.ThisSystemException;
import static com.art.common.ThisSystemUtil.*;
import com.art.dao.UserDao;
import com.art.entity.UserEntity;
import com.art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author art
 * @Date 2018/7/19 16:11
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public UserEntity checkLogin(String username, String password) throws Exception {
        username=$("帐号不能为空！",username) ;
        password=$("密码不能为空！",password) ;

        UserEntity userEntity = userDao.selectByUsername(username);
        if (userEntity==null){
            throw new ThisSystemException("帐号不存在");
        }
        if (!userEntity.getPassword().equals(password)){
            throw new ThisSystemException("密码不正确");
        }
        return userEntity;
    }
}