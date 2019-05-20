package chat.entity;

import java.io.Serializable;

public class Group implements Serializable{
	private String c_user_id;
	private String c_group_id;
	private String c_group_name;
	public String getC_user_id() {
		return c_user_id;
	}
	public void setC_user_id(String c_user_id) {
		this.c_user_id = c_user_id;
	}
	public String getC_group_id() {
		return c_group_id;
	}
	public void setC_group_id(String c_group_id) {
		this.c_group_id = c_group_id;
	}
	public String getC_group_name() {
		return c_group_name;
	}
	public void setC_group_name(String c_group_name) {
		this.c_group_name = c_group_name;
	}
	@Override
	public String toString() {
		return "Group [c_user_id=" + c_user_id + ", c_group_id=" + c_group_id
				+ ", c_group_name=" + c_group_name + "]";
	}
	
}
