package com.wangxianchao.vip.web.handler;

import org.springframework.stereotype.Controller;

/**
 * @Description TODO
 * @Author wangxianchao
 * @Date 2018/7/12 16:30
 * @Version 1.0
 */
@Controller("/login.do")
public class LoginHandler {
    public String login(String accment , String password){
        System.out.print("------------");
        return "login";
    }
}