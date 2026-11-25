package org.chromium.net.impl;

import c.o0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.Collections;
import org.chromium.net.k0;
import org.chromium.net.u0;

/* JADX INFO: loaded from: classes3.dex */
public class q extends k0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f39398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Collection<Object> f39399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k0.b f39400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f39401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @o0
    private final u0 f39402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    private final org.chromium.net.k f39403i;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public q(String str, Collection<Object> collection, k0.b bVar, int i7, @o0 u0 u0Var, @o0 org.chromium.net.k kVar) {
        this.f39398d = str;
        this.f39399e = collection;
        this.f39400f = bVar;
        this.f39401g = i7;
        this.f39402h = u0Var;
        this.f39403i = kVar;
    }

    @Override // org.chromium.net.k0
    public Collection<Object> a() {
        Collection<Object> collection = this.f39399e;
        return collection == null ? Collections.emptyList() : collection;
    }

    @Override // org.chromium.net.k0
    @o0
    public org.chromium.net.k b() {
        return this.f39403i;
    }

    @Override // org.chromium.net.k0
    public int c() {
        return this.f39401g;
    }

    @Override // org.chromium.net.k0
    public k0.b d() {
        return this.f39400f;
    }

    @Override // org.chromium.net.k0
    @o0
    public u0 e() {
        return this.f39402h;
    }

    @Override // org.chromium.net.k0
    public String f() {
        return this.f39398d;
    }
}
