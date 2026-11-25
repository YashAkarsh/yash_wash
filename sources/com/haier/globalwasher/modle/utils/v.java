package com.haier.globalwasher.modle.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.viewpager.widget.ViewPager;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.e.c;
import com.haier.globalwasher.view.activity.MainActivity;
import com.haier.globalwasher.view.activity.SplashActivity;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static AlertDialog f24710m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long f24711n = 1000;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f24712o = 10.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BaseActivity f24713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f24714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f24715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Resources f24716d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    FontTextView f24718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ViewPager f24719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LinearLayout f24720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LocationManager f24721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LocationListener f24722j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private BaseActivity f24723k;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f24717e = "GsonRequest";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    String f24724l = null;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.f24710m.dismiss();
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener[] f24726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f24727b;

        b(View.OnClickListener[] onClickListenerArr, int i7) {
            this.f24726a = onClickListenerArr;
            this.f24727b = i7;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.f24710m.dismiss();
            this.f24726a[this.f24727b].onClick(view);
        }
    }

    class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PopupWindow f24729a;

        c(PopupWindow popupWindow) {
            this.f24729a = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f24729a.dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (v.this.f24713a == null || v.this.f24713a.isFinishing()) {
                return;
            }
            v.f24710m.dismiss();
            MyApplication.e();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        private void a(BaseActivity baseActivity) {
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", baseActivity.getPackageName(), null));
                baseActivity.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
            }
        }

        public void b(BaseActivity baseActivity) {
            v.this.f24723k = baseActivity;
            v.this.f24716d = baseActivity.getResources();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.f24710m.dismiss();
            if (v.this.f24721i == null) {
                v vVar = v.this;
                vVar.f24721i = (LocationManager) vVar.f24723k.getSystemService("location");
            }
            if (v.this.f24722j == null) {
                v vVar2 = v.this;
                vVar2.f24722j = new com.haier.globalwasher.modle.e(vVar2.f24723k).new c();
            }
            if (v.this.f24716d == null) {
                v vVar3 = v.this;
                vVar3.f24716d = vVar3.f24713a.getResources();
            }
            q.c(v.this.f24717e, "ToSettingLinsenter=1");
            if (!v.this.f24721i.isProviderEnabled("network")) {
                q.c(v.this.f24717e, "ToSettingLinsenter=3");
                v.this.f24716d.getString(R.string.pop_title_network);
                Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                intent.setFlags(268435456);
                v.this.f24723k.startActivity(intent);
                return;
            }
            if (androidx.core.content.d.a(v.this.f24723k, "android.permission.ACCESS_FINE_LOCATION") != 0 && androidx.core.content.d.a(v.this.f24723k, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                q.c(v.this.f24717e, "ToSettingLinsenter=2");
                a(v.this.f24723k);
                return;
            }
            v.this.f24721i.requestLocationUpdates("network", 1000L, 10.0f, v.this.f24722j);
            if (v.this.f24723k instanceof SplashActivity) {
                v.this.f24723k.startActivity(new Intent(v.this.f24723k, (Class<?>) MainActivity.class));
                v.this.f24723k.finish();
            }
        }
    }

    public static void k(Activity activity, View view, View view2) {
        View viewInflate = View.inflate((Context) new SoftReference(activity).get(), R.layout.popupwindow_util_buttom, null);
        PopupWindow popupWindow = new PopupWindow(viewInflate);
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.fly_content);
        if (view != null) {
            frameLayout.addView(view);
        }
        popupWindow.setWidth(-1);
        popupWindow.setHeight(-1);
        popupWindow.setFocusable(true);
        popupWindow.setAnimationStyle(R.style.popupAnimation);
        popupWindow.setBackgroundDrawable(new ColorDrawable(-1342177280));
        popupWindow.showAtLocation(viewInflate, 80, 0, 0);
        if (view2 != null) {
            view2.setOnClickListener(new c(popupWindow));
        }
    }

    public void l(BaseActivity baseActivity, String str, ArrayList<String> arrayList, View.OnClickListener... onClickListenerArr) {
        BaseActivity baseActivity2 = (BaseActivity) new WeakReference(baseActivity).get();
        this.f24713a = baseActivity2;
        if (this.f24716d == null) {
            baseActivity2.getResources();
        }
        if (this.f24713a == null) {
            i0.d(MyApplication.k(), "context is NULL");
            return;
        }
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this.f24713a).create();
        f24710m = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(this.f24713a.getResources().getDrawable(R.drawable.cardview_background_left5));
        View viewInflate = View.inflate(this.f24713a, R.layout.popupwindow_util, null);
        this.f24714b = viewInflate;
        f24710m.setView(viewInflate);
        FontTextView fontTextView = (FontTextView) this.f24714b.findViewById(R.id.font_button_id);
        this.f24718f = fontTextView;
        fontTextView.setText(str);
        if (arrayList != null && arrayList.size() > 0) {
            LinearLayout linearLayout = (LinearLayout) this.f24714b.findViewById(R.id.llt_buttons);
            this.f24715c = linearLayout;
            linearLayout.removeAllViews();
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                View viewInflate2 = View.inflate(this.f24713a, R.layout.popupwindow_button, null);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                layoutParams.weight = 1.0f;
                layoutParams.leftMargin = 10;
                layoutParams.rightMargin = 10;
                FontTextView fontTextView2 = (FontTextView) viewInflate2.findViewById(R.id.font_button_id);
                fontTextView2.setText(arrayList.get(i7));
                if (onClickListenerArr == null || onClickListenerArr[i7] == null) {
                    fontTextView2.setOnClickListener(new a());
                } else {
                    fontTextView2.setOnClickListener(new b(onClickListenerArr, i7));
                }
                this.f24715c.addView(viewInflate2, layoutParams);
            }
        }
        f24710m.setCancelable(false);
        BaseActivity baseActivity3 = this.f24713a;
        if (baseActivity3 != null && !baseActivity3.isFinishing() && !f24710m.isShowing()) {
            f24710m.show();
            baseActivity.L(f24710m);
        }
        Window window = f24710m.getWindow();
        Display defaultDisplay = this.f24713a.getWindowManager().getDefaultDisplay();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.95d);
            attributes.gravity = 17;
            window.setAttributes(attributes);
            window.setBackgroundDrawable(new ColorDrawable());
        }
    }
}
