package chat.entity;

import java.io.Serializable;

public class User implements Serializable{
	private String c_user_id;
	private String c_user_name;
	private String c_user_password;
	private String c_user_birthday;
	private String c_user_gender;
	private String c_user_signature;
	private String c_user_chat;
	public String getC_user_id() {
		return c_user_id;
	}
	public void setC_user_id(String c_user_id) {
		this.c_user_id = c_user_id;
	}
	public String getC_user_name() {
		return c_user_name;
	}
	public void setC_user_name(String c_user_name) {
		this.c_user_name = c_user_name;
	}
	public String getC_user_password() {
		return c_user_password;
	}
	public void setC_user_password(String c_user_password) {
		this.c_user_password = c_user_password;
	}
	public String getC_user_birthday() {
		return c_user_birthday;
	}
	public void setC_user_birthday(String c_user_birthday) {
		this.c_user_birthday = c_user_birthday;
	}
	public String getC_user_gender() {
		return c_user_gender;
	}
	public void setC_user_gender(String c_user_gender) {
		this.c_user_gender = c_user_gender;
	}
	public String getC_user_signature() {
		return c_user_signature;
	}
	public void setC_user_signature(String c_user_signature) {
		this.c_user_signature = c_user_signature;
	}
	public String getC_user_chat() {
		return c_user_chat;
	}
	public void setC_user_chat(String c_user_chat) {
		this.c_user_chat = c_user_chat;
	}
	@Override
	public String toString() {
		return "User [c_user_id=" + c_user_id + ", c_user_name=" + c_user_name
				+ ", c_user_password=" + c_user_password + ", c_user_birthday=" + c_user_birthday
				+ ", c_user_gender=" + c_user_gender + ", c_user_signature="
				+ c_user_signature + ", c_user_chat=" + c_user_chat + "]";
	}
	
}
