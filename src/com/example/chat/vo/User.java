package com.example.chat.vo;

import java.util.List;

import android.R.string;

public class User {
	private int id;
	private String name;
	private List<Msg> msg;
	private int header;
	
	public User(int id, String name, List<Msg> msg, int header) {
		this.id = id;
		this.name = name;
		this.msg = msg;
		this.header = header;
	}
	
	public User(int i, String string) {
		this(i, string, null, 0);
	}

	public int getHeader() {
		return header;
	}
	
	public void setHeader(int header) {
		this.header = header;
	}
	
	public void setMsg(List<Msg> msg) {
		this.msg = msg;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Msg> getMsg() {
		return msg;
	}
}
