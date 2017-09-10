package cn.spirithone.blog.core.hibernate.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseHibernateDao<E> {
	/**
	 * 根据id获取实体
	 * 
	 * @param entityClass
	 *            实体类
	 * @param id
	 * @return 查询得到的实体对象
	 */
	E get(Class<E> entityClass, Serializable id);

	/**
	 * 保存实体
	 * 
	 * @param entity
	 *            实体对象
	 * @return 实体对象保存后的id
	 */
	Serializable save(E entity);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(E entity);

	/**
	 * 删除实体
	 * 
	 * @param entity
	 */
	void delete(E entity);

	/**
	 * 通过id删除实体对象
	 * 
	 * @param entityClass
	 *            实体类
	 * @param id
	 *            实体对象id
	 */
	void delete(Class<E> entityClass, Serializable id);

	List<E> getAll(Class<E> entityClass);
}
