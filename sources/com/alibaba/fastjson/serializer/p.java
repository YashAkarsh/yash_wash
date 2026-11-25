package com.alibaba.fastjson.serializer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f13155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.alibaba.fastjson.util.e f13156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f13157c;

    public p(Class<?> cls, com.alibaba.fastjson.util.e eVar) {
        this.f13155a = cls;
        this.f13156b = eVar;
        this.f13157c = eVar.i();
    }

    public <T extends Annotation> T a(Class<T> cls) {
        return (T) this.f13156b.d(cls);
    }

    public Class<?> b() {
        return this.f13155a;
    }

    public int c() {
        return this.f13156b.f13301i;
    }

    public Field d() {
        return this.f13156b.f13295c;
    }

    public Class<?> e() {
        return this.f13156b.f13297e;
    }

    public Type f() {
        return this.f13156b.f13298f;
    }

    public String g() {
        return this.f13157c;
    }

    public String h() {
        return this.f13156b.f13303k;
    }

    public Method i() {
        return this.f13156b.f13294b;
    }

    public String j() {
        return this.f13156b.f13293a;
    }

    public boolean k() {
        return this.f13156b.f13310r;
    }
}
