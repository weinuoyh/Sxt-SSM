package com.sxt.controller;


import com.sxt.service.Mservice;
import com.sxt.utils.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("money")
public class MoneyController {
    @Autowired
    Mservice mservice;

    @RequestMapping("list")
    public String list(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
       // Mservice mservice = (Mservice) SpringContextUtil.getBean("mservice");
        List list = mservice.list();
        map.put("list", list);
        request.getSession().setAttribute("username", "hfdhfjd");
        Object username = request.getSession().getAttribute("username");

        System.out.println("dsdhjshdj");
        return "list";
    }

}
