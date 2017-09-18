package cn.spirithone.blog.oauth.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import cn.spirithone.blog.core.hibernate.dao.impl.Hibernate5DaoImpl;
import cn.spirithone.blog.oauth.dao.UserInfoDao;
import cn.spirithone.blog.oauth.model.UserInfo;

@Repository
public class UserInfoDaoImpl extends Hibernate5DaoImpl<UserInfo> implements UserInfoDao {
	private static Log logger = LogFactory.getLog(UserInfoDaoImpl.class);

	@Override
	public UserInfo get(Long id) {
		return super.get(UserInfo.class, id);
	}

	@Override
	public void delete(Long id) {
		super.delete(UserInfo.class, id);
	}

	@Override
	public List<UserInfo> getAll() {
		return super.getAll(UserInfo.class);
	}

	@SuppressWarnings("deprecation")
	@Override
	public UserInfo getByUid(Long uid) {
		String hql = "select ui from " + UserInfo.class.getSimpleName() + " ui where ui.uid = ?";
		return (UserInfo) getSession().createQuery(hql).setParameter(0, uid).uniqueResult();
	}

	@Override
	public void deleteByUid(Long uid) {
		String hql = "delete from " + UserInfo.class.getSimpleName() + " where uid = ?";
		getSession().createQuery(hql).setParameter(0, uid).executeUpdate();
	}
}
