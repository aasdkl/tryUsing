package com.example.chat;

import java.util.LinkedList;
import java.util.List;

import com.example.chat.myComponents.ChatAdapter;
import com.example.chat.vo.Msg;
import com.example.chat.vo.User;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	User me;
	User user;
	ChatAdapter adapter;
	ListView view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		me = new User(0, "me", null, R.drawable.ic_launcher);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initMsgs();
		adapter = new ChatAdapter(
				MainActivity.this, R.layout.list_item, user.getMsg());
		view = (ListView)findViewById(R.id.msgView);
		view.setAdapter(adapter);
	}

	private void initMsgs() {
		user = new User(1, "对方");
		user.setHeader(R.drawable.ic_launcher);
		List<Msg> msg = new LinkedList<Msg>();
		String[] s = {"嘿！","?","耶！","啊不没事！测试很长很长很长很长很长很长的一句话o(≧口≦)o啦啦啦！"};
		msg.add(new Msg(1, s[0], "2015.01.01 12:00:02", user));
		msg.add(new Msg(2, s[1], "2015.01.01 12:00:12", me));
		msg.add(new Msg(3, s[2], "2015.01.01 12:00:22", user));
		msg.add(new Msg(4, s[3], "2015.01.01 12:00:26", user));
		//TODO user
		user.setMsg(msg);
	}
	
	public ListView getView() {
		return view;
	}
	
	public ChatAdapter getAdapter() {
		return adapter;
	}
	
	public User getMe() {
		return me;
	}
	
	public User getUser() {
		return user;
	}
}

