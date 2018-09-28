package com.art.service.impl;

import com.alibaba.fastjson.JSON;
import com.art.bean.contains.CommonEnum;
import com.art.bean.dto.UserInfoExample;
import com.art.bean.entity.JWTInfo;
import com.art.bean.entity.UserInfo;
import com.art.bean.request.UserLoginRequest;
import com.art.bean.response.UserLoginResponse;
import com.art.common.CookieUtil;
import com.art.common.JWTUtil;
import com.art.dao.UserInfoDao;
import com.art.service.UserInfoService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/*
　* @Description:
　* @user wangxianchao
　* @date 2018/9/26 18:02 
*/
@Service
public class UserInfoServiceImpl implements UserInfoService {
  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Resource
  UserInfoDao UserInfoDao;

  public UserLoginResponse login(UserLoginRequest request) {
    log.info("[UserInfoServiceImpl]-[login]-入参:{}", JSON.toJSONString(request));
    UserInfoExample example = new UserInfoExample();
    example.createCriteria().andNameEqualTo(request.getName()).andPwdEqualTo(request.getPwd());
    List<UserInfo> userInfos = UserInfoDao.selectByExample(example);
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

  public Boolean checkJWT(HttpServletRequest req) {
    String jwt = null;
    String name = null;
    Map<String, Cookie> stringCookieMap = CookieUtil.ReadCookieMap(req);
    log.info("[UserLoginResponse]-[checkJWT]-入参:{}", JSON.toJSONString(stringCookieMap));
    // 从cookies中取数据
    if (!stringCookieMap.isEmpty()) {
      jwt = stringCookieMap.get("jwt").getValue();
      name = stringCookieMap.get("name").getValue();
      System.out.println("checkJWT 1:" + jwt + "\t" + name);
    } else {
      // 从Header中取数据
      jwt = req.getHeader("Authorization");
      name = req.getHeader("name");
      System.out.println("checkJWT 2:" + jwt + "\t" + name);
    }
    // 获得加密之前的数据
    JWTInfo jwtInfo = JWTUtil.unsign(jwt, JWTInfo.class);
    // 利用name去查询密码
    String checkJWT = UserInfoDao.checkJWT(jwtInfo.getUsername());
    if ((jwtInfo.getPassword()).equals(checkJWT)) {
      return true;
    }
    return false;
  }
}
