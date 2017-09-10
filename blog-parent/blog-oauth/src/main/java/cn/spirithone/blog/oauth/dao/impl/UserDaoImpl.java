package cn.spirithone.blog.oauth.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import cn.spirithone.blog.core.hibernate.dao.impl.Hibernate5DaoImpl;
import cn.spirithone.blog.oauth.dao.UserDao;
import cn.spirithone.blog.oauth.model.User;

@Repository
public class UserDaoImpl extends Hibernate5DaoImpl<User> implements UserDao {
	private static Log logger = LogFactory.getLog(UserDaoImpl.class);

	public User get(Long id) {
		return super.get(User.class, id);
	}

	public void delete(Long id) {
		super.delete(User.class, id);
	}

	public List<User> getAll() {
		return super.getAll(User.class);
	}

	@SuppressWarnings("deprecation")
	@Override
	public User getByUid(Long uid) {
		String hql = "select u from " + User.class.getSimpleName() + " u where u.uid = ?";
		return (User) getSession().createQuery(hql).setParameter(0, uid).uniqueResult();
	}

	@SuppressWarnings("deprecation")
	@Override
	public User getByUsername(String username) {
		String hql = "select u from " + User.class.getSimpleName() + " u where u.username = ?";
		return (User) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
	}

	@SuppressWarnings("deprecation")
	@Override
	public User getByEmail(String email) {
		String hql = "select u from " + User.class.getSimpleName() + " u where u.email = ?";
		return (User) getSession().createQuery(hql).setParameter(0, email).uniqueResult();
	}

	@SuppressWarnings("deprecation")
	@Override
	public User getByMobile(Long mobile) {
		String hql = "select u from " + User.class.getSimpleName() + " u where u.mobile = ?";
		return (User) getSession().createQuery(hql).setParameter(0, mobile).uniqueResult();
	}

	@Override
	public void deleteByUid(Long uid) {
		String hql = "delete from " + User.class.getSimpleName() + " where uid = ?";
		getSession().createQuery(hql).setParameter(0, uid).executeUpdate();
	}
}
