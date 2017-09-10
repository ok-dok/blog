package cn.spirithone.blog.oauth.service;

import java.io.IOException;
import java.io.OutputStream;

public interface CommonService {
	/**
	 * 生成图形验证码并写入输出流，返回验证码字符串
	 * 
	 * @param out
	 * @return
	 * @throws IOException
	 */
	String drawImage(OutputStream out) throws IOException;
}
