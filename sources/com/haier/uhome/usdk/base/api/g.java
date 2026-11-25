package com.haier.uhome.usdk.base.api;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f31183a;

    public class a extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f31184b = 0;

        a() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && super.equals(obj) && this.f31184b == ((a) obj).f31184b;
        }

        public int hashCode() {
            return this.f31184b;
        }

        synchronized void t() {
            this.f31184b++;
        }

        protected synchronized void u() {
            this.f31184b--;
        }

        synchronized boolean v() {
            return true;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static g f31186a = new g();

        private b() {
        }
    }

    public static g a() {
        return b.f31186a;
    }

    public f b(String str) {
        if (TextUtils.isEmpty(str)) {
            e3.a.h("try to retain device with empty device id=%s", str);
            return null;
        }
        f fVarA = a(str, true);
        if (fVarA == null) {
            e3.a.f("try to retain a device but fail!! deviceId=%s%s", str, e3.a.k(5), new Object[0]);
        }
        if (fVarA instanceof a) {
            e3.a.e("map size : %d retain device id : %s reference : %d%s", Integer.valueOf(this.f31183a.size()), str, Integer.valueOf(((a) fVarA).f31184b), e3.a.k(5));
        }
        return fVarA;
    }

    public synchronized boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            e3.a.h("try to release device with empty device id=%s", str);
            return false;
        }
        a aVarRemove = this.f31183a.get(str);
        if (aVarRemove == null) {
            e3.a.f("try to release a non existent device info deviceId=%s%s", str, e3.a.k(5), new Object[0]);
            return true;
        }
        aVarRemove.u();
        if (!aVarRemove.v()) {
            aVarRemove = this.f31183a.remove(str);
            aVarRemove.f31124a.a();
        }
        e3.a.e("map size : %d release device id : %s reference : %d%s", Integer.valueOf(this.f31183a.size()), str, Integer.valueOf(aVarRemove.f31184b), e3.a.k(5));
        return true;
    }

    private g() {
        this.f31183a = new ConcurrentHashMap<>();
    }

    public f a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return a(str, false);
        }
        e3.a.h("try to get device with empty device id=%s", str);
        return null;
    }

    public String a(int i7) {
        if (i7 <= 0) {
            return null;
        }
        for (a aVar : this.f31183a.values()) {
            if (aVar.s().a() == i7) {
                return aVar.b();
            }
        }
        e3.a.e("getDevIdWithElementAddr<%d> fail!", Integer.valueOf(i7));
        return null;
    }

    private synchronized f a(String str, boolean z7) {
        if (TextUtils.isEmpty(str)) {
            e3.a.h("try to newOrRetainDevice device with empty device id=%s", str);
            return null;
        }
        a aVar = this.f31183a.get(str);
        if (aVar == null) {
            aVar = new a();
            aVar.a(str);
            this.f31183a.put(str, aVar);
        }
        if (z7) {
            aVar.t();
        }
        return aVar;
    }
}
