package cn.spirithone.blog.oauth.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.spirithone.blog.oauth.dao.UserDao;
import cn.spirithone.blog.oauth.dao.UserInfoDao;
import cn.spirithone.blog.oauth.mapper.UserMapper;
import cn.spirithone.blog.oauth.model.Identity;
import cn.spirithone.blog.oauth.model.User;
import cn.spirithone.blog.oauth.model.UserInfo;
import cn.spirithone.blog.oauth.security.shiro.credentials.PasswordService;
import cn.spirithone.blog.oauth.service.UserService;



@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Resource
	private UserMapper userMapper;
	@Resource
	private UserInfoDao userInfoDao;
	@Resource
	private PasswordService passwordService;
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	public static String[] numbers = new String[] {"0", "1", "2", "3", "4", "5",  
			"6", "7", "8", "9"};
	@Override
	public User getByUsername(String username) {
		User user = userDao.getByUsername(username);
		//user.setInfo(getInfo(user.getUid()));
		return user;
	}
	
	protected UserInfo getInfo(Long uid){
		return userInfoDao.getByUid(uid);
	}

	@Override
	public User getByUid(Long uid) {
		User user = userDao.getByUid(uid);
		user.setInfo(getInfo(uid));
		return user;
	}

	@Override
	public User getByEmail(String email) {
		User user = userDao.getByEmail(email);
		//user.setInfo(getInfo(user.getUid()));
		return user;
	}

	@Override
	public User getByMobile(Long mobile) {
		User user = userDao.getByMobile(mobile);
		//user.setInfo(getInfo(user.getUid()));
		return user;
	}

	@Override
	public User findUser(String principal) {
		User user = null;
		Map<String, Object> params = new HashMap<>();
		params.put("username", principal);
		params.put("email", principal);
		Long longPrincipal = NumberUtils.toLong(principal);
		if(longPrincipal != null){
			params.put("uid", longPrincipal);
			params.put("mobile", longPrincipal);
		}
		user = userMapper.findUser(params);
		if(user != null){
			user.setInfo(getInfo(user.getUid()));
		}
		return user;
	}
	
	@Override
	public boolean saveUser(User user) {
		if(user == null)
			return false;
		
		UserInfo info = user.getInfo();
		if(info == null)
			info = new UserInfo();
		Long uid = generateUid();
		info.setUid(uid);
		user.setUid(uid);
		user.setLocked(false);
		userInfoDao.save(info);
		userDao.save(user);
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		userInfoDao.update(user.getInfo());
		userDao.update(user);
		return true;
	}

	@Override
	public boolean updateUserInfo(UserInfo userInfo) {
		userInfoDao.update(userInfo);
		return true;
	}

	@Override
	public boolean deleteUser(Long uid) {
		userInfoDao.deleteByUid(uid);
		userDao.deleteByUid(uid);
		return true;
	}

	@Override
	public Long generateUid() {
		StringBuffer buffer = new StringBuffer();
		Long uid = null;
	    while(uid == null){
	    	buffer = new StringBuffer();
		    String uuid = UUID.randomUUID().toString().replace("-", "");  
		    for (int i = 0; i < 8; i++) {  
		        String str = uuid.substring(i * 4, i * 4 + 4);  
		        int x = Integer.parseInt(str, 16);  
		        buffer.append(numbers[x % 10]);
		    }
		    
		    //获取到uid
		    uid = Long.parseLong(buffer.toString());
		    //查询数据库看是否存在该uid的用户
		    //当存在该uid的用户 或者生成的 uid首位为0 转换成long后不足七位的，重新生成uid
		    if(isExistUid(uid) || buffer.charAt(0) == '0'){
		    	uid = null;
		    }
	    }
	    return uid;
	}
	/**
	 * 判断是否存在uid的用户
	 * @param uid
	 * @return
	 */
	@Override
	public Boolean isExistUid(Long uid){
		User user = userDao.getByUid(uid);
		return user == null ? false : true;
	}
	@Override
	public Boolean isExistUsername(String username) {
		User user = userDao.getByUsername(username);
		if(user != null)
			return true;
		else
			return false;
	}

	@Override
	public Boolean isExistEmail(String email) {
		User user = userDao.getByEmail(email);
		if(user != null)
			return true;
		else 
			return false;
	}

	@Override
	public Boolean registerUser(Map<String, Object> params) {
		if(params == null || params.isEmpty())
			return false;
		String username = params.get("username").toString();
		String password = params.get("password").toString();
		String email = params.get("email").toString();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setIdentity(Identity.user);
		user = passwordService.encryptPassword(user);
		return saveUser(user);
	}

}
