package com.ita.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ita.model.User;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class InputValidation{
	
	//登陆信息检验
	public static int LoginValidation(User user){
		String PassPatternString = "(\\w{4,25})";
		String EmailPatternString = "^[a-z0-9]+([._\\\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";
		
		Pattern PassPattern = Pattern.compile(PassPatternString);
		Pattern EmailPattern = Pattern.compile(EmailPatternString);

		Matcher EmailMatcher = EmailPattern.matcher(user.getEmail());
		Matcher PassMatcher = PassPattern.matcher(user.getPass());

		if (EmailMatcher.matches()&&PassMatcher.matches())
			return 1;
		else {
			return 0;
		}
	}
	
	//注册信息检验
	public static String RegisterValidation(User user){
		
		String tip="ok";
		String PassPatternString = "(\\w{4,25})";
		String EmailPatternString = "^[a-z0-9]+([._\\\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";
		String phonePatternString = "(1[0-9]{10})";
		
		Pattern PassPattern = Pattern.compile(PassPatternString);
		Pattern EmailPattern = Pattern.compile(EmailPatternString);
		Pattern PhonePattern = Pattern.compile(phonePatternString);
		
		Matcher EmailMatcher = EmailPattern.matcher(user.getEmail());
		Matcher PassMatcher = PassPattern.matcher(user.getPass());
		Matcher PhoneMatcher = PhonePattern.matcher(user.getPhone());
		
		if(!(EmailMatcher.matches()))
			tip = "emailERROR";
		else if(!(PassMatcher.matches()))
			tip = "passERROR";
		else if(!(PhoneMatcher.matches()))
			tip = "phoneERROR";
		else if(user.getName().length()>=8||user.getName().length()<3)
			tip = "nameERROR";
		return tip;
	}
}