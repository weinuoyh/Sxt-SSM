package com.sxt.controller;

//
//import com.pycredit.test.services.WebServiceSingleQuery.WebServiceSingleQuery;
//import com.pycredit.test.services.WebServiceSingleQuery.WebServiceSingleQuerySoapBindingStub;
import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
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
import java.util.Random;

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

	Transaction t = Cat.newTransaction("sxt2222", "sxt22222.method");
	List list=service.list();
	map.put("list", list);
	request.getSession().setAttribute("username","hfdhfjd");
	Object username = request.getSession().getAttribute("username");


	Cat.logEvent("Method_test1", "good1");
	Cat.logEvent("Method_event1", "bad1");

	int nextInt = new Random().nextInt(3);

	if (nextInt % 2 == 0) {
		t.setStatus(Transaction.SUCCESS);
	} else {
		t.setStatus(String.valueOf(nextInt));
	}

	t.complete();
System.out.println("dsdhjshdj");
	return "list";
}

}
