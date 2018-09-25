package com.art.controller;
import com.alibaba.fastjson.JSON;
import com.art.bean.request.UserLoginRequest;
import com.art.bean.response.UserLoginResponse;
import com.art.common.CookieUtil;
import com.art.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

import static com.art.common.MD5Util.toMd5;

/**
 * @Description TODO
 * @Author art
 * @Date 2018/7/12 16:30
 * @Version 1.0
 */
@Controller
public class UserController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserService userServivce;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String login(HttpServletResponse res, HttpServletRequest req, UserLoginRequest request) {
        request.setPwd(toMd5(request.getPwd()));
        log.info("[UserInfoController] - [login] 入参-> "+request.toString());
        UserLoginResponse login = userServivce.login(request);
        log.info("[UserInfoController] - [login] 出参-> "+login.toString());
    // 放置cookies
    Map<String,String> map = new HashMap<String, String>();
    map.put("jwt",login.getJwt());
    map.put("name",login.getName());
    CookieUtil.addCookieMap(res,map);
        return JSON.toJSONString(login);
    }
    

}