package com.haier.globalwasher;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.CountDownBeen;
import com.haier.globalwasher.modle.enum_.e;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.h;
import com.haier.globalwasher.mvp_api.volley.myvolley.d;
import com.haier.hailicommontlib.BaseApplication;
import com.haier.uhome.usdk.api.interfaces.IuSDKCallback;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKErrorConst;
import com.haier.uhome.usdk.api.uSDKLogLevelConst;
import com.haier.uhome.usdk.api.uSDKManager;
import com.haier.uhome.usdk.api.uSDKStartOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MyApplication extends BaseApplication {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static ArrayList<BaseActivity> f24251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static MyApplication f24252h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f24256l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static uSDKStartOptions f24260p;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Bitmap.CompressFormat f24253i = Bitmap.CompressFormat.PNG;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f24254j = 100;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static ArrayList<CountDownBeen> f24255k = new ArrayList<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f24257m = BaseApplication.f26154e;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f24258n = BaseApplication.f26153d;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f24259o = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static Map<String, h> f24261q = new HashMap();

    class a implements IuSDKCallback {
        a() {
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
        public void onCallback(uSDKErrorConst usdkerrorconst) {
        }
    }

    class b implements IuSDKCallback {
        b() {
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
        public void onCallback(uSDKErrorConst usdkerrorconst) {
        }
    }

    public static void e() {
        uSDKManager.getSingleInstance().stopSDK(new b());
        if (f24251g != null) {
            for (int i7 = 0; i7 < f24251g.size(); i7++) {
                f24251g.get(i7).finish();
            }
        }
        f24251g.clear();
        f24251g = null;
        System.exit(0);
    }

    public static void f(BaseActivity baseActivity) {
        if (f24251g == null) {
            f24251g = new ArrayList<>();
        }
        f24251g.add(baseActivity);
    }

    public static int g(CountDownBeen countDownBeen) {
        int i7 = 1;
        for (int i8 = 0; i8 < f24255k.size(); i8++) {
            if (f24255k.get(i8).equals(countDownBeen)) {
                i7 = 0;
            }
        }
        if (i7 == 1) {
            f24255k.add(countDownBeen);
        }
        return i7;
    }

    public static void i(Class<?> cls) {
        ArrayList<BaseActivity> arrayList = f24251g;
        if (arrayList != null) {
            for (BaseActivity baseActivity : arrayList) {
                if (baseActivity.getClass().equals(cls) && !baseActivity.isFinishing()) {
                    baseActivity.finish();
                }
            }
        }
    }

    public static ArrayList<BaseActivity> j() {
        if (f24251g == null) {
            f24251g = new ArrayList<>();
        }
        return f24251g;
    }

    public static MyApplication k() {
        return f24252h;
    }

    public static ArrayList<CountDownBeen> l() {
        return f24255k;
    }

    private void m() {
        d.d().f(this, getPackageCodePath(), f24253i, f24254j, d.b.DISK);
        f24256l = true;
    }

    public static boolean o() {
        return f24256l;
    }

    public static void p(BaseActivity baseActivity) {
        if (f24251g == null) {
            f24251g = new ArrayList<>();
        }
        f24251g.remove(baseActivity);
    }

    public static void q(CountDownBeen countDownBeen) {
        f24255k.remove(countDownBeen);
    }

    public static int r(CountDownBeen countDownBeen) {
        for (int i7 = 0; i7 < f24255k.size(); i7++) {
            if (f24255k.get(i7).equals(countDownBeen)) {
                f24255k.remove(countDownBeen);
                f24255k.add(countDownBeen);
            }
        }
        return 1;
    }

    public static void s(CountDownBeen countDownBeen) {
        e eVar = e.NO_PAY_OUT_TIME;
        if (eVar.b() != countDownBeen.getStatuId()) {
            e eVar2 = e.ORDER_CENCEL;
            if (eVar2.b() != countDownBeen.getStatuId()) {
                if (g(countDownBeen) == 1) {
                    h hVar = new h(countDownBeen, k());
                    f24261q.put(countDownBeen.getWashOrderId(), hVar);
                    hVar.start();
                    return;
                }
                if ((countDownBeen.getStatuId() <= 0 && countDownBeen.getOverTime() <= 0) || eVar.b() == countDownBeen.getStatuId() || eVar2.b() == countDownBeen.getStatuId()) {
                    f24261q.remove(countDownBeen.getWashOrderId());
                    q(countDownBeen);
                    return;
                } else if (f24261q.get(countDownBeen.getWashOrderId()).f24612c) {
                    f24261q.get(countDownBeen.getWashOrderId()).f24610a.setStatuId(countDownBeen.getStatuId());
                    f24261q.get(countDownBeen.getWashOrderId()).f24610a.setOverTime(countDownBeen.getOverTime());
                    f24261q.get(countDownBeen.getWashOrderId()).f24610a.setClearbucketCountDownTime(countDownBeen.getClearbucketCountDownTime());
                    return;
                } else {
                    h hVar2 = new h(countDownBeen, k());
                    f24261q.put(countDownBeen.getWashOrderId(), hVar2);
                    r(countDownBeen);
                    hVar2.start();
                    return;
                }
            }
        }
        f24261q.remove(countDownBeen.getWashOrderId());
        q(countDownBeen);
    }

    public static void t() {
        f24256l = false;
    }

    public void h(Context context, String str) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        str.hashCode();
        if (str.equals("en")) {
            configuration.locale = Locale.ENGLISH;
        } else if (str.equals("zh")) {
            configuration.locale = Locale.CHINESE;
        }
        resources.updateConfiguration(configuration, displayMetrics);
    }

    public void n() {
        uSDKManager singleInstance = uSDKManager.getSingleInstance();
        singleInstance.init(this);
        uSDKDeviceManager.getSingleInstance().setKeepLocalOnline(false);
        singleInstance.initLog(uSDKLogLevelConst.USDK_LOG_DEBUG, true, new a());
        f24260p = new uSDKStartOptions.Builder().setAppID("MB-SHEXYANDROIDGJ-0000").setAppKey("0857215df9dbf3a2efa00817fd18f276").setFeatures(uSDKManager.SDK_FEATURE_NONE).setArea(3).build();
    }

    @Override // com.haier.hailicommontlib.BaseApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        f24252h = this;
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        m();
        n();
        if (f24259o) {
            String strA = t2.a.a(this, t2.a.f40362i, t2.a.f40368o);
            if (d0.j(strA)) {
                f24258n = "1".equals(strA);
            }
        }
    }
}
