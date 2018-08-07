package com.sxt.service;


import com.sxt.dao.Mmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service("mservice")
@Transactional
public class MserviceImpl implements Mservice {
    @Autowired(required=true)
    Mmapper mapper;


    public List list() {

        //ArrayList<Object> list = new ArrayList<>();
        List list = mapper.list();
        return list;
    }
}
