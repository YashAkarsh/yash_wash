package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f13492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private z f13493b = new z(this);

    public x(g gVar) {
        this.f13492a = gVar;
    }

    public final g a() {
        return this.f13492a;
    }

    public final <T> T a(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new y(this.f13492a, cls, this.f13493b));
    }
}
