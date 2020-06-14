package com.team.house.service;


import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.utils.HouseCondition;
import com.team.house.utils.PageParmeter;

public interface HouseService {
    //发布出租房
    public int addHouse(House house);

    //查询某用户下的出租房
    public PageInfo<House>  getHouseByUser(Integer userid, PageParmeter pageParmeter);

    //删除出租房
    public int deleteHouse(String id, Integer delState);

    //带有条件的查询
    public PageInfo<House> getBroswerHouse(HouseCondition houseCondition);
}
