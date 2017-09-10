package cn.spirithone.blog.oauth.filter;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import cn.spirithone.blog.oauth.model.User;
import cn.spirithone.blog.oauth.service.UserService;

public class UserFilter extends AccessControlFilter {
	@Resource
	private UserService userService;

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		if (isLoginRequest(request, response)) {
			return true;
		}
		Subject subject = getSubject(request, response);
		boolean flag = (subject.getPrincipal() != null);
		if (flag) {
			User user = userService.findUser(subject.getPrincipal().toString());
			subject.getSession().setAttribute("user", user);
		}
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		saveRequestAndRedirectToLogin(request, response);
		return false;
	}
}
