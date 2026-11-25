package androidx.core.graphics;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public final class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointF f5848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f5849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PointF f5850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f5851d;

    public h2(@c.m0 PointF pointF, float f8, @c.m0 PointF pointF2, float f9) {
        this.f5848a = (PointF) androidx.core.util.w.m(pointF, "start == null");
        this.f5849b = f8;
        this.f5850c = (PointF) androidx.core.util.w.m(pointF2, "end == null");
        this.f5851d = f9;
    }

    @c.m0
    public PointF a() {
        return this.f5850c;
    }

    public float b() {
        return this.f5851d;
    }

    @c.m0
    public PointF c() {
        return this.f5848a;
    }

    public float d() {
        return this.f5849b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h2)) {
            return false;
        }
        h2 h2Var = (h2) obj;
        return Float.compare(this.f5849b, h2Var.f5849b) == 0 && Float.compare(this.f5851d, h2Var.f5851d) == 0 && this.f5848a.equals(h2Var.f5848a) && this.f5850c.equals(h2Var.f5850c);
    }

    public int hashCode() {
        int iHashCode = this.f5848a.hashCode() * 31;
        float f8 = this.f5849b;
        int iFloatToIntBits = (((iHashCode + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0)) * 31) + this.f5850c.hashCode()) * 31;
        float f9 = this.f5851d;
        return iFloatToIntBits + (f9 != 0.0f ? Float.floatToIntBits(f9) : 0);
    }

    public String toString() {
        return "PathSegment{start=" + this.f5848a + ", startFraction=" + this.f5849b + ", end=" + this.f5850c + ", endFraction=" + this.f5851d + '}';
    }
}
