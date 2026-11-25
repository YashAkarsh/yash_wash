package com.haier.uhome.search.a;

import com.haier.uhome.usdk.base.api.ErrorConst;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.haier.uhome.search.service.i f29726a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final l f29727a = new l();

        private a() {
        }
    }

    @Deprecated
    public void a(e eVar) {
    }

    public void b(com.haier.uhome.usdk.base.api.o oVar) {
        this.f29726a.c();
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
    }

    @Deprecated
    public void c(com.haier.uhome.usdk.base.api.o oVar) {
    }

    @Deprecated
    public void d(com.haier.uhome.usdk.base.api.o oVar) {
    }

    public void e(com.haier.uhome.usdk.base.api.o oVar) {
        this.f29726a.a(oVar);
    }

    private l() {
        this.f29726a = com.haier.uhome.search.service.i.a();
    }

    public static l a() {
        return a.f29727a;
    }

    public List<c> c() {
        return this.f29726a.d();
    }

    public boolean d() {
        return this.f29726a.e();
    }

    public boolean e() {
        return this.f29726a.f();
    }

    public void a(com.haier.uhome.usdk.base.api.o oVar) {
        this.f29726a.b();
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
    }

    @Deprecated
    public List<k> b() {
        return new ArrayList();
    }

    public void a(i iVar, com.haier.uhome.usdk.base.api.o oVar) {
        this.f29726a.a(iVar, oVar);
    }

    public void a(f fVar) {
        this.f29726a.a(fVar);
    }

    public void a(boolean z7) {
        this.f29726a.a(z7);
    }
}
