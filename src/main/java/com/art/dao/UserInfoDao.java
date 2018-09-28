package com.art.dao;

import com.art.bean.dto.UserInfoExample;
import com.art.bean.entity.UserInfo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoDao {
    /*
    　* @Description: 根据用户名密码查询
    　* @user wangxianchao
    　* @date 2018/9/27 11:36
    */
    UserInfo selectByName(@Param("name")String name,
                      @Param("pwd")String pwd);
    List<UserInfo> selectByExample(UserInfoExample example);
    String checkJWT(String name);



}