package androidx.core.util;

import android.util.SizeF;
import c.m0;
import c.t0;
import com.facebook.appevents.internal.ViewHierarchyConstants;

/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f6344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f6345b;

    @t0(21)
    private static final class a {
        private a() {
        }

        @m0
        @c.t
        static SizeF a(@m0 a0 a0Var) {
            w.l(a0Var);
            return new SizeF(a0Var.b(), a0Var.a());
        }

        @m0
        @c.t
        static a0 b(@m0 SizeF sizeF) {
            w.l(sizeF);
            return new a0(sizeF.getWidth(), sizeF.getHeight());
        }
    }

    public a0(float f8, float f9) {
        this.f6344a = w.d(f8, ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        this.f6345b = w.d(f9, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
    }

    @t0(21)
    @m0
    public static a0 d(@m0 SizeF sizeF) {
        return a.b(sizeF);
    }

    public float a() {
        return this.f6345b;
    }

    public float b() {
        return this.f6344a;
    }

    @t0(21)
    @m0
    public SizeF c() {
        return a.a(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return a0Var.f6344a == this.f6344a && a0Var.f6345b == this.f6345b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f6344a) ^ Float.floatToIntBits(this.f6345b);
    }

    @m0
    public String toString() {
        return this.f6344a + "x" + this.f6345b;
    }
}
