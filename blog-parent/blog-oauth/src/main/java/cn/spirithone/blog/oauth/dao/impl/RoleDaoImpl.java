package cn.spirithone.blog.oauth.dao.impl;

import org.springframework.stereotype.Repository;

import cn.spirithone.blog.core.hibernate.dao.impl.Hibernate5DaoImpl;
import cn.spirithone.blog.oauth.dao.RoleDao;
import cn.spirithone.blog.oauth.model.Role;

/**
 *
 * @author Shawn_Hou 2017年5月15日 上午11:10:18
 * 
 */
@Repository
public class RoleDaoImpl extends Hibernate5DaoImpl<Role> implements RoleDao {
}
