package com.ita.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ita.dao.LocationDao;
import com.ita.dao.MemoDao;
import com.ita.dao.ProtectorDao;
import com.ita.dao.UserDao;
import com.ita.exception.ITAException;
import com.ita.model.Location;
import com.ita.model.Memo;
import com.ita.model.Protector;
import com.ita.model.User;
import com.ita.service.UserManager;
import com.ita.vo.LocationBean;
import com.ita.vo.MemoBean;
import com.ita.vo.PassBean;
import com.ita.vo.ProtectorBean;
import com.ita.vo.UserBean;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class UserManagerImpl
	implements UserManager{
	
	private UserDao userDao;
	private LocationDao locationDao;
	private MemoDao memoDao;
	private ProtectorDao protectorDao;
	
	//UserDao的getter和setter方法
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//Location的getter和setter方法
	public LocationDao getLocationDao() {
		return locationDao;
	}
	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}
	
	//Memo的getter和setter方法
	public MemoDao getMemoDao() {
		return memoDao;
	}
	public void setMemoDao(MemoDao memoDao) {
		this.memoDao = memoDao;
	}
	
	//Protector的getter和setter方法
	public ProtectorDao getProtectorDao() {
		return protectorDao;
	}
	public void setProtectorDao(ProtectorDao protectorDao) {
		this.protectorDao = protectorDao;
	}
	
//--------------------------------------------------------------------------------------------
	
	
	/**
	 * 验证登陆
	 */
	@Override
	public int validLogin(User user) {
		// TODO Auto-generated method stub
		if(userDao.findByEmailAndPass(user).size()>=1)
			return LOGIN_SUCC;
		else
			return LOGIN_FAIL;
	}
	
	/**
	 * 获取用户信息
	 */
	@Override
	public UserBean userInfo(String userEmail) {
		// TODO Auto-generated method stub
		User user=userDao.findByEmail(userEmail);
		UserBean userBean=new UserBean(user.getName(), user.getAddress(), user.getPhone(), user.getImage());
		return userBean;
	}
	
	/**
	 * 修改密码
	 * @param pass
	 * @param userEmail
	 * @return
	 * @throws ITAException
	 */
	public int changePass(PassBean pass,String userEmail) throws ITAException{
		if(!(pass.getNew1().equals(pass.getNew2())))
			return PASS_NOT_SAME;
		else{
			User user=userDao.findByEmail(userEmail);
			if(!(pass.getOld().equals(user.getPass())))
				return PASS_ERROR;
			else{
				user.setPass(pass.getNew1());
				return PASS_TRUE;
			}
		}
		
		
	}
	/**
	 * 更新用户资料
	 */
	@Override
	public void updateUser(User user, String UserEmail) throws ITAException {
		// TODO Auto-generated method stub
		User user_temp=userDao.findByEmail(UserEmail);
		user_temp.setAddress(user.getAddress());
		user_temp.setName(user.getName());
		user_temp.setPhone(user.getPhone());
		userDao.update(user_temp);
	}
	
	
	
	/**
	 * 更新头像
	 */
	@Override
	public void updatePhoto(String userEmail,String photo_path) throws ITAException {
		// TODO Auto-generated method stub
		User user=userDao.findByEmail(userEmail);
		user.setImage(photo_path);
		userDao.update(user);
	}
	
	
	/**
	 * 新增用户
	 */
	@Override
	public void addUser(User user) throws ITAException {
		// TODO Auto-generated method stub
		userDao.save(user);
	}
	
	
//-----------------------------------------------------------------------------------------\
	/**
	 * 用户查看自己的作的标记
	 */
	@Override
	public List<LocationBean> userLocation(String UserEmail) {
		// TODO Auto-generated method stub
		
		User user=userDao.findByEmail(UserEmail);
		List<Location> locations=locationDao.findByUser(user);
		List<LocationBean> result=new ArrayList<LocationBean>();
		//封装VO集合
		for(Location l : locations){
			result.add(new LocationBean(l.getLongitude(),l.getLatitude()));
		}
		return result;
	}
	

	
	/**
	 * 新增用户坐标
	 */
	@Override
	public void addLocation(Location location,String userEmail) throws ITAException {
		// TODO Auto-generated method stub
		User user = userDao.findByEmail(userEmail);
		if(user==null){
			throw new ITAException("新增坐标异常，用户不存在，请重新登陆");
		}
		location.setUser(user);
		locationDao.save(location);
	}
	
	/**
	 * 查看全部标记
	 */
	@Override
	public List<LocationBean> allLocation() {
		// TODO Auto-generated method stub
		List<Location> locations =locationDao.findAll();
		//封装VO
		List<LocationBean> result= new ArrayList<LocationBean>();
		for(Location l : locations){
			result.add(new LocationBean(l.getLongitude(),l.getLatitude()));
		}
		return result;
	}
