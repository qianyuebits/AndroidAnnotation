package com.footprint.component;

import com.footprint.annointerface.GetView;
import com.footprint.annotation.AnnotationProcessor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/**
 * 继承此类的Activity都可以使用注解实例化属性。但是必须符合以下两个条件之一
 * 1）有属性：rootView;
 * 2）在调用super.onCreate()方法之前调用setContentView;
 * 同时满足这两个条件的时候，以rootView为准
 * */
public class AnnotationActivity extends Activity implements GetView{
	private View contentView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		AnnotationProcessor.processActivity(this);
	}

	@Override
	public void setContentView(int layoutResID) {
		setContentView(this.getLayoutInflater().inflate(layoutResID, null));
	}

	@Override
	public void setContentView(View view, LayoutParams params) {
		this.contentView = view;
		super.setContentView(view, params);
	}

	@Override
	public void setContentView(View view) {
		this.contentView = view;
		super.setContentView(view);
	}

	@Override
	public View getContentView() {
		// TODO Auto-generated method stub
		return contentView;
	}
}
