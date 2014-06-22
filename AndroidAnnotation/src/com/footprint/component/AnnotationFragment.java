package com.footprint.component;

import com.footprint.annotation.AnnotationProcessor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 继承此类的Fragment都可以使用注解实例化属性。但是必须实现两个抽象方法
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
		AnnotationProcessor.processObject(this, rootView, this.getActivity());
		onViewReady();
		return rootView;
	}
	
	/**
	 * 实现该方法，返回Fragment的contentViewId
	 * */
	abstract protected int getContentView();
	
	/**
	 * 所有的注解View被实例化后调用
	 * */
	abstract protected void onViewReady();
}
