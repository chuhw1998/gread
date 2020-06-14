package com.team.house.service.impl;


import com.team.house.entity.Users;
import com.team.house.entity.UsersExample;
import com.team.house.mapper.UsersMapper;
import com.team.house.service.UsersService;
import com.team.house.utils.MD5Utils;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UsersService {
    @Autowired(required = false)
    private UsersMapper usersMapper;
    @Override
    public int regUser(Users user) {
        //密码不要以明文方式保存到数据中，这样做不安全
        //使用md5工具类对密码进行加密后存储到数据库
        //使用步骤:1.导入md5工具类  2.调用md5工具类的方法进行加密
        user.setPassword(MD5Utils.md5Encrypt(user.getPassword()));
        return  usersMapper.insertSelective(user);
    }

    @Override
    public Users LoginUsers(String username, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria=usersExample.createCriteria();
        //添加条件
        criteria.andNameEqualTo(username);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> list=usersMapper.selectByExample(usersExample);
        if(list!=null&&list.size()==1){
            return list.get(0);
        }
        else
            return null;
    }

}
