package com.team.house.controller;

import com.team.house.entity.Street;
import com.team.house.service.StreetService;
import com.team.house.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/street/")
public class StreetController {
    @Autowired
    private StreetService streetService;
    //请求接收区域编号查询相应的街道
    @RequestMapping("getStreetData")
    public BaseResult getStreetData(int did){
        List<Street> list = streetService.getStreetByDid(did);
        return new BaseResult(200,list);
    }

}
