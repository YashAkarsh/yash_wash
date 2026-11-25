package com.haier.library.common.b;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f26449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f26450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f26451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f26452d;

    public long a() {
        return this.f26449a;
    }

    public void b(double d8) {
        this.f26451c = d8;
    }

    public void c(long j7) {
        this.f26449a = j7;
    }

    public void d(String str) {
        this.f26452d = str;
    }

    public long e() {
        return this.f26450b;
    }

    public void f(long j7) {
        this.f26450b = j7;
    }

    public double g() {
        return this.f26451c;
    }

    public String h() {
        return this.f26452d;
    }

    public String toString() {
        return "SinglePingResult{startTime=" + this.f26449a + ", receiveTime=" + this.f26450b + ", timeUse=" + this.f26451c + ", error='" + this.f26452d + "'}";
    }
}
