package cn.spirithone.blog.oauth.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Resource implements Serializable {
	private static final long serialVersionUID = -4849872141027367909L;
	@Id
	@GenericGenerator(name = "native", strategy = "native")
	@GeneratedValue(generator = "native")
	private Long id; // 资源id
	private String pids; // 父编号列表
	private String name; // 资源名称
	private String type; // 资源类型
	private Long seq; // 排序号
	private String permission; // 权限标识符，用于隐式权限判断
	private boolean available; // 是否可用
	@ManyToMany(targetEntity = User.class)
	@JoinTable(name = "user_resource", joinColumns = {
			@JoinColumn(name = "resource_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "uid", referencedColumnName = "uid") })
	private Set<User> users; // 权限对应的用户列表

	public Resource() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getPids() {
		return pids;
	}

	public void setPids(String pids) {
		this.pids = pids;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
