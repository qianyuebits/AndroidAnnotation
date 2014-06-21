package com.footprint.component;

import com.footprint.annotation.AnnotationProcessor;

import android.app.Activity;
import android.os.Bundle;

/**
 * 继承此类的Activity都可以使用注解实例化属性。但是必须符合以下两个条件之一
 * 1）有属性：rootView；
 * 2）在调用super.onCreate()方法之前调用setContentView
 * 同时满足这两个条件的时候，以rootView为准
 * */
public class AnnotationActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		AnnotationProcessor.processActivity(this);
	}
}
