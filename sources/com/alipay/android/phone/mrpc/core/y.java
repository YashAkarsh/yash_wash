package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class y implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected g f13494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Class<?> f13495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected z f13496c;

    public y(g gVar, Class<?> cls, z zVar) {
        this.f13494a = gVar;
        this.f13495b = cls;
        this.f13496c = zVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return this.f13496c.a(method, objArr);
    }
}
