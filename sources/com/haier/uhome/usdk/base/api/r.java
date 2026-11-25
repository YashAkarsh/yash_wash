package com.haier.uhome.usdk.base.api;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31223a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f31224b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f31225c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f31226d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<p> f31227e;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static r f31228a = new r();

        private a() {
        }
    }

    public static r a() {
        return a.f31228a;
    }

    public ErrorConst b() {
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        if (contextB != null) {
            try {
                ((Application) contextB).registerActivityLifecycleCallbacks(com.haier.uhome.usdk.base.service.a.a());
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                contextB.registerReceiver(com.haier.uhome.usdk.base.service.f.a(), intentFilter);
            } catch (Exception e8) {
                e3.a.h("registerReceiver<%s> exception<%s>", com.haier.uhome.usdk.base.service.f.a(), e8.getMessage());
            }
        }
        return com.haier.uhome.usdk.base.service.d.p().r();
    }

    public uSDKError c() {
        return com.haier.uhome.usdk.base.service.d.p().q();
    }

    public ErrorConst d() {
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        if (contextB != null) {
            ((Application) contextB).unregisterActivityLifecycleCallbacks(com.haier.uhome.usdk.base.service.a.a());
            contextB.unregisterReceiver(com.haier.uhome.usdk.base.service.f.a());
        }
        return com.haier.uhome.usdk.base.service.d.p().s();
    }

    public String e() {
        return VersionManager.getInstance().getSDKVersion();
    }

    public String f() {
        return VersionManager.getInstance().getSDKReleaseDate();
    }

    public synchronized List<p> g() {
        return new ArrayList(this.f31227e);
    }

    private r() {
        this.f31227e = new ArrayList();
    }

    public void a(o oVar) {
        com.haier.uhome.usdk.base.service.d.p().e(oVar);
    }

    public synchronized void a(p pVar) {
        if (pVar != null) {
            this.f31227e.add(pVar);
        }
    }

    public synchronized void b(p pVar) {
        if (pVar != null) {
            this.f31227e.remove(pVar);
        }
    }
}
