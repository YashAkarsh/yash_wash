package com.haier.globalwasher.modle.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.base.BaseActivity;

/* JADX INFO: loaded from: classes2.dex */
public class n0 {
    public static int a(BaseActivity baseActivity) {
        WindowManager windowManager = baseActivity.getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int b(BaseActivity baseActivity) {
        WindowManager windowManager = baseActivity.getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int c(Context context, int i7) {
        return (int) (i7 * context.getResources().getDisplayMetrics().density);
    }

    public static int d(Context context, int i7) {
        return (int) (i7 / context.getResources().getDisplayMetrics().density);
    }

    public static int e(float f8) {
        return (int) ((f8 * MyApplication.k().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int f(Activity activity) {
        try {
            WindowManager windowManager = activity.getWindowManager();
            float width = windowManager.getDefaultDisplay().getWidth();
            float height = windowManager.getDefaultDisplay().getHeight();
            float f8 = width / height;
            q.c("getAppAdInfo", "width=" + width + "  height=" + height + " scale=" + f8);
            return ((double) f8) < 0.5d ? 5 : 4;
        } catch (Exception unused) {
            return 5;
        }
    }

    public static int g(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        Log.e("WangJ", "状态栏-方法3:" + rect.top);
        return rect.top;
    }

    public static void i(MotionEvent motionEvent, View view, Activity activity) {
        if (view != null) {
            try {
                if (view instanceof EditText) {
                    int[] iArr = {0, 0};
                    view.getLocationInWindow(iArr);
                    int i7 = iArr[0];
                    int i8 = iArr[1];
                    int width = view.getWidth() + i7;
                    int height = view.getHeight() + i8;
                    if (motionEvent.getRawX() < i7 || motionEvent.getRawX() > width || motionEvent.getY() < i8 || motionEvent.getRawY() > height) {
                        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
                    }
                }
            } catch (Exception e8) {
                e8.printStackTrace();
            }
        }
    }

    public static void j(View view) {
        InputMethodManager inputMethodManager;
        if (view == null || (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static int k(Context context, float f8) {
        return (int) ((f8 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static void l(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            view.requestFocus();
            inputMethodManager.showSoftInput(view, 0);
        }
    }

    public static int m(Context context, float f8) {
        return (int) (((f8 * context.getResources().getDisplayMetrics().scaledDensity) * 10.0f) / 18.0f);
    }

    public void h(Context context) {
    }
}
