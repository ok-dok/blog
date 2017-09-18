package cn.spirithone.blog.web.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Commentary {
	private Long id;
	private Long articleId;
	private Long userId;
	private String ip;
	private Date time;
	private Long pid;
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private Integer startRow, pageSize = 1;
	private List<Map<String, String>> orderByFields;

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<Map<String, String>> getOrderByFields() {
		return orderByFields;
	}

	public void setOrderByFields(List<Map<String, String>> orderByFields) {
		this.orderByFields = orderByFields;
	}

	@Override
	public String toString() {
		return "Commentary [id=" + id + ", articleId=" + articleId + ", userId=" + userId + ", ip=" + ip + ", time="
				+ time + ", pid=" + pid + ", content=" + content + "]";
	}

	String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}