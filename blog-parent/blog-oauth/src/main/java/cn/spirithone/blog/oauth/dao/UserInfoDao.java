package cn.spirithone.blog.oauth.dao;

import java.util.List;

import cn.spirithone.blog.core.hibernate.dao.BaseHibernateDao;
import cn.spirithone.blog.oauth.model.UserInfo;

public interface UserInfoDao extends BaseHibernateDao<UserInfo> {
	/**
	 * 通过主键id获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	UserInfo get(Long id);

	/**
	 * 通过用户id获取用户信息
	 * 
	 * @param uid
	 * @return
	 */
	UserInfo getByUid(Long uid);

	/**
	 * 通过id删除用户信息
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * 通过用户id删除用户信息
	 * 
	 * @param uid
	 */
	void deleteByUid(Long uid);

	/**
	 * 获取所有用户信息
	 * 
	 * @return
	 */
	List<UserInfo> getAll();
}
