package cn.spirithone.common.util.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 通用ajax请求返回结果类
 * 
 * @author Shawn_Hou
 *
 */
public class ResultMap {
	/**
	 * 状态：success/error
	 */
	private String status;
	/**
	 * 提示信息
	 */
	private String msg;
	/**
	 * 数据信息
	 */
	@JsonInclude(Include.NON_EMPTY)
	private Object data;
	public static String SUCCESS = "success";
	public static String ERROR = "error";

	public ResultMap() {
		super();
	}

	public ResultMap(String status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	/**
	 * 状态：success/error
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	/**
	 * 提示信息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	/**
	 * 数据信息
	 */
	public void setData(Object data) {
		this.data = data;
	}
}
