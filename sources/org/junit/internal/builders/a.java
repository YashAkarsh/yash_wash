package org.junit.internal.builders;

import java.util.Arrays;
import java.util.Iterator;
import org.junit.runner.l;

/* JADX INFO: loaded from: classes3.dex */
public class a extends org.junit.runners.model.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f39837b;

    public a(boolean z7) {
        this.f39837b = z7;
    }

    @Override // org.junit.runners.model.h
    public l c(Class<?> cls) throws Throwable {
        Iterator it = Arrays.asList(i(), h(), l(), j(), k()).iterator();
        while (it.hasNext()) {
            l lVarG = ((org.junit.runners.model.h) it.next()).g(cls);
            if (lVarG != null) {
                return lVarG;
            }
        }
        return null;
    }

    protected b h() {
        return new b(this);
    }

    protected c i() {
        return new c();
    }

    protected e j() {
        return new e();
    }

    protected f k() {
        return new f();
    }

    protected org.junit.runners.model.h l() {
        return this.f39837b ? new h() : new g();
    }
}
