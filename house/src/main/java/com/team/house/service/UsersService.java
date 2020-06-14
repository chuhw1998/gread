package com.team.house.service;


import com.team.house.entity.Users;

public interface UsersService {
   //注册
    public int regUser(Users user);

    //登陆
    public Users LoginUsers(String username,String password);
}
