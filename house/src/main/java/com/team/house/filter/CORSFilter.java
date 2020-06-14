package com.team.house.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author
 * @Classname ${NAME}
 * @Description TODO
 * 注意: 如果是在springboot工程中创建过滤器(使用注解的方式).需要在启动类上添加扫描servlet或者filter注解的配置
 * @ServletComponentScan(basePackages = {"com.example.demo.filter"})
 * com.example.demo.filter这个就存放过滤器的包
 */
@WebFilter(filterName = "CORSFilter", urlPatterns ="/*")
public class CORSFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain  chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setHeader("Access-Control-Allow-Origin", "null"); //支持跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");  //支持session异步请求，共享session
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, X-Token");
        chain.doFilter(req, resp);  //放行
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
