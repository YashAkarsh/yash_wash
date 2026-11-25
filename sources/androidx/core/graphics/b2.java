package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public final class b2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.m0
    public static final b2 f5776e = new b2(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5780d;

    @c.t0(29)
    static class a {
        private a() {
        }

        @c.t
        static Insets a(int i7, int i8, int i9, int i10) {
            return Insets.of(i7, i8, i9, i10);
        }
    }

    private b2(int i7, int i8, int i9, int i10) {
        this.f5777a = i7;
        this.f5778b = i8;
        this.f5779c = i9;
        this.f5780d = i10;
    }

    @c.m0
    public static b2 a(@c.m0 b2 b2Var, @c.m0 b2 b2Var2) {
        return d(b2Var.f5777a + b2Var2.f5777a, b2Var.f5778b + b2Var2.f5778b, b2Var.f5779c + b2Var2.f5779c, b2Var.f5780d + b2Var2.f5780d);
    }

    @c.m0
    public static b2 b(@c.m0 b2 b2Var, @c.m0 b2 b2Var2) {
        return d(Math.max(b2Var.f5777a, b2Var2.f5777a), Math.max(b2Var.f5778b, b2Var2.f5778b), Math.max(b2Var.f5779c, b2Var2.f5779c), Math.max(b2Var.f5780d, b2Var2.f5780d));
    }

    @c.m0
    public static b2 c(@c.m0 b2 b2Var, @c.m0 b2 b2Var2) {
        return d(Math.min(b2Var.f5777a, b2Var2.f5777a), Math.min(b2Var.f5778b, b2Var2.f5778b), Math.min(b2Var.f5779c, b2Var2.f5779c), Math.min(b2Var.f5780d, b2Var2.f5780d));
    }

    @c.m0
    public static b2 d(int i7, int i8, int i9, int i10) {
        return (i7 == 0 && i8 == 0 && i9 == 0 && i10 == 0) ? f5776e : new b2(i7, i8, i9, i10);
    }

    @c.m0
    public static b2 e(@c.m0 Rect rect) {
        return d(rect.left, rect.top, rect.right, rect.bottom);
    }

    @c.m0
    public static b2 f(@c.m0 b2 b2Var, @c.m0 b2 b2Var2) {
        return d(b2Var.f5777a - b2Var2.f5777a, b2Var.f5778b - b2Var2.f5778b, b2Var.f5779c - b2Var2.f5779c, b2Var.f5780d - b2Var2.f5780d);
    }

    @c.t0(api = 29)
    @c.m0
    public static b2 g(@c.m0 Insets insets) {
        return d(insets.left, insets.top, insets.right, insets.bottom);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @c.m0
    @Deprecated
    @c.t0(api = 29)
    public static b2 i(@c.m0 Insets insets) {
        return g(insets);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b2.class != obj.getClass()) {
            return false;
        }
        b2 b2Var = (b2) obj;
        return this.f5780d == b2Var.f5780d && this.f5777a == b2Var.f5777a && this.f5779c == b2Var.f5779c && this.f5778b == b2Var.f5778b;
    }

    @c.t0(29)
    @c.m0
    public Insets h() {
        return a.a(this.f5777a, this.f5778b, this.f5779c, this.f5780d);
    }

    public int hashCode() {
        return (((((this.f5777a * 31) + this.f5778b) * 31) + this.f5779c) * 31) + this.f5780d;
    }

    @c.m0
    public String toString() {
        return "Insets{left=" + this.f5777a + ", top=" + this.f5778b + ", right=" + this.f5779c + ", bottom=" + this.f5780d + '}';
    }
}
