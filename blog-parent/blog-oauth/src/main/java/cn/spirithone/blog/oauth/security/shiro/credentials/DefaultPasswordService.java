package cn.spirithone.blog.oauth.security.shiro.credentials;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import cn.spirithone.blog.oauth.model.User;

public class DefaultPasswordService implements PasswordService {
	private String hashAlgorithmName;
	private int hashIterations;

	public String getHashAlgorithmName() {
		return hashAlgorithmName;
	}

	public void setHashAlgorithmName(String hashAlgorithmName) {
		this.hashAlgorithmName = hashAlgorithmName;
	}

	public int getHashIterations() {
		return hashIterations;
	}

	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}

	@Override
	public String encryptPassword(String pwd, String salt) throws IllegalArgumentException {
		SimpleHash hash = new SimpleHash(hashAlgorithmName, pwd, salt, hashIterations);
		return hash.toHex();
	}

	@Override
	public User encryptPassword(User u) {
		String pwd = u.getPassword();
		String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
		u.setSalt(salt);
		SimpleHash hash = new SimpleHash(hashAlgorithmName, pwd, salt, hashIterations);
		u.setPassword(hash.toHex());
		return u;
	}
}
