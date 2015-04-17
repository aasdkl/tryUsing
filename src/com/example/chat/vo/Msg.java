package com.example.chat.vo;

public class Msg {
	int id;
	String msg;
	String time;
	// 0 is myself
	User from;
	
	public Msg(int id, String msg, String time, User from) {
		this.id=id;
		this.msg=msg;
		this.time=time;
		this.from=from;
	}
	
	public User getFrom() {
		return from;
	}
	
	public int getId() {
		return id;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public String getTime() {
		return time;
	}
}
