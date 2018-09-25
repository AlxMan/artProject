package com.art.service.impl;

import com.alibaba.fastjson.JSON;
import com.art.bean.contains.CommonEnum;
import com.art.bean.entity.JWTInfo;
import com.art.bean.entity.UserInfo;
import com.art.bean.entity.UserInfoExample;
import com.art.bean.request.UserLoginRequest;
import com.art.bean.response.UserLoginResponse;
import com.art.common.JWTUtil;
import com.art.dao.UserInfoMapper;
import com.art.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author art
 * @Date 2018/7/19 16:11
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource
    UserInfoMapper mapper;
    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        log.info("[UserInfoServiceImpl]-[login]-入参:{}", JSON.toJSONString(request));
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andNameEqualTo(request.getName()).andPwdEqualTo(request.getPwd());
        List<UserInfo> userInfos = mapper.selectByExample(example);
        log.info("[UserLoginResponse]-[login]-[selectByExample]-出参:{}", JSON.toJSONString(userInfos));
        UserInfo userInfo = userInfos.get(0);
        UserLoginResponse login = new UserLoginResponse();
        if (userInfos == null || userInfos.size() == 0 || !request.getPwd().equals(userInfo.getPwd())) {
            login.setResCode(CommonEnum.LOGIN_FAILED.getCode());
            login.setResMsg(CommonEnum.LOGIN_FAILED.getMsg());
            return login;
        }
        if ("1".equals(userInfo.getUserState())) {
            login.setResCode(CommonEnum.LOGIN_LOCKED.getCode());
            login.setResMsg(CommonEnum.LOGIN_LOCKED.getMsg());
            return login;
        }
        // 生成token
        JWTInfo jwtInfo = new JWTInfo();
        jwtInfo.setPassword(userInfo.getPwd());
        jwtInfo.setUsername(userInfo.getName());
        String jwt = JWTUtil.sign(jwtInfo, Long.valueOf(CommonEnum.JWT_MAXAGE.getMsg()));
        // 放入返回
        login.setJwt(jwt);
        login.setName(userInfo.getName());
        login.setUserType(userInfo.getUserType());
        login.setResCode(CommonEnum.LOGIN_SUCCESS.getCode());
        login.setResMsg(CommonEnum.LOGIN_SUCCESS.getMsg());
        log.info("[UserLoginResponse]-[login]-出参:{}", JSON.toJSONString(login));
        return login;
    }
}