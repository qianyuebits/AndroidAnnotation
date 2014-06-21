package com.footprint.component;

import com.footprint.annotation.AnnotationProcessor;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class AnnotationFragmentActvity extends FragmentActivity{
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		AnnotationProcessor.processActivity(this);
	}
}
