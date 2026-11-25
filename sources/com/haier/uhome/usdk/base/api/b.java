package com.haier.uhome.usdk.base.api;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f31106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f31107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f31108c;

    protected b(String str, String str2) {
        this.f31107b = str;
        if (TextUtils.isEmpty(str2)) {
            this.f31108c = g.a().a(str);
        } else {
            this.f31106a = str2;
            this.f31108c = g.a().a(str2);
        }
    }

    public String H() {
        return this.f31108c.p().l();
    }

    public int I() {
        return this.f31108c.p().o();
    }

    public String U() {
        return this.f31106a;
    }

    public String V() {
        return this.f31108c.s().b();
    }

    public String W() {
        return this.f31108c.c();
    }

    public String X() {
        return this.f31107b;
    }

    public String Y() {
        return this.f31108c.p().k();
    }

    public int Z() {
        return this.f31108c.p().j();
    }

    public void a(String str) {
        this.f31108c.b(str);
    }

    public h aa() {
        return this.f31108c.f();
    }

    public int ab() {
        return this.f31108c.g();
    }

    public String ac() {
        return this.f31108c.p().i();
    }

    public String ad() {
        return this.f31108c.h();
    }

    public boolean ae() {
        return this.f31108c.m();
    }

    public int af() {
        return this.f31108c.r().e();
    }

    public String ag() {
        return this.f31108c.i();
    }

    public boolean ah() {
        return this.f31108c.s().c();
    }

    public int ai() {
        return this.f31108c.n();
    }

    public int aj() {
        return this.f31108c.o();
    }

    public void c(String str) {
        this.f31107b = str;
        this.f31108c.a(str);
    }

    public void d(String str) {
        this.f31108c.p().f(str);
    }

    public void h(boolean z7) {
        this.f31108c.p().a(z7);
    }

    public boolean i_() {
        return false;
    }

    public String j_() {
        String strP = this.f31108c.p().p();
        return com.haier.library.common.util.c.l(strP) ? strP : "";
    }

    public String toString() {
        return "BaseDeviceInfo{mDevId=" + this.f31108c.b() + ", mUplusId=" + this.f31108c.c() + ", mIp=" + this.f31108c.p().l() + ", mPort=" + this.f31108c.p().o() + ", mSharedPort=" + this.f31108c.p().j() + ", mTypeInfo=" + this.f31108c.e() + ", mBusy=" + this.f31108c.p().n() + ", mProductCode=" + this.f31108c.i() + '}';
    }

    public void d(int i7) {
        this.f31108c.p().d(i7);
    }

    public void c(int i7) {
        this.f31108c.p().e(i7);
    }
}
