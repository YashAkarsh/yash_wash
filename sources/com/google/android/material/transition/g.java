package com.google.android.material.transition;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f18931a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f18932b = new b();

    static class a implements f {
        a() {
        }

        @Override // com.google.android.material.transition.f
        public h a(float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
            float fP = u.p(f11, f13, f9, f10, f8, true);
            float f15 = fP / f11;
            float f16 = fP / f13;
            return new h(f15, f16, fP, f12 * f15, fP, f14 * f16);
        }

        @Override // com.google.android.material.transition.f
        public boolean b(h hVar) {
            return hVar.f18936d > hVar.f18938f;
        }

        @Override // com.google.android.material.transition.f
        public void c(RectF rectF, float f8, h hVar) {
            rectF.bottom -= Math.abs(hVar.f18938f - hVar.f18936d) * f8;
        }
    }

    static class b implements f {
        b() {
        }

        @Override // com.google.android.material.transition.f
        public h a(float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
            float fP = u.p(f12, f14, f9, f10, f8, true);
            float f15 = fP / f12;
            float f16 = fP / f14;
            return new h(f15, f16, f11 * f15, fP, f13 * f16, fP);
        }

        @Override // com.google.android.material.transition.f
        public boolean b(h hVar) {
            return hVar.f18935c > hVar.f18937e;
        }

        @Override // com.google.android.material.transition.f
        public void c(RectF rectF, float f8, h hVar) {
            float fAbs = (Math.abs(hVar.f18937e - hVar.f18935c) / 2.0f) * f8;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }
    }

    private g() {
    }

    static f a(int i7, boolean z7, RectF rectF, RectF rectF2) {
        if (i7 == 0) {
            return b(z7, rectF, rectF2) ? f18931a : f18932b;
        }
        if (i7 == 1) {
            return f18931a;
        }
        if (i7 == 2) {
            return f18932b;
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
