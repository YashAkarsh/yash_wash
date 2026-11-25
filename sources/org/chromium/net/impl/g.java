package org.chromium.net.impl;

import c.o0;
import java.util.Date;
import org.chromium.base.s0;
import org.chromium.net.k0;

/* JADX INFO: loaded from: classes3.dex */
@s0
public final class g extends k0.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final /* synthetic */ boolean f39353s = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f39354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f39355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f39356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f39357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f39358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f39359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f39360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f39361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f39362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f39363j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f39364k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f39365l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f39366m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f39367n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @o0
    private final Long f39368o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @o0
    private final Long f39369p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @o0
    private final Long f39370q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @o0
    private final Long f39371r;

    public g(@o0 Long l7, @o0 Long l8, @o0 Long l9, @o0 Long l10) {
        this.f39368o = l7;
        this.f39369p = l8;
        this.f39370q = l9;
        this.f39371r = l10;
        this.f39354a = -1L;
        this.f39355b = -1L;
        this.f39356c = -1L;
        this.f39357d = -1L;
        this.f39358e = -1L;
        this.f39359f = -1L;
        this.f39360g = -1L;
        this.f39361h = -1L;
        this.f39362i = -1L;
        this.f39363j = -1L;
        this.f39364k = -1L;
        this.f39365l = -1L;
        this.f39366m = -1L;
        this.f39367n = false;
    }

    private static boolean s(long j7, long j8) {
        return (j8 >= j7 && j7 != -1) || j8 == -1;
    }

    @o0
    private static Date t(long j7) {
        if (j7 != -1) {
            return new Date(j7);
        }
        return null;
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Date a() {
        return t(this.f39358e);
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Date b() {
        return t(this.f39357d);
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Date c() {
        return t(this.f39356c);
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Date d() {
        return t(this.f39355b);
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Date e() {
        return t(this.f39364k);
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Date f() {
        return t(this.f39363j);
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Long g() {
        return this.f39371r;
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Date h() {
        return t(this.f39366m);
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Date i() {
        return t(this.f39354a);
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Date j() {
        return t(this.f39365l);
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Date k() {
        return t(this.f39362i);
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Date l() {
        return t(this.f39361h);
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Long m() {
        return this.f39370q;
    }

    @Override // org.chromium.net.k0.b
    public boolean n() {
        return this.f39367n;
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Date o() {
        return t(this.f39360g);
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Date p() {
        return t(this.f39359f);
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Long q() {
        return this.f39369p;
    }

    @Override // org.chromium.net.k0.b
    @o0
    public Long r() {
        return this.f39368o;
    }

    public g(long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, boolean z7, long j20, long j21) {
        this.f39354a = j7;
        this.f39355b = j8;
        this.f39356c = j9;
        this.f39357d = j10;
        this.f39358e = j11;
        this.f39359f = j12;
        this.f39360g = j13;
        this.f39361h = j14;
        this.f39362i = j15;
        this.f39363j = j16;
        this.f39364k = j17;
        this.f39365l = j18;
        this.f39366m = j19;
        this.f39367n = z7;
        this.f39370q = Long.valueOf(j20);
        this.f39371r = Long.valueOf(j21);
        if (j7 != -1 && j18 != -1) {
            this.f39368o = Long.valueOf(j18 - j7);
        } else {
            this.f39368o = null;
        }
        if (j7 != -1 && j19 != -1) {
            this.f39369p = Long.valueOf(j19 - j7);
        } else {
            this.f39369p = null;
        }
    }
}
