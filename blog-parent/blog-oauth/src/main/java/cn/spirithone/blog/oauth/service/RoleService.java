/**
 * Title: RoleService.java
 * Description: 
 * CopyRight: CopyRight © 
 * @author Shawn_Hou
 * 2017年5月15日 上午11:07:56
 */
package cn.spirithone.blog.oauth.service;

import java.util.Set;

/**
 *
 * @author Shawn_Hou 2017年5月15日 上午11:07:56
 * 
 */
public interface RoleService {
	/**
	 * 通过用户uid查找用户角色
	 * 
	 * @param uid
	 * @return 该用户拥有的所有角色名称的set集合
	 */
	Set<String> findRoles(Long uid);
}
