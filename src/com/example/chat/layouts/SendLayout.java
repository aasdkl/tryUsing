package com.example.chat.layouts;

import com.example.chat.MainActivity;
import com.example.chat.R;
import com.example.chat.R.id;
import com.example.chat.R.layout;
import com.example.chat.myComponents.ChatAdapter;
import com.example.chat.vo.Msg;
import com.example.chat.vo.User;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SendLayout extends LinearLayout{


	public SendLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.bottom, this);
		
		final EditText add = (EditText) findViewById(R.id.editText);
		final Button send = (Button) findViewById(R.id.send);
		add.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (TextUtils.isEmpty(add.getText().toString().trim())) {
					send.setEnabled(false);
				} else {
					send.setEnabled(true);
				}
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
		
		send.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//TODO send
				String s = add.getText().toString();
				User me = ((MainActivity) getContext()).getMe();
				((MainActivity) getContext()).getUser().getMsg().add(new Msg(0, s, "1", me));
				ChatAdapter adapter = ((MainActivity) getContext()).getAdapter();
				adapter.notifyDataSetChanged();
				((MainActivity) getContext()).getView().setSelection(((MainActivity) getContext()).getUser().getMsg().size());
				add.setText("");
			}
		});
	}
	
}
