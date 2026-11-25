package com.google.android.material.transition.platform;

import android.graphics.RectF;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f19024a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f19025b = new b();

    static class a implements f {
        a() {
        }

        @Override // com.google.android.material.transition.platform.f
        public h a(float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
            float fP = v.p(f11, f13, f9, f10, f8, true);
            float f15 = fP / f11;
            float f16 = fP / f13;
            return new h(f15, f16, fP, f12 * f15, fP, f14 * f16);
        }

        @Override // com.google.android.material.transition.platform.f
        public boolean b(h hVar) {
            return hVar.f19029d > hVar.f19031f;
        }

        @Override // com.google.android.material.transition.platform.f
        public void c(RectF rectF, float f8, h hVar) {
            rectF.bottom -= Math.abs(hVar.f19031f - hVar.f19029d) * f8;
        }
    }

    static class b implements f {
        b() {
        }

        @Override // com.google.android.material.transition.platform.f
        public h a(float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
            float fP = v.p(f12, f14, f9, f10, f8, true);
            float f15 = fP / f12;
            float f16 = fP / f14;
            return new h(f15, f16, f11 * f15, fP, f13 * f16, fP);
        }

        @Override // com.google.android.material.transition.platform.f
        public boolean b(h hVar) {
            return hVar.f19028c > hVar.f19030e;
        }

        @Override // com.google.android.material.transition.platform.f
        public void c(RectF rectF, float f8, h hVar) {
            float fAbs = (Math.abs(hVar.f19030e - hVar.f19028c) / 2.0f) * f8;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }
    }

    private g() {
    }

    static f a(int i7, boolean z7, RectF rectF, RectF rectF2) {
        if (i7 == 0) {
            return b(z7, rectF, rectF2) ? f19024a : f19025b;
        }
        if (i7 == 1) {
            return f19024a;
        }
        if (i7 == 2) {
            return f19025b;
        }
        throw new IllegalArgumentException("Invalid fit mode: " + i7);
    }

    private static boolean b(boolean z7, RectF rectF, RectF rectF2) {
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        float fWidth2 = rectF2.width();
        float fHeight2 = rectF2.height();
        float f8 = (fHeight2 * fWidth) / fWidth2;
        float f9 = (fWidth2 * fHeight) / fWidth;
        if (z7) {
            if (f8 >= fHeight) {
                return true;
            }
        } else if (f9 >= fHeight2) {
            return true;
        }
        return false;
    }
}
