package com.ita.junit;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;













import org.hibernate.type.descriptor.java.UrlTypeDescriptor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ita.action.LoginAction;
import com.ita.model.User;
import com.ita.util.Http;
import com.ita.util.HttpSender;
import com.ita.util.InputValidation;
import com.ita.vo.LocationBean;
import com.sun.org.apache.bcel.internal.generic.NEW;



/**
*
* @author bean
*/

public class TextUnit extends TestCase{
	    
	      public TextUnit() {
	      }

	      @Before
	      public void setUp() throws Exception {
	      }

	      @After
	      public void tearDown() throws Exception {
	      }
	      
	      @Test
	      public void testLogin()throws Exception{
	    	  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml","daoContext.xml");
	    	  LoginAction la =(LoginAction)ctx.getBean("loginAction");

	      }
	      
	      @Test
	      public void testHttpSender()throws Exception{
	    	  String url="http://yuntuapi.amap.com/datamanage/data/create";
	    	  String urltext="http://120.24.235.6:8080/ITAsystem/Login.action";
	    	  String key="ad03a4e29aa6bfd86da23eecaa9becfe";
	    	  String tableid="54cf93b1e4b0596767e08450";
	    	  String loctype="1";
	    	  String data="{\"_name\":\"test\",\"_location\":\"104.394729,31.125698\"}";
	    	  
	    	  //String sr=HttpSender.sendPost(urltext, uNp);
	    	  //System.out.println(sr);
	    	  
	    	  Map<String,String> params=new HashMap<String,String>();
	    	  //params.put("user.email","123");
	    	  //params.put("user.pass","123" );
	    	  params.put("key", key);
	    	  params.put("tableid", tableid);
	    	  params.put("loctype", loctype);
	    	  params.put("data", data);

	    	  
	    	  String string=Http.Httptext(url,params);
	    	  System.out.println(string);
	      }
	      
	      @Test
	      public void testPattern()throws Exception{
	    	  String result;
	    	  User user =new User();
	    	  user.setEmail("123@123.com");
	    	  user.setPass("10sdf0");
	    	  user.setPhone("18813754606");
	    	  user.setName("1235");
	    	  result=InputValidation.RegisterValidation(user);
	    	  System.out.println(result);
	      }

	      @Test
	      public void testAddLocation()throws Exception{
	    	  String url ="http://localhost:8080/ITAsystem/Login.action";
	    	  Map<String,String> params=new HashMap<String,String>();
	    	  params.put("user.email", "456");
	    	  params.put("user.pass", "456");
	    	  
	    	  String string=Http.Httptext(url,params);
	    	  System.out.println(string);
	      }
	      
	      @Test
	      public void testAddMemo()throws Exception{
	    	  String urlString="http://localhost:6253/ITAsystem/AddMemo.action";
	    	  Map<String,String> params =new HashMap<String,String>();
	    	  params.put("memo.place", "test");
	    	  params.put("memo.thing", "test");
	    	  params.put("memo.time", "test");
	    	  
	    	  String result =Http.Httptext(urlString, params);
	    	  System.out.println(result);
	      }
	      
	      @Test
	      public void testSubstring()throws Exception{
	    	  
	    	  String userEmail = "295660782@qq.com";
	    	  userEmail=userEmail.substring(0, userEmail.length()-4);
	    	  System.out.println(userEmail);
	      }
}
