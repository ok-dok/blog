package cn.spirithone.blog.oauth.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = -4424970400850577133L;
	@Id
	@GenericGenerator(name = "native", strategy = "native")
	@GeneratedValue(generator = "native")
	private Long id; // 逻辑主键
	private Long uid; // 用户id
	private String username; // 用户名（用于注册/登录）
	private String email; // 绑定邮箱（可用于登录/密码找回/邮件验证）
	private Long mobile; // 绑定手机号码（可用于登录/密码找回/短信验证）
	@Enumerated(EnumType.STRING)
	private Identity identity; // 账户身份,普通用户/系统用户
	private String password; // 登录密码
	private String salt; // 密码盐
	private Date registerTime;// 注册时间
	private Date loginTime; // 登录时间
	@Column(columnDefinition = "bit default 0")
	private boolean locked; // 账户是否锁定
	private String historyPwd; // 历史密码
	private String loginIp; // 登录ip
	private String registerIp; // 注册ip
	@Transient // 声明为临时属性，不映射到数据库
	private UserInfo info; // 用户信息
	@ManyToMany(targetEntity = Role.class)
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "uid", referencedColumnName = "uid") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id") })
	private Set<Role> roles; // 用户授权角色列表
	@ManyToMany(targetEntity = Resource.class)
	@JoinTable(name = "user_resource", joinColumns = {
			@JoinColumn(name = "uid", referencedColumnName = "uid") }, inverseJoinColumns = {
					@JoinColumn(name = "resource_id", referencedColumnName = "id") })
	private Set<Resource> resources;// 用户授权的资源列表

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public String getHistoryPwd() {
		return historyPwd;
	}

	public void setHistoryPwd(String historyPwd) {
		this.historyPwd = historyPwd;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getRegisterIp() {
		return registerIp;
	}

	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	public UserInfo getInfo() {
		return info;
	}

	public void setInfo(UserInfo info) {
		this.info = info;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
}
