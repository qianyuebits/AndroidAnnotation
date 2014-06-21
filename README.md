AndroidAnnotation
=================

为Android开发提供注解框架，解除Android中反复出现的findViewById等代码


##Project design
项目将为在Android Framework提供的Activity、Fragment、普通Class等之间添加一层注解组件，开发者继承这些组件，即可使用框架定义的注解进行项目开发。

##Project Done
1. 为Activity，Fragment，FragmentActivity & 普通Class添加有关R.id的注解

##Project Todo
1. 为View添加事件注解


##Project Doing
为View添加事件注解


##How to use
下载项目bin文件夹中的androidannotation.jar放入开发项目的libs文件夹下面即可。


##Attentation
- Activity都需要有一个属性叫做rootView，并且做出注解，框架会自动设置rootView作为setContentView()的参数；或者开发者可以不去设置该属性，而是在调用super.onCreate(savedInstanceState)之前调用setContentView()设置视图；设置了rootView就会以rootView为准；
- Fragment同上；
