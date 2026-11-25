package com.paytm.pgsdk;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static q f33090c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l f33091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f33092b;

    private q() {
    }

    public static synchronized q a() {
        if (f33090c == null) {
            f33090c = new q();
        }
        return f33090c;
    }

    public l b() {
        return this.f33091a;
    }

    public boolean c() {
        return this.f33092b;
    }

    public void d(l lVar) {
        this.f33091a = lVar;
    }

    public void e(boolean z7) {
        this.f33092b = z7;
    }
}
