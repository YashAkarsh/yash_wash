package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class j2 {

    @c.t0(26)
    static class a {
        private a() {
        }

        @c.t
        static float[] a(Path path, float f8) {
            return path.approximate(f8);
        }
    }

    private j2() {
    }

    @c.t0(26)
    @c.m0
    public static Collection<h2> a(@c.m0 Path path) {
        return b(path, 0.5f);
    }

    @c.t0(26)
    @c.m0
    public static Collection<h2> b(@c.m0 Path path, @c.v(from = 0.0d) float f8) {
        float[] fArrA = a.a(path, f8);
        int length = fArrA.length / 3;
        ArrayList arrayList = new ArrayList(length);
        for (int i7 = 1; i7 < length; i7++) {
            int i8 = i7 * 3;
            int i9 = (i7 - 1) * 3;
            float f9 = fArrA[i8];
            float f10 = fArrA[i8 + 1];
            float f11 = fArrA[i8 + 2];
            float f12 = fArrA[i9];
            float f13 = fArrA[i9 + 1];
            float f14 = fArrA[i9 + 2];
            if (f9 != f12 && (f10 != f13 || f11 != f14)) {
                arrayList.add(new h2(new PointF(f13, f14), f12, new PointF(f10, f11), f9));
            }
        }
        return arrayList;
    }
}
