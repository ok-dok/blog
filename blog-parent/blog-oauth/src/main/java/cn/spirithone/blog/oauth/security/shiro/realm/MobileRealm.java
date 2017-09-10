package cn.spirithone.blog.oauth.security.shiro.realm;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;

import cn.spirithone.blog.oauth.model.User;
import cn.spirithone.blog.oauth.service.RoleService;
import cn.spirithone.blog.oauth.service.UserService;

public class MobileRealm extends AuthorizingRealm {
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;

	@Override
	public String getName() {
		return "mobile";
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String principal = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		User user = null;
		if (StringUtils.isNumeric(principal)) {
			Long mobile = Long.parseLong(principal);
			user = userService.getByMobile(mobile);
		}
		if (user != null) {
			Set<String> roles = roleService.findRoles(user.getUid());
			authorizationInfo.setRoles(roles);
			SecurityUtils.getSubject().getSession().setAttribute("roles", roles.toArray());
			/*
			 * authorizationInfo.setStringPermissions(userService.
			 * findPermissions(principal));
			 */
		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String principal = token.getPrincipal().toString();
		User user = null;
		if (StringUtils.isNumeric(principal)) {
			Long mobile = Long.parseLong(principal);
			user = userService.getByMobile(mobile);
		}
		if (user == null) {
			throw new UnknownAccountException();// 没找到帐号
		}
		if (Boolean.TRUE.equals(user.isLocked())) {
			throw new LockedAccountException(); // 帐号锁定
		}
		// 交给AuthenticatingRealm使用credentialsMatcher进行密码匹配
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getMobile(), // 手机号
				user.getPassword(), // 密码
				new SimpleByteSource(user.getSalt()), // salt
				getName() // realm name
		);
		return authenticationInfo;
	}
}