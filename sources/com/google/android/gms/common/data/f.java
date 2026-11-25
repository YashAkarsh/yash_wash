package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.u;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c1.a
    @m0
    protected final DataHolder f15555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c1.a
    protected int f15556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15557c;

    @c1.a
    public f(@m0 DataHolder dataHolder, int i7) {
        this.f15555a = (DataHolder) u.k(dataHolder);
        n(i7);
    }

    @c1.a
    protected void a(@m0 String str, @m0 CharArrayBuffer charArrayBuffer) {
        this.f15555a.T0(str, this.f15556b, this.f15557c, charArrayBuffer);
    }

    @c1.a
    protected boolean b(@m0 String str) {
        return this.f15555a.Q(str, this.f15556b, this.f15557c);
    }

    @c1.a
    @m0
    protected byte[] c(@m0 String str) {
        return this.f15555a.p0(str, this.f15556b, this.f15557c);
    }

    @c1.a
    protected int d() {
        return this.f15556b;
    }

    @c1.a
    protected double e(@m0 String str) {
        return this.f15555a.L0(str, this.f15556b, this.f15557c);
    }

    @c1.a
    public boolean equals(@o0 Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (s.b(Integer.valueOf(fVar.f15556b), Integer.valueOf(this.f15556b)) && s.b(Integer.valueOf(fVar.f15557c), Integer.valueOf(this.f15557c)) && fVar.f15555a == this.f15555a) {
                return true;
            }
        }
        return false;
    }

    @c1.a
    protected float f(@m0 String str) {
        return this.f15555a.Q0(str, this.f15556b, this.f15557c);
    }

    @c1.a
    protected int g(@m0 String str) {
        return this.f15555a.r0(str, this.f15556b, this.f15557c);
    }

    @c1.a
    protected long h(@m0 String str) {
        return this.f15555a.s0(str, this.f15556b, this.f15557c);
    }

    @c1.a
    public int hashCode() {
        return s.c(Integer.valueOf(this.f15556b), Integer.valueOf(this.f15557c), this.f15555a);
    }

    @c1.a
    @m0
    protected String i(@m0 String str) {
        return this.f15555a.x0(str, this.f15556b, this.f15557c);
    }

    @c1.a
    public boolean j(@m0 String str) {
        return this.f15555a.I0(str);
    }

    @c1.a
    protected boolean k(@m0 String str) {
        return this.f15555a.J0(str, this.f15556b, this.f15557c);
    }

    @c1.a
    public boolean l() {
        return !this.f15555a.isClosed();
    }

    @o0
    @c1.a
    protected Uri m(@m0 String str) {
        String strX0 = this.f15555a.x0(str, this.f15556b, this.f15557c);
        if (strX0 == null) {
            return null;
        }
        return Uri.parse(strX0);
    }

    protected final void n(int i7) {
        boolean z7 = false;
        if (i7 >= 0 && i7 < this.f15555a.getCount()) {
            z7 = true;
        }
        u.q(z7);
        this.f15556b = i7;
        this.f15557c = this.f15555a.G0(i7);
    }
}
