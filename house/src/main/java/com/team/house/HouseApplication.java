package com.team.house;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//添加扫描mybatis的dao层接口，生成实现类
@MapperScan(value = "com.team.house.mapper")
@ServletComponentScan(basePackages = "com.team.house.filter")
public class HouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseApplication.class, args);
    }

}
