package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.mapper.HouseMapper;
import com.team.house.service.HouseService;
import com.team.house.utils.HouseCondition;
import com.team.house.utils.PageParmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired(required = false)
    private HouseMapper houseMapper;
    //发布出租房
    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    //查询某用户下的出租房
    @Override
    public PageInfo<House> getHouseByUser(Integer userid, PageParmeter pageParmeter) {
        //开启分页
        PageHelper.startPage(pageParmeter.getPage(),pageParmeter.getPageSize());
        //查询所有信息
        List<House> list = this.houseMapper.getHouseByUser(userid);
        return new PageInfo<House>(list);
    }

    //删除出租房
    @Override
    public int deleteHouse(String id, Integer delState) {
        House house= new House();
        house.setId(id);
        house.setIsdel(delState);//删除状态
        return this.houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getBroswerHouse(HouseCondition houseCondition) {
        //开启分页
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getPageSize());
        //查询所有信息
        List<House> list = this.houseMapper.browserHouse(houseCondition);
        return new PageInfo<House>(list);
    }
}
