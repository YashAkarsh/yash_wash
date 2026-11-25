package com.haier.uhome.trace.a;

import android.content.Context;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f30224b = "com.haier.uhome.uAnalytics.MobEvent";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f30225c = "onTraceEvent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Method f30226a;

    /* JADX INFO: renamed from: com.haier.uhome.trace.a.a$a, reason: collision with other inner class name */
    private static class C0374a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f30227a = new a();

        private C0374a() {
        }
    }

    public static a a() {
        return C0374a.f30227a;
    }

    private Method b() {
        Method method = this.f30226a;
        if (method != null) {
            return method;
        }
        try {
            this.f30226a = Class.forName(f30224b).getDeclaredMethod(f30225c, Context.class, String.class, HashMap.class);
        } catch (Exception e8) {
            e3.a.v("getSendEventMethod excp -> %s", e8);
        }
        return this.f30226a;
    }

    public boolean a(Context context, String str, Map<String, String> map) {
        Method methodB = b();
        if (methodB == null) {
            e3.a.v("reflect send function error", new Object[0]);
            return false;
        }
        try {
            if (!methodB.isAccessible()) {
                methodB.setAccessible(true);
            }
            methodB.invoke(null, context, str, map);
            return true;
        } catch (Exception e8) {
            e3.a.v("sendEvent excp -> %s", e8);
            return false;
        }
    }
}
