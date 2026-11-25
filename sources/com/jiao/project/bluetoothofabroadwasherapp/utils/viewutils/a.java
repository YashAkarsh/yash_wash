package com.jiao.project.bluetoothofabroadwasherapp.utils.viewutils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.haier.hailicommontlib.mvp.model.utils.b;
import com.haier.hailicommontlib.mvp.model.utils.i;
import com.jiao.project.bluetoothofabroadwasherapp.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static AlertDialog f32447j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f32448k = 1000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f32449l = 10.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f32450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f32451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f32452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Resources f32453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f32454e = "GsonRequest";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    TextView f32455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LocationManager f32456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LocationListener f32457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Activity f32458i;

    /* JADX INFO: renamed from: com.jiao.project.bluetoothofabroadwasherapp.utils.viewutils.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC0390a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f32459a;

        public ViewOnClickListenerC0390a(int i7) {
            this.f32459a = i7;
        }

        public void a(Activity activity) {
            a.this.f32458i = activity;
            a.this.f32453d = activity.getResources();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.c(a.this.f32454e, "ToSettingLinsenter=1");
            a.this.i();
            if (a.this.f32456g == null) {
                a aVar = a.this;
                aVar.f32456g = (LocationManager) aVar.f32458i.getSystemService("location");
            }
            if (a.this.f32453d == null) {
                a.this.f32450a.getResources();
            }
            int i7 = this.f32459a;
            if (i7 == -1) {
                com.jiao.project.bluetoothofabroadwasherapp.utils.a.d(a.this.f32450a);
                b.c(a.this.f32454e, "ToSettingLinsenter=4");
                return;
            }
            if (i7 != 0) {
                new com.jiao.project.bluetoothofabroadwasherapp.utils.a().b(a.this.f32450a, 1007, new String[0]);
                return;
            }
            if (!a.this.f32456g.isProviderEnabled("network") && !a.this.f32456g.isProviderEnabled("gps")) {
                b.c(a.this.f32454e, "ToSettingLinsenter=3");
                Intent intent = new Intent();
                intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
                intent.setFlags(268435456);
                a.this.f32450a.startActivityForResult(intent, 1007);
                return;
            }
            boolean zB = new com.jiao.project.bluetoothofabroadwasherapp.utils.a().b(a.this.f32450a, 1007, new String[0]);
            b.c(a.this.f32454e, "ToSettingLinsenter=2");
            b.c(a.this.f32454e, "-----AppPermissions().getPermissions=" + zB);
        }
    }

    public void i() {
        AlertDialog alertDialog = f32447j;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        f32447j.dismiss();
        f32447j = null;
    }

    public boolean j() {
        AlertDialog alertDialog = f32447j;
        return alertDialog != null && alertDialog.isShowing();
    }

    public void k(ArrayList<String> arrayList, View.OnClickListener... onClickListenerArr) {
        View view;
        if (f32447j == null || arrayList == null || arrayList.size() <= 0 || (view = this.f32451b) == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.llt_buttons);
        this.f32452c = linearLayout;
        linearLayout.removeAllViews();
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            View viewInflate = View.inflate(this.f32450a, R.layout.popupwindow_button, null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            layoutParams.leftMargin = 10;
            layoutParams.rightMargin = 10;
            TextView textView = (TextView) viewInflate.findViewById(R.id.font_button_id);
            textView.setText(arrayList.get(i7));
            textView.setOnClickListener(onClickListenerArr[i7]);
            this.f32452c.addView(viewInflate, layoutParams);
        }
    }

    public void l(Activity activity, String str, ArrayList<String> arrayList, View.OnClickListener... onClickListenerArr) {
        Activity activity2 = (Activity) new WeakReference(activity).get();
        this.f32450a = activity2;
        if (this.f32453d == null) {
            activity2.getResources();
        }
        if (this.f32450a == null) {
            return;
        }
        if (f32447j == null) {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this.f32450a, android.R.style.Theme.Material.Light.Dialog.Alert).create();
            f32447j = alertDialogCreate;
            alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable());
            f32447j.setCanceledOnTouchOutside(true);
            View viewInflate = View.inflate(this.f32450a, R.layout.popupwindow_util, null);
            this.f32451b = viewInflate;
            f32447j.setView(viewInflate, 0, 0, 0, 0);
        }
        if (this.f32451b == null) {
            View viewInflate2 = View.inflate(this.f32450a, R.layout.popupwindow_util, null);
            this.f32451b = viewInflate2;
            f32447j.setView(viewInflate2, 0, 0, 0, 0);
        }
        TextView textView = (TextView) this.f32451b.findViewById(R.id.font_button_id);
        this.f32455f = textView;
        textView.setText(str);
        if (arrayList != null && arrayList.size() > 0) {
            LinearLayout linearLayout = (LinearLayout) this.f32451b.findViewById(R.id.llt_buttons);
            this.f32452c = linearLayout;
            linearLayout.removeAllViews();
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                View viewInflate3 = View.inflate(this.f32450a, R.layout.popupwindow_button, null);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                layoutParams.weight = 1.0f;
                layoutParams.leftMargin = 10;
                layoutParams.rightMargin = 10;
                TextView textView2 = (TextView) viewInflate3.findViewById(R.id.font_button_id);
                textView2.setText(arrayList.get(i7));
                textView2.setOnClickListener(onClickListenerArr[i7]);
                this.f32452c.addView(viewInflate3, layoutParams);
            }
        }
        f32447j.setCancelable(false);
        Activity activity3 = this.f32450a;
        if (activity3 == null || activity3.isFinishing() || f32447j.isShowing()) {
            return;
        }
        try {
            f32447j.show();
        } catch (Exception e8) {
            Log.i(this.f32454e, "PopupWindowUtil.showOptionDialog.error=" + e8.toString());
            i.d(this.f32450a, "内存泄漏了");
        }
    }
}
