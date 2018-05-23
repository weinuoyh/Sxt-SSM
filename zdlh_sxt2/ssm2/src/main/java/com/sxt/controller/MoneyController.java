package com.sxt.controller;


import com.pycredit.test.services.WebServiceSingleQuery.WebServiceSingleQuery;
import com.pycredit.test.services.WebServiceSingleQuery.WebServiceSingleQuerySoapBindingStub;
import com.sxt.service.Mservice;
//import org.apache.axis.AxisFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.RemoteException;
import java.util.List;

@Controller
@RequestMapping("money")
public class MoneyController {
@Autowired
Mservice service;

@RequestMapping("list")
public String list(ModelMap map,HttpServletRequest request, HttpServletResponse response){
	String userId="";
	String password="";
	String cc="";
//	WebServiceSingleQuery webServiceSingleQuery = null;

//	try {
//		webServiceSingleQuery = new WebServiceSingleQuerySoapBindingStub();
//		webServiceSingleQuery.queryReport(userId,password,cc);
//	} catch (AxisFault axisFault) {
//		axisFault.printStackTrace();
//	} catch (RemoteException e) {
//		e.printStackTrace();
//	}


	List list=service.list();
	map.put("list", list);
	request.getSession().setAttribute("username","hfdhfjd");
	Object username = request.getSession().getAttribute("username");
System.out.println("dsdhjshdj");
	return "list";
}

}
