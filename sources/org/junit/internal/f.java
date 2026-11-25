package org.junit.internal;

/* JADX INFO: loaded from: classes3.dex */
public class f extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f39841a;

    public f(double d8) {
        this.f39841a = Double.valueOf(d8);
    }

    @Override // org.junit.internal.d
    protected void c(Object obj, Object obj2) {
        if (obj instanceof Double) {
            org.junit.c.t(((Double) obj).doubleValue(), ((Double) obj2).doubleValue(), ((Double) this.f39841a).doubleValue());
        } else {
            org.junit.c.u(((Float) obj).floatValue(), ((Float) obj2).floatValue(), ((Float) this.f39841a).floatValue());
        }
    }

    public f(float f8) {
        this.f39841a = Float.valueOf(f8);
    }
}
