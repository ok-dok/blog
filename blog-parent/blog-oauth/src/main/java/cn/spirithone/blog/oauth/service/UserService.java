package cn.spirithone.blog.oauth.service;

import java.util.Map;

import cn.spirithone.blog.oauth.model.User;
import cn.spirithone.blog.oauth.model.UserInfo;

public interface UserService {
	/**
	 * 通过用户id获取用户
	 * 
	 * @param uid
	 * @return
	 */
	User getByUid(Long uid);

	/**
	 * 通过用户名获取用户信息
	 * 
	 * @param username
	 * @return
	 */
	User getByUsername(String username);

	/**
	 * 通过绑定的email获取用户
	 * 
	 * @param email
	 * @return
	 */
	User getByEmail(String email);

	/**
	 * 通过绑定的手机号获取用户
	 * 
	 * @param mobile
	 * @return
	 */
	User getByMobile(Long mobile);

	/**
	 * 通过主要身份查找用户,身份包括:username, mobile, email, uid
	 * 
	 * @param principal
	 *            参数可以是username/email/uid/mobile
	 * @return
	 */
	User findUser(String principal);

	/**
	 * 保存用户信息，包括user中的userInfo对象也会保存
	 * 
	 * @param user
	 * @return
	 */
	boolean saveUser(User user);

	/**
	 * 更新用户信息，包括user中的userInfo对象
	 * 
	 * @param user
	 * @return
	 */
	boolean updateUser(User user);

	/**
	 * 更新用户信息，仅更新userInfo
	 * 
	 * @param userInfo
	 * @return
	 */
	boolean updateUserInfo(UserInfo userInfo);

	/**
	 * 通过uid（用户id）删除用户信息，包括userInfo
	 * 
	 * @param uid
	 * @return
	 */
	boolean deleteUser(Long uid);

	/**
	 * 使用UUID，通过相关运算来生成8位数字用户唯一标识id
	 * 
	 * @param id
	 * @return
	 */
	Long generateUid();

	/**
	 * 判断给定用户名是否已存在
	 * 
	 * @param username
	 * @return 如果存在返回true，否则返回false
	 */
	Boolean isExistUsername(String username);

	/**
	 * 判断给定邮箱是否已存在
	 * 
	 * @param email
	 * @return
	 */
	Boolean isExistEmail(String email);

	/**
	 * 注册用户
	 * 
	 * @param params
	 * @return 注册成功返回true，失败返回false
	 */
	Boolean registerUser(Map<String, Object> params);

	/**
	 * 判断是否存在uid的用户
	 * 
	 * @param uid
	 * @return
	 */
	Boolean isExistUid(Long uid);
}
