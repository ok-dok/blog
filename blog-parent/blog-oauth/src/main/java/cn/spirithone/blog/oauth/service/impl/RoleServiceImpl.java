
package cn.spirithone.blog.oauth.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.spirithone.blog.oauth.dao.RoleDao;
import cn.spirithone.blog.oauth.mapper.RoleMapper;
import cn.spirithone.blog.oauth.service.RoleService;

/**
 *
 * @author Shawn_Hou
 * 2017年5月15日 上午11:08:35
 * 
 */
@Service
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleDao roleDao;
	@Resource
	private RoleMapper roleMapper;
	private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Override
	public Set<String> findRoles(Long uid) {
		Set<String> roles = roleMapper.findRoles(uid);
		logger.debug("根据uid: {} 查找到用户角色: {}", uid, roles);
		return roles;
	}
	
}
