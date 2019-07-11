# About
Android 圆形进度条

# Gradle
[![](https://jitpack.io/v/zj565061763/circular-progresbar.svg)](https://jitpack.io/#zj565061763/circular-progresbar)

# Demo

```xml
<com.sd.lib.circularpgb.CircularProgressBar
    android:id="@+id/progressbar"
    android:layout_width="50dp"
    android:layout_height="50dp"
    android:background="@color/colorPrimary"
    app:cpgbMax="100"
    app:cpgbNormalColor="#999999"
    app:cpgbProgress="60"
    app:cpgbProgressColor="@color/colorAccent"
    app:cpgbProgressWidth="5dp"
    app:cpgbStartAngel="-90" />
```xml

```java
// 设置进度
progressBar.setProgress(50);
// 设置最大值，默认100
progressBar.setMax(100);
// 设置正常颜色值
progressBar.setNormalColor(Color.BLACK);
// 设置进度颜色值
progressBar.setProgressColor(Color.RED);
// 设置进度条粗细
progressBar.setProgressWidth(10);
// 设置进度开始的的角度，默认顶部（-90度）
progressBar.setStartAngel(-90);
```

# 支持的属性
```xml
<resources>

    <declare-styleable name="LibCircularProgressBar">

        <!-- 进度条正常颜色 -->
        <attr name="cpgbNormalColor" format="color" />
        <!-- 进度条进度颜色 -->
        <attr name="cpgbProgressColor" format="color" />
        <!-- 进度条进度值 -->
        <attr name="cpgbProgress" format="integer" />
        <!-- 进度条最大值 -->
        <attr name="cpgbMax" format="integer" />
        <!-- 进度条粗细 -->
        <attr name="cpgbProgressWidth" format="dimension" />
        <!-- 进度开始点角度 -->
        <attr name="cpgbStartAngel" format="integer" />

    </declare-styleable>

</resources>
```

# 覆盖默认配置
```xml
<resources>

    <!-- 进度条正常颜色 -->
    <color name="lib_cpb_normal_color">#eeeeee</color>
    <!-- 进度条进度颜色 -->
    <color name="lib_cpb_progress_color">#FF0000</color>

    <!-- 进度条粗细 -->
    <dimen name="lib_cpb_progress_width">2dp</dimen>
    <!-- 进度开始点角度 -->
    <integer name="lib_cpb_start_angel">-90</integer>

</resources>
```