package com.haier.globalwasher.mvp_api.volley;

/* JADX INFO: loaded from: classes2.dex */
public class u extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f25043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f25044b;

    public u() {
        this.f25043a = null;
    }

    public long a() {
        return this.f25044b;
    }

    void b(long j7) {
        this.f25044b = j7;
    }

    public u(j jVar) {
        this.f25043a = jVar;
    }

    public u(String str) {
        super(str);
        this.f25043a = null;
    }

    public u(String str, Throwable th) {
        super(str, th);
        this.f25043a = null;
    }

    public u(Throwable th) {
        super(th);
        this.f25043a = null;
    }
}
