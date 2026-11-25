package org.chromium.net.impl;

import android.annotation.SuppressLint;
import com.haier.uhome.account.api.Const;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class a extends org.chromium.net.n.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f39314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f39315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final org.chromium.net.d.b f39316h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Executor f39317i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ArrayList<Map.Entry<String, String>> f39318j = new ArrayList<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f39319k = Const.HTTP_REQUEST_TYPE_POST;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f39320l = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f39321m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Collection<Object> f39322n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f39323o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f39324p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f39325q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f39326r;

    a(String str, org.chromium.net.d.b bVar, Executor executor, d dVar) {
        if (str == null) {
            throw new NullPointerException("URL is required.");
        }
        if (bVar == null) {
            throw new NullPointerException("Callback is required.");
        }
        if (executor == null) {
            throw new NullPointerException("Executor is required.");
        }
        if (dVar == null) {
            throw new NullPointerException("CronetEngine is required.");
        }
        this.f39315g = str;
        this.f39316h = bVar;
        this.f39317i = executor;
        this.f39314f = dVar;
    }

    @Override // org.chromium.net.n.a
    public org.chromium.net.n.a g(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Invalid metrics annotation.");
        }
        if (this.f39322n == null) {
            this.f39322n = new ArrayList();
        }
        this.f39322n.add(obj);
        return this;
    }

    @Override // org.chromium.net.n.a, org.chromium.net.d.a
    @SuppressLint({"WrongConstant"})
    /* JADX INFO: renamed from: h */
    public org.chromium.net.n b() {
        return this.f39314f.y(this.f39315g, this.f39316h, this.f39317i, this.f39319k, this.f39318j, this.f39320l, this.f39321m, this.f39322n, this.f39323o, this.f39324p, this.f39325q, this.f39326r);
    }

    @Override // org.chromium.net.n.a
    public org.chromium.net.n.a l(int i7) {
        this.f39323o = true;
        this.f39324p = i7;
        return this;
    }

    @Override // org.chromium.net.n.a
    public org.chromium.net.n.a m(int i7) {
        this.f39325q = true;
        this.f39326r = i7;
        return this;
    }

    @Override // org.chromium.net.n.a
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public a a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.f39318j.add(new AbstractMap.SimpleImmutableEntry(str, str2));
        return this;
    }

    @Override // org.chromium.net.n.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public a c(boolean z7) {
        this.f39321m = z7;
        return this;
    }

    @Override // org.chromium.net.n.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public a d(String str) {
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.f39319k = str;
        return this;
    }

    @Override // org.chromium.net.n.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public a e(int i7) {
        this.f39320l = i7;
        return this;
    }
}
