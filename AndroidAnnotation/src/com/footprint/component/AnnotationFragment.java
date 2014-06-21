package com.footprint.component;

import com.footprint.annotation.AnnotationProcessor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 继承此类的Fragment都可以使用注解实例化属性。但是必须实现两个抽象方法
 * 同时满足这两个条件的时候，以rootView为准
 * */
public abstract class AnnotationFragment extends Fragment{
	private int contentViewId = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		contentViewId = getContentView();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(contentViewId, null);
		AnnotationProcessor.processObject(this, rootView);
		onViewReady();
		return rootView;
	}
	
	/**
	 * 当有属性rootView并且实现注解的时候，可以返回任意值
	 * */
	abstract protected int getContentView();
	
	/**
	 * View全部准备好的时候，回调
	 * */
	abstract protected void onViewReady();
}
