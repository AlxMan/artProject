package com.art.service;
import com.art.entity.UserEntity;

/**
 * @Description TODO
 * @Author art
 * @Date 2018/7/19 16:09
 * @Version 1.0
 */
public interface UserService {
   public UserEntity checkLogin(String username,String password)throws  Exception;
}