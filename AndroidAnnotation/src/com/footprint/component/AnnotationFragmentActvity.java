package com.footprint.component;

import com.footprint.annointerface.GetView;
import com.footprint.annotation.AnnotationProcessor;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class AnnotationFragmentActvity extends FragmentActivity implements GetView{
	private View contentView;
	
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		AnnotationProcessor.processActivity(this);
	}
	
	@Override
	public View getContentView(){
		return contentView;
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
}
