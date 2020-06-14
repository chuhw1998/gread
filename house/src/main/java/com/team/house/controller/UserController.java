package com.team.house.controller;

import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import com.team.house.utils.BaseResult;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user/")
//@CrossOrigin(value = "*",allowCredentials ="true")
public class UserController {
    @Autowired
    private UsersService usersService;
    @RequestMapping("regUser")
    public BaseResult regUser(Users users){
        //调用业务
        int temp=usersService.regUser(users);
        if(temp>0) {
            return new BaseResult(BaseResult.RESULT_SUCCESS, "");
        }else {
            return new BaseResult(BaseResult.RESULT_FAIL, "出错啦!");
        }
    }

    @RequestMapping("regUserLogin")
    public BaseResult regUserLogin(HttpSession session, String username, String password){
        Users users = usersService.LoginUsers(username, password);
        if (users==null){
            return new BaseResult(BaseResult.RESULT_FAIL,"用户名密码不正确");

        }else {
            //只要登入请使用session保存登入人的信息
            session.setAttribute("logininfo",users);
            session.setMaxInactiveInterval(60000); //10分钟
            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        }
    }
}