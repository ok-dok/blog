package cn.spirithone.blog.oauth.dao;

import java.util.List;

import cn.spirithone.blog.core.hibernate.dao.BaseHibernateDao;
import cn.spirithone.blog.oauth.model.User;

public interface UserDao extends BaseHibernateDao<User> {
	/**
	 * 根据id获取用户对象
	 * 
	 * @param id
	 * @return 查询到的用户对象
	 */
	User get(Long id);

	/**
	 * 根据id删除用户实例
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * 通过uid（用户id）删除用户信息
	 * 
	 * @param uid
	 */
	void deleteByUid(Long uid);

	/**
	 * 获取所有用户
	 * 
	 * @return
	 */
	List<User> getAll();

	/**
	 * 通过用户id获取用户实例
	 * 
	 * @param uid
	 * @return
	 */
	User getByUid(Long uid);

	/**
	 * 通过用户名获取用户实例
	 * 
	 * @param username
	 * @return
	 */
	User getByUsername(String username);

	/**
	 * 通过绑定的邮箱获取用户实例
	 * 
	 * @param email
	 * @return
	 */
	User getByEmail(String email);

	/**
	 * 通过绑定的手机号获取用户实例
	 * 
	 * @param mobile
	 * @return
	 */
	User getByMobile(Long mobile);
}
