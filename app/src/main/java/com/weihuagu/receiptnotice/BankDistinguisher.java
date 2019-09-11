package com.weihuagu.receiptnotice;
import android.app.Notification;

import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Stack;


public class BankDistinguisher{
        public BankDistinguisher(){
        }
        public String distinguishByNum(String num){
                Map <String, String> map=ExternalInfoUtil.getBanksMessageNum();
                String whatsback=map.get(num);
                if(whatsback!=null)
                        return whatsback;
                else
                        return "";

        }

        public String distinguishByMessageContent(String content){
                if(content.contains("银行")&&ExternalInfoUtil.containsBankmessageFeature(content))
                {
                        Stack<String> alternativebank = new Stack<String>();
                        Map <String,String> map=ExternalInfoUtil.getAllBanksNameMap();
                        for (String key : map.keySet()) {
                                if(content.contains(key))
                                        alternativebank.push(key);
                        }
                        if(alternativebank.isEmpty())
                                return "";
                        else
                                return map.get(alternativebank.peek());
                }
                else
                        return null;



        }














}

