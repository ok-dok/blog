package cn.spirithone.blog.oauth.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Role implements Serializable {
	private static final long serialVersionUID = -2577283998041796567L;
	@Id
	@GenericGenerator(name = "native", strategy = "native")
	@GeneratedValue(generator = "native")
	private Long id; // 角色id
	/**
	 * 角色标识符，用于隐式角色判断 普通用户：user:* 系统用户:system:*
	 * 
	 */
	private String name;
	private String description; // 描述，用于前台页面显示
	private String resourceIds; // 角色授权的资源列表
	@Column(columnDefinition = "bit default 1")
	private boolean available; // 是否可用
	@ManyToMany(targetEntity = User.class)
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "uid", referencedColumnName = "uid") })
	private Set<User> users; // 角色下拥有的用户

	public Role() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String role) {
		this.name = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
