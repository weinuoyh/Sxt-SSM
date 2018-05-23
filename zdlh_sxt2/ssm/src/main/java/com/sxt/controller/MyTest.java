package com.sxt.controller;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;

import java.util.Random;

/**
 * Created by shaxueting on 2017/11/29.
 */
public class MyTest {
    public static void main(String[] args) {

        String pageName="";
        String ServerIp="";
        double amount=0;

        Transaction t = Cat.newTransaction("sxt", "sxt.method");

        Cat.logEvent("Method_test1", "good1");
        Cat.logEvent("Method_event1", "bad1");

        int nextInt = new Random().nextInt(3);

        if (nextInt % 2 == 0) {
            t.setStatus(Transaction.SUCCESS);
        } else {
            t.setStatus(String.valueOf(nextInt));
        }

        t.complete();
    }
}
