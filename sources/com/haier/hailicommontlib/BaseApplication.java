package com.haier.hailicommontlib;

import android.app.Application;
import android.content.Context;
import androidx.multidex.b;
import com.haier.hailicommontlib.mvp.model.interfaces.IBaseApplication;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class BaseApplication extends Application {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static BaseApplication f26152c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f26153d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f26154e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f26155f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f26156a = "BaseApplication";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<IBaseApplication> f26157b = new ArrayList<>();

    private void a() {
        int i7 = 0;
        while (true) {
            ArrayList<IBaseApplication> arrayList = this.f26157b;
            if (arrayList == null || i7 >= arrayList.size()) {
                return;
            }
            this.f26157b.get(i7).b(this);
            i7++;
        }
    }

    public static BaseApplication b() {
        return f26152c;
    }

    private void c() {
        for (int i7 = 0; i7 < a3.a.a().length; i7++) {
            this.f26157b.add((IBaseApplication) com.alibaba.android.arouter.launcher.a.i().c(a3.a.a()[i7]).navigation());
        }
    }

    private void d() {
        if (!f26153d) {
            com.alibaba.android.arouter.launcher.a.q();
            com.alibaba.android.arouter.launcher.a.p();
        }
        com.alibaba.android.arouter.launcher.a.j(this);
        c();
        a();
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        b.l(this);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        try {
            f26152c = this;
            d();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        com.alibaba.android.arouter.launcher.a.i().g();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i7) {
        super.onTrimMemory(i7);
    }
}
