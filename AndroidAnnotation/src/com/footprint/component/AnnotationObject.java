package com.footprint.component;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.footprint.annotation.AnnotationProcessor;

/**
 * 为一个Object添加注解
 * for example:
 * private class ViewHolder extends AnnotationObject{
 * 		@ViewAnno(R.id.button)
 * 		public Button button;
 * 
 * 		public ViewHolder(View view){
 * 			super(view);
 * 		}
 * }
 * */
public class AnnotationObject extends Object{
	
	public AnnotationObject(Activity context, View view){
		AnnotationProcessor.processObject(this, view, context);
	}
	
	public AnnotationObject(Activity context, int viewResource){
		this(context, context.getLayoutInflater().inflate(viewResource, null));
	}
}
