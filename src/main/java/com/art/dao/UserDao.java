package com.art.dao;

import com.art.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Description TODO
 * @Author art
 * @Date 2018/7/19 16:02
 * @Version 1.0
 */
public interface UserDao {
    UserEntity selectByUsername(@Param("username")String username) throws Exception;
}