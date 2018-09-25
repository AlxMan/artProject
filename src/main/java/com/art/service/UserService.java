package com.art.service;
import com.art.bean.request.UserLoginRequest;
import com.art.bean.response.UserLoginResponse;
/**
 * @Description TODO
 * @Author art
 * @Date 2018/7/19 16:09
 * @Version 1.0
 */
public interface UserService {
   public UserLoginResponse login(UserLoginRequest request);
}