package com.haier.library.a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class n extends d0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d0 f26276e;

    public n(d0 d0Var) {
        if (d0Var == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f26276e = d0Var;
    }

    @Override // com.haier.library.a.d0
    public d0 a(long j7) {
        return this.f26276e.a(j7);
    }

    @Override // com.haier.library.a.d0
    public d0 b(long j7, TimeUnit timeUnit) {
        return this.f26276e.b(j7, timeUnit);
    }

    @Override // com.haier.library.a.d0
    public boolean e() {
        return this.f26276e.e();
    }

    @Override // com.haier.library.a.d0
    public d0 f() {
        return this.f26276e.f();
    }

    @Override // com.haier.library.a.d0
    public long g() {
        return this.f26276e.g();
    }

    @Override // com.haier.library.a.d0
    public long h() {
        return this.f26276e.h();
    }

    @Override // com.haier.library.a.d0
    public d0 i() {
        return this.f26276e.i();
    }

    @Override // com.haier.library.a.d0
    public void j() throws IOException {
        this.f26276e.j();
    }

    public final n k(d0 d0Var) {
        if (d0Var == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f26276e = d0Var;
        return this;
    }

    public final d0 l() {
        return this.f26276e;
    }
}
