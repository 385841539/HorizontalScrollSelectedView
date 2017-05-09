# HorizontalScrollSelectedView
横向滚动的，可以支持大量文本选择的 自定义View ，简单易用 ， 无OOM情况


# 效果图
![效果图](https://github.com/385841539/HorizontalScrollSelectedView/blob/master/horizontalselectedviewlibrary/src/main/res/drawable/xiaoguo2.gif)



# 博客介绍
 
CSDN:[http://blog.csdn.net/iamdingruihaha/article/details/71422269](http://blog.csdn.net/iamdingruihaha/article/details/71422269)


## Download
```java
    allprojects {
	    repositories {
		    ...
		    maven { url 'https://jitpack.io' }
	    }
	}

    dependencies {
       compile 'com.github.385841539:HorizontalScrollSelectedView:1.0.0'
	}
```


# Usage


基本使用：


```xml
        <com.example.horizontalselectedviewlibrary.HorizontalselectedView
            android:id="@+id/hd_main"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_gravity="center_vertical"
            android:layout_weight="30"
            app:HorizontalselectedViewSeesize="5"
            app:HorizontalselectedViewSelectedTextColor="@color/black"
            app:HorizontalselectedViewSelectedTextSize="60"
            app:HorizontalselectedViewTextColor="@color/gray"
            app:HorizontalselectedViewTextSize="40" />

```


自定义属性(均设有默认值，可不使用)：


| 属性         	 		|    参数           	| 说明  					|
| ------------------------- |------------------ | --------------------- |
| HorizontalselectedViewSeesize				| int y 			|可见文本数，默认为5|
| HorizontalselectedViewSelectedTextSize		| float y      	    |被选中文字大小|
| HorizontalselectedViewSelectedTextColor				|Color color    	|被选中文字颜色|
| HorizontalselectedViewTextSize			|  float y | 未被选中文字大小|
| HorizontalselectedViewTextColor|Color color | 未被选中文字颜色|




用到的动态方法
```java

    hsMain.setData(strings);//设置数据源
   
    hsMain.setAnLeftOffset();//向左移动一个单元
    
    hsMain.setAnRightOffset();//向右移动一个单元
    
    hsMain.getSelectedString();//获得被选中的文本
    
    
```

## Tips
  很简单的使用方法，不熟悉自定义View的小伙伴可以跟着敲一遍，巩固自定义View。
