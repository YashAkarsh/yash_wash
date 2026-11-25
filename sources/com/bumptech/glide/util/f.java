package com.bumptech.glide.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f<T, Y> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14926c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<T, Y> f14924a = new LinkedHashMap<>(100, 0.75f, true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14927d = 0;

    public f(int i7) {
        this.f14926c = i7;
        this.f14925b = i7;
    }

    private void j() {
        p(this.f14925b);
    }

    public void a(float f8) {
        if (f8 < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.f14925b = Math.round(this.f14926c * f8);
        j();
    }

    public int b() {
        return this.f14927d;
    }

    public int c() {
        return this.f14925b;
    }

    public void f() {
        p(0);
    }

    public boolean i(T t7) {
        return this.f14924a.containsKey(t7);
    }

    public Y k(T t7) {
        return this.f14924a.get(t7);
    }

    protected int l(Y y7) {
        return 1;
    }

    protected void m(T t7, Y y7) {
    }

    public Y n(T t7, Y y7) {
        if (l(y7) >= this.f14925b) {
            m(t7, y7);
            return null;
        }
        Y yPut = this.f14924a.put(t7, y7);
        if (y7 != null) {
            this.f14927d += l(y7);
        }
        if (yPut != null) {
            this.f14927d -= l(yPut);
        }
        j();
        return yPut;
    }

    public Y o(T t7) {
        Y yRemove = this.f14924a.remove(t7);
        if (yRemove != null) {
            this.f14927d -= l(yRemove);
        }
        return yRemove;
    }

    protected void p(int i7) {
        while (this.f14927d > i7) {
            Map.Entry<T, Y> next = this.f14924a.entrySet().iterator().next();
            Y value = next.getValue();
            this.f14927d -= l(value);
            T key = next.getKey();
            this.f14924a.remove(key);
            m(key, value);
        }
    }
}
