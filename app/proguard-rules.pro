# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\AndroidSdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-keep class me.zhanghai.android.materialprogressbar.** { *; }
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-optimizationpasses 5
-verbose
-dontoptimize #不优化指定的文件
-dontpreverify #不预校验
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
# For native methods, see http://proguard.sourceforge.net/manual/examples.html#native
#-keepclasseswithmembernames class * { #不混淆类及其成员名
#    native <methods>;
#}
# keep setters in Views so that animations can still work.
# see http://proguard.sourceforge.net/manual/examples.html#beans
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

-keepclassmembers class ** {
    public void onEvent*(**);
}
-keepclassmembers class ** {
public void xxxxxx(**);
}

-keep class com.leyo.app.bean.**{ *; }
-keep class com.ttvrec.api.**{ *; }
-keep class com.leyo.app.adapter.**{ *; }
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep class com.tencent.mm.sdk.openapi.WXMediaMessage {*;}
-keep class com.tencent.mm.sdk.openapi.** implements com.tencent.mm.sdk.openapi.WXMediaMessage$IMediaObject {*;}
-keep class com.tencent.**{*;}
-keep class com.tencent.stat.** { *; }
-keep class com.qiniu.android.**{*;}
-keep class com.loopj.android.**{*;}
-keep class cn.sharesdk.framework.** { *; }
-keep class cn.sharesdk.tencent.qq.** { *; }
-keep class cn.sharesdk.tencent.qzone.** { *; }
-keep class m.framework.**{*;}
-keep class android.support.v4** { *; }
-keep class com.google.gson** { *; }
-keep class org.apache.http.entity.mime.** { *; }
-keep public class android.webkit.**
-keep class cn.sharesdk.sina.weibo.** { *; }
-keep class com.sina.** { *; }
-keep class cn.sharesdk.wechat.friends.** { *; }
-keep class cn.sharesdk.wechat.utils.** { *; }
-keep class com.umeng.analytics.** { *; }
-keep class com.nostra13.universalimageloader.** { *; }
-keep class com.umeng.analytics.** { *; }
-keep public interface com.tencent.**
-keep class cn.sharesdk.wechat.moments.** { *; }
-dontwarn android.webkit.WebView
-dontwarn cn.sharesdk.**
-dontwarn com.sina.**
-dontwarn com.nostra13.**
-dontwarn com.umeng.**
-dontwarn com.tencent.**
-dontwarn com.qiniu.**
-keepattributes *Annotation*
-dontwarn org.apache.http.entity.**
-dontwarn com.google.**
-dontwarn android.support.**
-dontwarn com.loopj.android.**
-dontwarn m.framework.**
-keeppackagenames org.apache.http.entity.mime.**
-keeppackagenames m.framework.**
-keeppackagenames com.tencent.stat.**
-keeppackagenames com.tencent.**
-keeppackagenames com.qiniu.android.**
-keeppackagenames cn.sharesdk.framework.**
-keeppackagenames cn.sharesdk.tencent.qq.**
-keeppackagenames cn.sharesdk.tencent.qzone.**
-keeppackagenames cn.sharesdk.sina.weibo.**
-keeppackagenames com.sina.**
-keeppackagenames cn.sharesdk.wechat.friends.**
-keeppackagenames cn.sharesdk.wechat.utils.**
-keeppackagenames cn.sharesdk.wechat.moments.**

-keeppackagenames com.nostra13.universalimageloader.**
-keeppackagenames android.support.v4.**
-keeppackagenames com.google.gson.**



##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
-keep class com.google.gson.** { *;}

# Application classes that will be serialized/deserialized over Gson
-keep class com.antew.redditinpictures.library.imgur.** { *; }
-keep class com.antew.redditinpictures.library.reddit.** { *; }
-keep interface com.test.TestSdk$Callback {
    public <methods>;
}

##---------------End: proguard configuration for Gson  ----------
#---------        友盟混淆配置开始   ------------------------
-keepclassmembers class * {
    public <init>(org.json.JSONObject);
}

-keep public class com.leyo.recorder.R$*{
    public static final int *;
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
#---------        友盟混淆配置结束   ------------------------