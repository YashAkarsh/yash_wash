package org.chromium.base.task;

import c.o0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class u {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte f38948h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f38949i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f38950j = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final u f38951k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final u f38952l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final u f38953m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final u f38954n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final u f38955o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final u f38956p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final u f38957q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final u f38958r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final u f38959s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final u f38960t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final u f38961u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final /* synthetic */ boolean f38962v = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f38963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f38964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f38965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f38966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    byte f38967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    byte[] f38968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f38969g;

    static {
        u uVarD = new u().d(0);
        f38951k = uVarD;
        f38952l = uVarD.c();
        u uVarD2 = new u().d(1);
        f38953m = uVarD2;
        f38954n = uVarD2.c();
        u uVarD3 = new u().d(2);
        f38955o = uVarD3;
        f38956p = uVarD3.c();
        u uVar = new u();
        f38957q = uVar;
        uVar.f38969g = true;
        u uVarE = new u().e();
        f38958r = uVarE;
        f38959s = uVarE.d(2);
        f38960t = uVarE.d(1);
        f38961u = uVarE.d(0);
    }

    private u() {
        this.f38964b = 1;
    }

    public <Extension> Extension a(v<Extension> vVar) {
        if (this.f38967e == vVar.a()) {
            return vVar.c(this.f38968f);
        }
        return null;
    }

    public boolean b() {
        return this.f38967e != 0;
    }

    public u c() {
        u uVar = new u(this);
        uVar.f38965c = true;
        return uVar;
    }

    public u d(int i7) {
        u uVar = new u(this);
        uVar.f38963a = true;
        uVar.f38964b = i7;
        return uVar;
    }

    public u e() {
        u uVar = new u(this);
        uVar.f38966d = true;
        return uVar;
    }

    public boolean equals(@o0 Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f38963a == uVar.f38963a && this.f38964b == uVar.f38964b && this.f38967e == uVar.f38967e && Arrays.equals(this.f38968f, uVar.f38968f);
    }

    public <Extension> u f(v<Extension> vVar, Extension extension) {
        int iA = vVar.a();
        byte[] bArrB = vVar.b(extension);
        u uVar = new u(this);
        uVar.f38967e = (byte) iA;
        uVar.f38968f = bArrB;
        return uVar;
    }

    public int hashCode() {
        return ((((((((((((1147 + (!this.f38963a ? 1 : 0)) * 37) + this.f38964b) * 37) + (!this.f38965c ? 1 : 0)) * 37) + (!this.f38966d ? 1 : 0)) * 37) + this.f38967e) * 37) + Arrays.hashCode(this.f38968f)) * 37) + (!this.f38969g ? 1 : 0);
    }

    private u(u uVar) {
        this.f38963a = uVar.f38963a;
        this.f38964b = uVar.f38964b;
        this.f38965c = uVar.f38965c;
        this.f38966d = uVar.f38966d;
        this.f38967e = uVar.f38967e;
        this.f38968f = uVar.f38968f;
    }
}
