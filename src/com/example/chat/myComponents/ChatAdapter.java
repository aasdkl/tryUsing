package com.example.chat.myComponents;

import java.util.List;

import com.example.chat.R;
import com.example.chat.vo.Msg;

import android.content.Context;
import android.opengl.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ChatAdapter extends ArrayAdapter<Msg>{
	
	int viewId;
	
	public ChatAdapter(Context context, int textViewResourceId, List<Msg> objects) {
		super(context, textViewResourceId, objects);
		viewId = textViewResourceId;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Msg msg = getItem(position);
		View view;
		// ΪЧ�ʣ�����findViewById��ȡʵ��
		ViewHolder vh;
		// convertView�Ծɲ��ֽ��л���
		if (convertView==null) {
			//���¼��أ�Ч�ʵ�
			view = LayoutInflater.from(getContext()).inflate(viewId, null);//Ϊ����ز���
			vh= new ViewHolder(
					(ImageView) view.findViewById(R.id.leftHeader),
					(TextView) view.findViewById(R.id.leftMsg),
					(ImageView) view.findViewById(R.id.rightHeader),
					(TextView) view.findViewById(R.id.rightMsg));
			view.setTag(vh);
		} else {
			view = convertView;
			vh=(ViewHolder)view.getTag();
		}
		if (msg.getFrom().getId()==0) {
			((RelativeLayout) view.findViewById(R.id.leftParent)).setVisibility(View.GONE);
			((RelativeLayout) view.findViewById(R.id.rightParent)).setVisibility(View.VISIBLE);
			vh.rightImageView.setImageResource(msg.getFrom().getHeader());
			vh.rightTextView.setText(msg.getMsg());
		} else {
			((RelativeLayout) view.findViewById(R.id.rightParent)).setVisibility(View.GONE);
			((RelativeLayout) view.findViewById(R.id.leftParent)).setVisibility(View.VISIBLE);
			vh.leftImageView.setImageResource(msg.getFrom().getHeader());
			vh.leftTextView.setText(msg.getMsg());
		}
		

		return view;

	}
	
	@Override
	public boolean isEnabled(int position) {
		return false;
	}
	
	@Override
	public boolean areAllItemsEnabled() {
		return false;
	}
}

class ViewHolder{
	ImageView leftImageView;
	TextView leftTextView;
	ImageView rightImageView;
	TextView rightTextView;
	public ViewHolder(ImageView imageView1, TextView textView1, ImageView imageView2, TextView textView2) {
		leftImageView=imageView1;
		leftTextView=textView1;
		rightImageView=imageView2;
		rightTextView=textView2;
	}
}