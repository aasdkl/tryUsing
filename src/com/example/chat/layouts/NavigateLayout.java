package com.example.chat.layouts;

import com.example.chat.R;
import com.example.chat.R.id;
import com.example.chat.R.layout;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class NavigateLayout extends LinearLayout{

	public NavigateLayout(Context context, AttributeSet attrs) {
		super(context);
		LayoutInflater.from(context).inflate(R.layout.navigate, this);
		Button add = (Button) findViewById(R.id.add);
		Button back = (Button) findViewById(R.id.back);
		
		add.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getContext(), "add what?", Toast.LENGTH_SHORT).show();
			}
		});
		
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((Activity) getContext()).finish();
			}
		});
	}
	
}
