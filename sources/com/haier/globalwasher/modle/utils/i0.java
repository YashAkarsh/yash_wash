package com.haier.globalwasher.modle.utils;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.haier.globalwasher.R;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24624a = "ToastUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Toast f24625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f24626c = new Handler();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Runnable f24627d = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i0.f24625b != null) {
                i0.f24625b.cancel();
                i0.f24625b = null;
            }
        }
    }

    public static void c(Context context, String str, View.OnClickListener... onClickListenerArr) {
        if (context == null) {
            q.c(f24624a, "showShortToast1");
            return;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            Toast.makeText(context, str, 1).show();
            return;
        }
        f24626c.removeCallbacks(f24627d);
        SoftReference softReference = new SoftReference(context);
        if (softReference.get() == null) {
            q.c(f24624a, "showShortToast2");
            return;
        }
        f24625b = Toast.makeText((Context) softReference.get(), str, 1);
        View viewInflate = ((LayoutInflater) ((Context) softReference.get()).getSystemService("layout_inflater")).inflate(R.layout.custom_toast, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.toast_message);
        if (onClickListenerArr != null && onClickListenerArr.length > 0) {
            viewInflate.setOnClickListener(onClickListenerArr[0]);
            textView.setOnClickListener(onClickListenerArr[0]);
        }
        textView.setText(str);
        f24625b.setGravity(17, 0, 150);
        f24625b.setView(viewInflate);
        f24625b.show();
        f24626c.postDelayed(f24627d, 1500L);
    }

    public static void d(Context context, String str) {
        if (context == null) {
            q.c(f24624a, "showShortToast1");
            return;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            Toast.makeText(context, str, 0).show();
            return;
        }
        f24626c.removeCallbacks(f24627d);
        SoftReference softReference = new SoftReference(context);
        if (softReference.get() == null) {
            q.c(f24624a, "showShortToast2");
            return;
        }
        f24625b = Toast.makeText((Context) softReference.get(), str, 0);
        View viewInflate = ((LayoutInflater) ((Context) softReference.get()).getSystemService("layout_inflater")).inflate(R.layout.custom_toast, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.toast_message)).setText(str);
        f24625b.setGravity(17, 0, 150);
        f24625b.setView(viewInflate);
        f24625b.show();
        f24626c.postDelayed(f24627d, 1500L);
    }
}
