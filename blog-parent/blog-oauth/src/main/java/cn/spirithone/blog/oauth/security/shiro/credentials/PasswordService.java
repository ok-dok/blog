package cn.spirithone.blog.oauth.security.shiro.credentials;

import cn.spirithone.blog.oauth.model.User;

public interface PasswordService {
	String encryptPassword(String pwd, String salt);

	User encryptPassword(User u);
}
