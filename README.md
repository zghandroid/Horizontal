# Horizontal
我的Android学习之路

1，从eclipse 项目导入Android studio后 build gradle中 compile 无法成功.  
解决： repositories {
        maven { url 'http://repo1.maven.org/maven2' }
    }
    
    
    
2，添加依赖me.dm7.barcodescanner:zxing:1.9.3时，出现com.android.dex.DexException: Multiple dex files define(重复引用包)
解决:compile ('me.dm7.barcodescanner:zxing:1.9.3'){
        exclude group: 'com.android.support', module:'support-v4'
    }
  
3,setVideoSize时，5.0以后，宽高必须是摄像头支持的大小。在setVideoEncoder之前之后都没关系。setVideoSize的方法上，有说明
Sets the width and height of the video to be captured. Must be called
* after setVideoSource(). Call this after setOutFormat() but before
* prepare().
