package androidx.navigation;

import android.os.Bundle;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final u f8798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f8799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f8800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private final Object f8801d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @o0
        private u<?> f8802a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @o0
        private Object f8804c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f8803b = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f8805d = false;

        @m0
        public f a() {
            if (this.f8802a == null) {
                this.f8802a = u.e(this.f8804c);
            }
            return new f(this.f8802a, this.f8803b, this.f8804c, this.f8805d);
        }

        @m0
        public a b(@o0 Object obj) {
            this.f8804c = obj;
            this.f8805d = true;
            return this;
        }

        @m0
        public a c(boolean z7) {
            this.f8803b = z7;
            return this;
        }

        @m0
        public a d(@m0 u<?> uVar) {
            this.f8802a = uVar;
            return this;
        }
    }

    f(@m0 u<?> uVar, boolean z7, @o0 Object obj, boolean z8) {
        if (!uVar.f() && z7) {
            throw new IllegalArgumentException(uVar.c() + " does not allow nullable values");
        }
        if (!z7 && z8 && obj == null) {
            throw new IllegalArgumentException("Argument with type " + uVar.c() + " has null value but is not nullable.");
        }
        this.f8798a = uVar;
        this.f8799b = z7;
        this.f8801d = obj;
        this.f8800c = z8;
    }

    @o0
    public Object a() {
        return this.f8801d;
    }

    @m0
    public u<?> b() {
        return this.f8798a;
    }

    public boolean c() {
        return this.f8800c;
    }

    public boolean d() {
        return this.f8799b;
    }

    void e(@m0 String str, @m0 Bundle bundle) {
        if (this.f8800c) {
            this.f8798a.i(bundle, str, this.f8801d);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f8799b != fVar.f8799b || this.f8800c != fVar.f8800c || !this.f8798a.equals(fVar.f8798a)) {
            return false;
        }
        Object obj2 = this.f8801d;
        if (obj2 != null) {
            return obj2.equals(fVar.f8801d);
        }
        return fVar.f8801d == null;
    }

    boolean f(@m0 String str, @m0 Bundle bundle) {
        if (!this.f8799b && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.f8798a.b(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        int iHashCode = ((((this.f8798a.hashCode() * 31) + (this.f8799b ? 1 : 0)) * 31) + (this.f8800c ? 1 : 0)) * 31;
        Object obj = this.f8801d;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }
}
