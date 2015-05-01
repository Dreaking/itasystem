package com.ita.service;

import java.util.List;

import com.ita.exception.ITAException;
import com.ita.model.Location;
import com.ita.model.Memo;
import com.ita.model.Protector;
import com.ita.model.User;
import com.ita.vo.LocationBean;
import com.ita.vo.MemoBean;
import com.ita.vo.PassBean;
import com.ita.vo.ProtectorBean;
import com.ita.vo.UserBean;
	
public interface UserManager{
	
	//登录失败
	public static final int LOGIN_FAIL = 0;
	//登陆成功
	public static final int LOGIN_SUCC = 1;
	
	public static final int PASS_NOT_SAME = 0;
	public static final int PASS_ERROR = -1;
	public static final int PASS_TRUE = 1;

	/**
	 * 验证登陆
	 * @param user 登陆的用户
	 * @return 登陆结果:0为登陆失败，1为登陆成功
	 */
	int validLogin(User user);
	
	/**
	 * 修改密码
	 * @param pass
	 * @param userEmail
	 * @return
	 * @throws ITAException
	 */
	public int changePass(PassBean pass,String userEmail) 
		throws ITAException;
	
	/**
	 * 获取用户个人信息
	 * @param userEmail
	 * @return
	 */
	UserBean userInfo(String userEmail);
	
	/**
	 * 新增用户
	 * @param emp 新增的用户
	 */
	void addUser(User user)
		throws ITAException;
	
	/**
	 * 更新用户资料
	 * @param user
	 * @param UserEmail
	 * @throws ITAException
	 */
	void updateUser(User user,String UserEmail)
		throws ITAException;
	
	/**
	 * 更换头像
	 * @param userEmail
	 * @throws ITAException
	 */
	void updatePhoto(String userEmail,String photo_path)
		throws ITAException;
	
	/**
	 * 新增用户坐标
	 * @param location
	 * @throws ITAException
	 */
	void addLocation(Location location , String userEmail)
		throws ITAException;
	
	/**
	 * 用户查看自己的作的标记
	 * @param UserName 用户名
	 * @return 用户曾经作的标记
	 */
	List<LocationBean> userLocation(String userEmail);
	
	/**
	 * 用户查看全部的标记
	 * @return 全部危险标记
	 */
	List<LocationBean> allLocation();
	
	/**
	 * 新增备忘
	 * @param memo 
	 * @param userEmail
	 * @throws ITAException
	 */
	void addMemo(Memo memo,String userEmail,String equ)
		throws ITAException;
	
	/**
	 * 用户查看自己的备忘
	 * @param userEmail 用户名
	 * @return 该用户备忘集合
	 */
	List<MemoBean> userMemo(String userEmail);
	
	/**
	 * 更新备忘
	 * @param id
	 * @param userEmail
	 * @throws ITAException
	 */
	void updateMemo(Memo memo,String equ)
		throws ITAException;
	
	/**
	 * 删除备忘
	 * @param memo
	 * @throws ITAException
	 */	
	void deteleMemo(Memo memo,String equ)
		throws ITAException;
	
	/**
	 * 同步备忘
	 * @param userEmail
	 * @return
	 */
	List<MemoBean> SynMemo(String userEmail);
	
	/**
	 * 同步备忘的appid
	 * @param memo
	 * @throws ITAException
	 */
	void SynAppid(Memo memo)
		throws ITAException;
	
	/**
	 * 新增保护者
	 * @param memo 
	 * @param userEmail
	 * @throws ITAException
	 */
	void addProtector(Protector protector,String userEmail)
		throws ITAException;
	
	/**
	 * 用户查看自己的保护者
	 * @param userEmail 用户名
	 * @return 该用户保护者集合
	 */
	List<ProtectorBean> userProtectors(String userEmail);

}