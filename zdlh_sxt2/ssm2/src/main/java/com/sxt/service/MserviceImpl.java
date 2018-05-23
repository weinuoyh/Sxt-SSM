package com.sxt.service;


import com.sxt.dao.Mmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MserviceImpl implements Mservice {
	@Autowired
    Mmapper mapper;


public List list() {
	List list=mapper.list();
	return list;
}
}
