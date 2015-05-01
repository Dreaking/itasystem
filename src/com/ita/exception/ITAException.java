package com.ita.exception;

public class ITAException extends Exception{
	
	//无参数构造器
	public ITAException(){		
	};
	
	//super参数给Exception父类
	public ITAException(String emp){
		super(emp);		
	}
}