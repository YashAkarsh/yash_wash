package com.jiao.project.bluetoothofabroadwasherapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import androidx.core.content.d;
import com.haier.hailicommontlib.mvp.model.utils.b;
import com.jiao.project.bluetoothofabroadwasherapp.R;
import com.jiao.project.bluetoothofabroadwasherapp.utils.viewutils.a.ViewOnClickListenerC0390a;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f32367d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f32368e = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    LocationManager f32373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.jiao.project.bluetoothofabroadwasherapp.utils.viewutils.a f32374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String[] f32366c = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f32369f = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static ArrayList<String> f32370g = new ArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f32371h = "AppPermissions";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f32372i = "AppPermissions__";

    public static Map<String, Integer> a(Context context, String... strArr) {
        SoftReference softReference = new SoftReference(context);
        if (strArr == null || strArr.length <= 0) {
            strArr = f32366c;
        }
        f32370g.clear();
        HashMap map = new HashMap();
        for (String str : strArr) {
            String str2 = str + "";
            int iA = d.a((Context) softReference.get(), str2);
            b.c(f32372i, str2 + "====" + iA);
            if (iA != 0) {
                b.c(f32372i, str2 + "==......==" + iA);
                map.put(str2, Integer.valueOf(iA));
                f32370g.add(str2);
            }
        }
        return map;
    }

    public static void d(Activity activity) {
        SoftReference softReference = new SoftReference(activity);
        Intent intent = new Intent();
        String packageName = ((Activity) softReference.get()).getPackageName();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", packageName, null));
        ((Activity) softReference.get()).startActivityForResult(intent, 1007);
    }

    public static void f(Activity activity, String[] strArr, int i7) {
        androidx.core.app.b.G((Activity) new WeakReference(activity).get(), strArr, i7);
    }

    private static void g(Context context, String str) {
        WeakReference weakReference = new WeakReference(context);
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("tel:" + str));
        ((Context) weakReference.get()).startActivity(intent);
    }

    public boolean b(Activity activity, int i7, String... strArr) {
        SoftReference softReference = new SoftReference(activity);
        a((Context) softReference.get(), strArr);
        b.c(f32371h, "getPermissions  mPermissionList.size()=" + f32370g.size());
        if (f32370g.size() <= 0) {
            return false;
        }
        ArrayList<String> arrayList = f32370g;
        androidx.core.app.b.G((Activity) softReference.get(), (String[]) arrayList.toArray(new String[arrayList.size()]), i7);
        return true;
    }

    public void c(Activity activity, int i7) {
        b.c(f32371h, "");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("恩准了");
        if (this.f32374b == null) {
            this.f32374b = new com.jiao.project.bluetoothofabroadwasherapp.utils.viewutils.a();
        }
        com.jiao.project.bluetoothofabroadwasherapp.utils.viewutils.a aVar = this.f32374b;
        Objects.requireNonNull(aVar);
        com.jiao.project.bluetoothofabroadwasherapp.utils.viewutils.a.ViewOnClickListenerC0390a viewOnClickListenerC0390a = aVar.new ViewOnClickListenerC0390a(i7);
        viewOnClickListenerC0390a.a(activity);
        if (this.f32374b.j()) {
            this.f32374b.k(arrayList, viewOnClickListenerC0390a);
        } else {
            this.f32374b.l(activity, activity.getResources().getString(R.string.permissions_title), arrayList, viewOnClickListenerC0390a);
        }
    }

    public void e() {
        com.jiao.project.bluetoothofabroadwasherapp.utils.viewutils.a aVar = this.f32374b;
        if (aVar == null || !aVar.j()) {
            return;
        }
        this.f32374b.i();
    }
}
