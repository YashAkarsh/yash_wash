package com.google.common.eventbus;

import com.google.common.base.e0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f21569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f21570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f21571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Method f21572d;

    h(e eVar, Object obj, Object obj2, Method method) {
        this.f21569a = (e) e0.E(eVar);
        this.f21570b = e0.E(obj);
        this.f21571c = e0.E(obj2);
        this.f21572d = (Method) e0.E(method);
    }

    public Object a() {
        return this.f21570b;
    }

    public e b() {
        return this.f21569a;
    }

    public Object c() {
        return this.f21571c;
    }

    public Method d() {
        return this.f21572d;
    }
}
