package cn.spirithone.blog.oauth.mapper;

import java.util.Set;

import cn.spirithone.blog.oauth.model.Role;


/**
 *
 * @author Shawn_Hou
 * 2017年5月15日 上午11:10:48
 * 
 */
public interface RoleMapper extends BaseMapper<Role> {
	/**
	 * 根据uid查找用户所有的角色名称
	 * @param uid
	 * @return
	 */
	Set<String> findRoles(Long uid);
}
