/*
 * This source code is licensed under the MIT-style license found in the
 * LICENSE file in the root directory of this source tree.
 */
package cn.xiaolongonly.timebarselect;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * @author CRAWLER
 */
public class DeviceUtil {
    public static int[] getScreenResolution(Context context) {
        int scrennResolution[] = new int[2];
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        android.view.Display display = wm.getDefaultDisplay();
        display.getMetrics(dm);
        scrennResolution[0] = dm.widthPixels;
        scrennResolution[1] = dm.heightPixels;
        return scrennResolution;
    }



    public static float getDensity(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        android.view.Display display = wm.getDefaultDisplay();
        display.getMetrics(dm);
        return dm.density;
    }


    public static int dip2px(float dipValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    public static int px2dip(float pxValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


}
