package com.art.controller;
import com.art.entity.UserEntity;
import com.art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description TODO
 * @Author art
 * @Date 2018/7/12 16:30
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
//这里用了@SessionAttributes，可以直接把model中的user(也就key)放入其中
//这样保证了session中存在user这个对象
@SessionAttributes("user")
public class UserController {
    @Autowired
    UserService userServivce;

    //表单提交过来的路径
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public String checkLogin(UserEntity userEntity, Model model){
        //调用service方法
        try {
            userEntity = userServivce.checkLogin(userEntity.getUsername(), userEntity.getPassword());
            //若有user则添加到model里并且跳转到成功页面
            if(userEntity != null){
                model.addAttribute("user",userEntity);
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "fail";
    }

    //测试超链接跳转到另一个页面是否可以取到session值
    @RequestMapping("/anotherpage")
    public String hrefpage(){

        return "anotherpage";
    }

    //注销方法
    @RequestMapping("/outLogin")
    public String outLogin(HttpSession session){
        //通过session.invalidata()方法来注销当前的session
        session.invalidate();
        return "login";
    }
}