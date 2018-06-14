[![version](https://jitpack.io/v/guoxiaolongonly/TimeSelectBarDemo.svg)](https://jitpack.io/#guoxiaolongonly/TimeSelectBarDemo)
## 功能如下
![lucky](https://github.com/guoxiaolongonly/TimeSelectBarDemo/blob/master/pic/666.gif?raw=true)



## 使用

```xml
        <cn.xiaolongonly.timebarselect.ScalableTimebarView
            android:id="@+id/my_timebar_view2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="20dp"
            android:background="#cd000000"
            app:displayLineColor="@color/color_33ffffff"
            app:indicateLineColor="@color/colorWhite"
            app:indicateTriangleColor="@color/colorWhite"
            app:outOfRangeColor="@color/color_gray"
            app:tickLineColor="@color/colorWhite"
            app:tickTextColor="@color/colorWhite"
            app:unDisplayLineColor="@color/color_33ffffff" />

```


### 依赖

Example for Gradle:

``` gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
dependencies {
	        implementation 'com.github.guoxiaolongonly:TimeSelectBarDemo:1.0.1'
	}
	
```

