package com.haier.uhome.search.a;

import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.s;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.haier.uhome.search.service.f f29728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.haier.uhome.search.service.j f29729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.haier.uhome.search.service.b f29730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.haier.uhome.search.service.d f29731d;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static n f29732a = new n();

        private a() {
        }
    }

    public static n a() {
        return a.f29732a;
    }

    public void b(ICallback<Void> iCallback) {
        this.f29731d.c(iCallback);
    }

    public void c(ICallback<Void> iCallback) {
        this.f29728a.a(iCallback);
    }

    public void d(ICallback<Void> iCallback) {
        this.f29728a.b(iCallback);
    }

    public void e(ICallback<Void> iCallback) {
        this.f29730c.b(iCallback);
    }

    public void f(ICallback<Void> iCallback) {
        this.f29730c.c(iCallback);
    }

    private n() {
        this.f29728a = com.haier.uhome.search.service.f.c();
        this.f29729b = com.haier.uhome.search.service.j.c();
        this.f29730c = com.haier.uhome.search.service.b.c();
        this.f29731d = com.haier.uhome.search.service.d.c();
    }

    public void a(ICallback<Void> iCallback) {
        this.f29731d.b(iCallback);
    }

    public boolean b() {
        return this.f29730c.d();
    }

    public ArrayList<com.haier.uhome.usdk.base.api.f> c() {
        ArrayList<com.haier.uhome.usdk.base.api.h> arrayList = new ArrayList<>(1);
        arrayList.add(com.haier.uhome.usdk.base.api.h.ALL_TYPE);
        return a(arrayList);
    }

    public ArrayList<com.haier.uhome.usdk.base.api.f> d() {
        ArrayList<com.haier.uhome.usdk.base.api.h> arrayList = new ArrayList<>(1);
        arrayList.add(com.haier.uhome.usdk.base.api.h.ALL_TYPE);
        return b(arrayList);
    }

    public ArrayList<com.haier.uhome.search.service.entity.g> e() {
        return this.f29731d.d();
    }

    public uSDKError f() {
        return this.f29729b.d();
    }

    public void a(g gVar) {
        this.f29728a.a(gVar);
        this.f29730c.a(gVar);
    }

    public void b(g gVar) {
        this.f29728a.b(gVar);
        this.f29730c.b(gVar);
    }

    public void a(d dVar) {
        this.f29731d.a(dVar);
    }

    public com.haier.uhome.usdk.base.api.f b(String str) {
        return this.f29730c.c(str);
    }

    public com.haier.uhome.usdk.base.api.f a(String str) {
        return this.f29728a.a(str);
    }

    public ArrayList<com.haier.uhome.usdk.base.api.f> b(ArrayList<com.haier.uhome.usdk.base.api.h> arrayList) {
        return this.f29730c.a(arrayList);
    }

    public ArrayList<com.haier.uhome.usdk.base.api.f> a(ArrayList<com.haier.uhome.usdk.base.api.h> arrayList) {
        return this.f29728a.a(arrayList);
    }

    public void a(com.haier.library.common.thread.e eVar, com.haier.uhome.search.a.a aVar, s sVar) {
        this.f29729b.a(eVar, aVar, sVar);
    }
}
