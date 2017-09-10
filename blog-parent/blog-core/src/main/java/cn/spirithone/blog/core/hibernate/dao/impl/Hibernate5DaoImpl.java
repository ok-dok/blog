package cn.spirithone.blog.core.hibernate.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.spirithone.blog.core.hibernate.dao.BaseHibernateDao;

/**
 * BaseHibernateDao的实现类，采用Hibernate5，该类依赖SessionFactory(可由Spring容器注入)。 提供持久化操作
 * 
 * @author Shawn
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class Hibernate5DaoImpl<T> implements BaseHibernateDao<T> {
	@Autowired
	protected SessionFactory sessionFactory;
	private Class<T> clazz;
	protected Logger logger = null;

	public Hibernate5DaoImpl() {
		clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		logger = LoggerFactory.getLogger(clazz.getClass());
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 根据id获取实体
	@Override
	public T get(Class<T> entityClass, Serializable id) {
		return getSession().get(entityClass, id);
	}

	// 保存实体
	@Override
	public Serializable save(T entity) {
		return getSession().save(entity);
	}

	// 更新实体
	@Override
	public void update(T entity) {
		getSession().saveOrUpdate(entity);
	}

	// 删除实体
	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	// 根据id删除实体
	@Override
	public void delete(Class<T> entityClass, Serializable id) {
		String hql = "delete from " + entityClass.getSimpleName() + " where id = ?";
		getSession().createQuery(hql).setParameter(0, id).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> entityClass) {
		return (List<T>) getSession().createQuery("from " + entityClass.getSimpleName()).getResultList();
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
}
