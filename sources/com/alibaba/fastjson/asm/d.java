package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    d f12564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12567d;

    public d(c cVar, int i7, String str, String str2) {
        if (cVar.f12560p == null) {
            cVar.f12560p = this;
        } else {
            cVar.f12561q.f12564a = this;
        }
        cVar.f12561q = this;
        this.f12565b = i7;
        this.f12566c = cVar.h(str);
        this.f12567d = cVar.h(str2);
    }

    int a() {
        return 8;
    }

    void b(a aVar) {
        aVar.g(this.f12565b & (-393217)).g(this.f12566c).g(this.f12567d);
        aVar.g(0);
    }

    public void c() {
    }
}
