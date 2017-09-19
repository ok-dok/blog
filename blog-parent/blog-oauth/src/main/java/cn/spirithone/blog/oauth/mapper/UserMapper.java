package cn.spirithone.blog.oauth.mapper;

import java.util.Map;

import cn.spirithone.blog.oauth.model.User;

public interface UserMapper extends BaseMapper<User> {
	/**
	 * 通过参数身份信息（username/email/mobile/uid）查找用户
	 * @param principal
	 * @return
	 */
	User findUser(Map<String,Object> params);
	
}
