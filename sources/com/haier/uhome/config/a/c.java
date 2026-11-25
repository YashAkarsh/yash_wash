package com.haier.uhome.config.a;

import com.haier.uhome.config.entity.ConfigResult;
import com.haier.uhome.config.entity.ConfigRouterInfo;
import com.haier.uhome.config.service.i;
import com.haier.uhome.config.service.k;
import com.haier.uhome.config.service.l;
import com.haier.uhome.config.service.m;
import com.haier.uhome.config.service.o;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f28412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private o f28413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private i f28414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.haier.uhome.config.service.e f28415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.haier.uhome.config.service.c f28416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.haier.uhome.config.service.h f28417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WeakHashMap<String, com.haier.uhome.config.service.a> f28418g;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static c f28419a = new c();

        private a() {
        }
    }

    public static c a() {
        return a.f28419a;
    }

    public uSDKError b() {
        return this.f28412a.b();
    }

    public void c(com.haier.uhome.usdk.base.api.o oVar) {
        this.f28413b.c(oVar);
    }

    public void d(com.haier.uhome.usdk.base.api.o oVar) {
        this.f28414c.a(oVar);
    }

    public com.haier.uhome.config.service.a.a<com.haier.uhome.config.entity.a, com.haier.uhome.config.service.d, e<d, com.haier.uhome.config.service.d>> e() {
        return new com.haier.uhome.config.service.f();
    }

    public void f() {
        com.haier.library.sumhttp.a.c.c();
    }

    private c() {
        this.f28418g = new WeakHashMap<>();
        this.f28412a = m.a();
        this.f28413b = o.a();
        this.f28414c = i.a();
        this.f28415d = com.haier.uhome.config.service.e.a();
        this.f28416e = com.haier.uhome.config.service.c.a();
        this.f28417f = com.haier.uhome.config.service.h.a();
    }

    public uSDKError a(String str, String str2, String str3, String str4, List<String> list, boolean z7, int i7, int i8) {
        return this.f28412a.a(str, str2, str3, str4, list, z7, i7, i8);
    }

    public void b(com.haier.uhome.usdk.base.api.o oVar) {
        this.f28413b.b(oVar);
    }

    public void c() {
        this.f28415d.b();
    }

    public com.haier.uhome.config.service.a.a<com.haier.uhome.config.entity.a, com.haier.uhome.config.entity.b, ICallback<com.haier.uhome.config.entity.b>> d() {
        return new k();
    }

    public void a(com.haier.uhome.usdk.base.api.o oVar) {
        this.f28413b.a(oVar);
    }

    public void a(f fVar, boolean z7, boolean z8, TraceNode traceNode, ICallback<ConfigResult> iCallback) {
        this.f28413b.a(fVar, z7, z8, traceNode, iCallback);
    }

    public void a(boolean z7, TraceNode traceNode, ICallback<com.haier.uhome.usdk.base.api.c<f>> iCallback) {
        this.f28413b.a(z7, traceNode, iCallback);
    }

    public void a(String str, String str2, int i7, ICallback<com.haier.uhome.usdk.base.api.c<String>> iCallback) {
        this.f28414c.a(str, str2, i7, iCallback);
    }

    public String a(String str, String str2) {
        return this.f28416e.a(str, str2);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, int i7, TraceNode traceNode, long j7, long j8, int i8, com.haier.uhome.usdk.base.api.k<com.haier.uhome.search.service.entity.d, com.haier.uhome.config.service.d> kVar) {
        this.f28415d.a(str, str2, str3, str4, str5, str6, i7, traceNode, j7, j8, i8, kVar);
    }

    public void a(b bVar, int i7, TraceNode traceNode, com.haier.uhome.usdk.base.api.k<com.haier.uhome.search.service.entity.d, com.haier.uhome.config.service.d> kVar) {
        this.f28415d.a(bVar, i7, traceNode, kVar);
    }

    public void a(com.haier.uhome.config.entity.a.a aVar, TraceNode traceNode, com.haier.uhome.usdk.base.d.e eVar, int i7, h<Integer, String> hVar) {
        com.haier.uhome.config.service.a aVar2 = this.f28418g.get(aVar.a());
        if (aVar2 == null) {
            synchronized (this.f28418g) {
                aVar2 = this.f28418g.get(aVar.a());
                if (aVar2 == null) {
                    aVar2 = new com.haier.uhome.config.service.a();
                    this.f28418g.put(aVar.a(), aVar2);
                }
            }
        }
        aVar2.a(aVar, traceNode, eVar, i7, hVar);
    }

    public void a(String str, String str2, int i7, String str3, int i8, String str4, int i9, String str5, long j7, com.haier.uhome.usdk.base.api.k<Integer, Void> kVar) {
        this.f28417f.a(str, str2, i7, str3, i8, str4, i9, str5, j7, kVar);
    }

    public void a(int i7, ICallback<ConfigRouterInfo> iCallback) {
        new l().a(i7, iCallback);
    }
}
