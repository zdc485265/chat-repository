package chat.entity;

import java.io.Serializable;

public class Friend implements Serializable{
	private String c_group_id;
	private String c_friend_id;
	private String c_user_id;
	private String c_friend_name;
	public String getC_group_id() {
		return c_group_id;
	}
	public void setC_group_id(String c_group_id) {
		this.c_group_id = c_group_id;
	}
	public String getC_friend_id() {
		return c_friend_id;
	}
	public void setC_friend_id(String c_friend_id) {
		this.c_friend_id = c_friend_id;
	}
	public String getC_user_id() {
		return c_user_id;
	}
	public void setC_user_id(String c_user_id) {
		this.c_user_id = c_user_id;
	}
	public String getC_friend_name() {
		return c_friend_name;
	}
	public void setC_friend_name(String c_friend_name) {
		this.c_friend_name = c_friend_name;
	}
	@Override
	public String toString() {
		return "Friend [c_group_id=" + c_group_id + ", c_friend_id="
				+ c_friend_id + ", c_user_id=" + c_user_id + ", c_friend_name="
				+ c_friend_name + "]";
	}
	

}
