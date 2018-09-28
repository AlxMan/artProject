package com.art.service;

import com.art.bean.request.UserLoginRequest;
import com.art.bean.response.UserLoginResponse;
import javax.servlet.http.HttpServletRequest;

/*
　* @Description:
　* @user wangxianchao
　* @date 2018/9/26 18:00 
*/
public interface UserInfoService {
  UserLoginResponse login(UserLoginRequest request);
  Boolean checkJWT(HttpServletRequest req);
}
