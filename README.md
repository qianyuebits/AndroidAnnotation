AndroidAnnotation
=================

为Android开发提供注解框架，去除Android中反复出现的findViewById等代码。同时对点击事件等最常用事件进行View与事件函数的解耦,不需要去重复太多代码。框架是轻量型的，只针对最常用情形进行注解实现。


##Project Design
项目将为在Android Framework提供的Activity、Fragment、普通Class等之间添加一层注解组件，开发者继承这些组件，即可使用框架定义的注解进行项目开发。

##Project Done
1. 为Activity，Fragment，FragmentActivity & 普通Class添加有关R.id的注解，如下所示。继承这些类即可实现属性注解以及添加常用事件功能。  
	>AnnotationActivity:Activity封装类;   
	>AnnotationFragmentActivity:FragmentActivity封装类;   
	>AnnotationFragment:Fragment封装类;   
	>AnnotationObject:普通Class封装类; 
2. 为View添加点击事件;
3. 添加Bean注解，要求Bean有一个不带参数的构造函数;
4. 对资源做出注解，包括：color，dimen，drawable


##How To Use
下载项目bin文件夹中的androidannotation.jar放入开发项目的libs文件夹下面即可，示例：
    
	public class MainActivity extends AnnotationActivity {
	
		@ViewAnno(id = R.id.dataButton, click="switchClick")
		Button dataButton;//自动实例化 & 添加点击事件
	
		@ViewAnno(id = R.layout.activity_main)
		View rootView;//根View
	
		@BeanAnno
		Hello hello;//自动实例化

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
		
			Res res = new Res(this, null);
			dataButton.setBackgroundColor(res.backColor);
		}
	
		public void switchClick(View view){
			hello.print();//测试代码，表示可以实例化bean
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, SecondActivity.class);
			startActivity(intent);
		}

		public class Res extends AnnotationObject{
			@ColorAnno(color = R.color.test)
			int backColor;

			@DimenAnno(dimen = R.dimen.activity_horizontal_margin)
			int dimen;

			@StringAnno(string = R.string.app_name)
			String str;

			@DrawableAnno(drawable = R.drawable.ic_launcher)
			Drawable drawable;
		
			public Res(Activity context, View view) {
				super(context, null);
			}
		}
	}

代码展示了各种所有注解的使用方式。其中Res类既可以作为内部类，也可以作为外部类。

##Attentation
- Activity需要满足两个条件之一：1）有一个属性叫做rootView，并且做出注解，框架会自动设置rootView作为setContentView()的参数；2）或者开发者可以不去设置该属性，而是在调用super.onCreate(savedInstanceState)之前调用setContentView()设置视图。同时设置设置以rootView为准;
- FragmentActivity同上;
- Fragment则需要实现两个抽象函数，一个返回根View的id，一个是在所有的View被实例化之后进行回调的函数，前者必须要实现;
