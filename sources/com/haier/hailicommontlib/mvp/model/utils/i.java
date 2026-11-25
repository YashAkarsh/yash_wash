package com.haier.hailicommontlib.mvp.model.utils;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.haier.hailicommontlib.R;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f26180a = "ToastUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Toast f26181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f26182c = new Handler();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Runnable f26183d = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i.f26181b != null) {
                i.f26181b.cancel();
                i.f26181b = null;
            }
        }
    }

    public static void c(Context context, String str, View.OnClickListener... onClickListenerArr) {
        if (context == null) {
            b.c(f26180a, "showShortToast1");
            return;
        }
        f26182c.removeCallbacks(f26183d);
        SoftReference softReference = new SoftReference(context);
        if (softReference.get() == null) {
            b.c(f26180a, "showShortToast2");
            return;
        }
        f26181b = Toast.makeText((Context) softReference.get(), str, 1);
        View viewInflate = ((LayoutInflater) ((Context) softReference.get()).getSystemService("layout_inflater")).inflate(R.layout.hailicommonlib_custom_toast, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.toast_message);
        if (onClickListenerArr != null && onClickListenerArr.length > 0) {
            viewInflate.setOnClickListener(onClickListenerArr[0]);
            textView.setOnClickListener(onClickListenerArr[0]);
        }
        textView.setText(str);
        f26181b.setGravity(17, 0, 150);
        f26181b.setView(viewInflate);
        f26181b.show();
        f26182c.postDelayed(f26183d, 1500L);
    }

    public static void d(Context context, String str) {
        if (context == null) {
            b.c(f26180a, "context==null");
            return;
        }
        f26182c.removeCallbacks(f26183d);
        SoftReference softReference = new SoftReference(context);
        if (softReference.get() == null) {
            b.c(f26180a, "showShortToast2");
            return;
        }
        f26181b = Toast.makeText((Context) softReference.get(), str, 0);
        View viewInflate = ((LayoutInflater) ((Context) softReference.get()).getSystemService("layout_inflater")).inflate(R.layout.hailicommonlib_custom_toast, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.toast_message)).setText(str);
        f26181b.setGravity(17, 0, 150);
        f26181b.setView(viewInflate);
        f26181b.show();
        f26182c.postDelayed(f26183d, 1500L);
    }
}
