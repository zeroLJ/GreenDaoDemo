package zero.com.greendaodemo;

import com.blankj.utilcode.util.Utils;

import zero.com.utillib.Activity.MApplication;

/**
 * Created by zero on 2018/1/8.
 */

public class App extends MApplication{
    @Override
    public void onCreate() {
        super.onCreate();
        //utillib里包含的第三方工具类，可注释掉
        Utils.init(this);
//        CrashHandler.getInstance("zero.com.greendaodemo .MainActivity").init(this);  //传入参数必须为Activity，否则AlertDialog将不显示。
    }
}
