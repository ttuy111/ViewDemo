package me.kule.viewdemo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by KuLe on 2018/7/17.
 * Email: 783051@qq.com
 */

public class Utils {
    public static void LaunchActivity(Activity activity,
                                           Class<? extends Activity> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
    }


    public static float dp2Px(float dp) {
       return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp, Resources.getSystem().getDisplayMetrics());
    }
}