//----------------------------------------------------------------------------
	/**
	 * 新增备忘
	 */
	public void addMemo(Memo memo,String userEmail,String equ)throws ITAException{
		User user = userDao.findByEmail(userEmail);
		if(user==null){
			throw new ITAException("新增备忘，用户不存在，请重新登陆");
		}
		else{
			if(equ.equals("web"))
				memo.setSyn(0);
			else if(equ.equals("app")){
				memo.setSyn(1);
			}
			memo.setUser(user);
			memoDao.save(memo);
		}

		
	}
	
	/**
	 * 更改备忘
	 */
	@Override
	public void updateMemo( Memo new_memo,String equ) throws ITAException {
		// TODO Auto-generated method stub
		Memo memo = memoDao.get(new_memo.getId());
		memo.setPlace(new_memo.getPlace());
		memo.setThing(new_memo.getThing());
		memo.setTime(new_memo.getTime());
		memo.setTitle(new_memo.getTitle());
		if(equ.equals("web"))
			memo.setSyn(0);
		else if(equ.equals("app"))
			memo.setSyn(1);
		else 
			throw new ITAException("request error");
		memoDao.update(memo);
	}
	
	/**
	 * 删除备忘
	 */
	@Override
	public void deteleMemo(Memo old_memo, String equ) throws ITAException {
		// TODO Auto-generated method stub
		Memo memo = memoDao.get(old_memo.getId());
		if(equ.equals("web")){
			memo.setSyn(-1);
			memoDao.update(memo);
		}
		else if(equ.equals("app"))
			memoDao.detele(memo);
		else 
			throw new ITAException("request error");
		
	}
	
	/**
	 * 同步备忘
	 */
	@Override
	public List<MemoBean> SynMemo(String userEmail) {
		// TODO Auto-generated method stub
		User user = userDao.findByEmail(userEmail);
		List<Memo> memos = memoDao.findByUserAndSyn(user);
		List<MemoBean> result = new ArrayList<MemoBean>();
		for(Memo m:memos){
			result.add(new MemoBean(m.getId(), m.getAppid(), m.getPlace(), m.getThing(), m.getTime(), m.getSyn(), m.getTitle()));
		}
		//修改同步标签
		for(Memo m:memos){
			Memo memo_temp=memoDao.get(m.getId());
			memo_temp.setSyn(1);
			memoDao.update(memo_temp);
		}
		return result;
	}
	
	/**
	 * 同步备忘appid
	 */
	@Override
	public void SynAppid(Memo memo) throws ITAException {
		// TODO Auto-generated method stub
		Memo memo_temp=memoDao.get(memo.getId());
		memo_temp.setAppid(memo.getAppid());
		memoDao.update(memo_temp);
	}
	
	
	/**
	 * 查看备忘
	 */
	@Override
	public List<MemoBean> userMemo(String userEmail) {
		// TODO Auto-generated method stub
		User user = userDao.findByEmail(userEmail);
		List<Memo> memos = memoDao.findByUser(user);
		List<MemoBean> result = new ArrayList<MemoBean>();
		for(Memo m:memos){
			result.add(new MemoBean(m.getId(), m.getAppid(), m.getPlace(), m.getThing(), m.getThing(), m.getSyn(), m.getTitle()));
		}
		return result;
	}

	
	
//-----------------------------------------------------------------------------------------	
	
	/**
	 * 增加守护者
	 */
	@Override
	public void addProtector(Protector protector, String userEmail)
			throws ITAException {
		// TODO Auto-generated method stub
		User user=userDao.findByEmail(userEmail);
		if(user==null){
			throw new ITAException("新增保护者，用户不存在，请重新登陆");
			
		}
		protector.setUser(user);
		protectorDao.save(protector);
	}
	
	/**
	 * 查看守护者
	 */
	@Override
	public List<ProtectorBean> userProtectors(String userEmail) {
		// TODO Auto-generated method stub
		User user =userDao.findByEmail(userEmail);
		List<Protector> protectors =protectorDao.findByUser(user);
		List<ProtectorBean> result =new ArrayList<ProtectorBean>();
		for(Protector p:protectors){
			result.add(new ProtectorBean(p.getPhone(), p.getName()));
		}
		return result;
	}







}