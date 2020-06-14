package com.team.house.controller;

import com.team.house.entity.District;
import com.team.house.service.DistrictService;
import com.team.house.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/district/")
public class DistrictController {
    @Autowired(required = false)
    private DistrictService districtService;

    @RequestMapping("getDistrictData")
    public BaseResult getDistrictData(){
        List<District> list=districtService.getAllDistrict();
        return new BaseResult(200,list);
    }
}
