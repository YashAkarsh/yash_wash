package com.haier.globalwasher.mvp_api.volley;

/* JADX INFO: loaded from: classes2.dex */
public class p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f24943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.haier.globalwasher.mvp_api.volley.b.a f24944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f24945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f24946d;

    public interface a {
        void c(u uVar);
    }

    public interface b<T> {
        void b(T t7);
    }

    private p(T t7, com.haier.globalwasher.mvp_api.volley.b.a aVar) {
        this.f24946d = false;
        this.f24943a = t7;
        this.f24944b = aVar;
        this.f24945c = null;
    }

    public static <T> p<T> a(u uVar) {
        return new p<>(uVar);
    }

    public static <T> p<T> c(T t7, com.haier.globalwasher.mvp_api.volley.b.a aVar) {
        return new p<>(t7, aVar);
    }

    public boolean b() {
        return this.f24945c == null;
    }

    private p(u uVar) {
        this.f24946d = false;
        this.f24943a = null;
        this.f24944b = null;
        this.f24945c = uVar;
    }
}
