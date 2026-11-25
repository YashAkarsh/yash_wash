package com.haier.library.sumhttp.plugin;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f27944a = 10001;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f27945b = 10002;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f27946c = 10003;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f27947d = 200;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f27948e = 10000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private T f27949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f27950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f27951h;

    public abstract T a(String str) throws c;

    public void a(int i7, String str) {
        this.f27950g = i7;
        this.f27951h = str;
    }

    public String b() {
        return this.f27951h;
    }

    public T c() {
        return this.f27949f;
    }

    public void a(T t7) {
        this.f27950g = 200;
        this.f27949f = t7;
        this.f27951h = "completed";
    }

    public int a() {
        return this.f27950g;
    }

    public T a(com.haier.library.okhttp.a aVar) {
        this.f27950g = aVar.u();
        this.f27951h = aVar.g0();
        if (this.f27950g != 200) {
            return null;
        }
        try {
            T tA = a(aVar.b());
            this.f27949f = tA;
            return tA;
        } catch (c | IOException e8) {
            this.f27950g = f27945b;
            this.f27951h = e8.getMessage();
            return null;
        }
    }

    protected T a(com.haier.library.okhttp.b bVar) throws c, IOException {
        if (bVar == null) {
            return null;
        }
        String strQ = bVar.Q();
        e3.a.e("body:" + strQ, new Object[0]);
        return a(strQ);
    }
}
