package com.airbnb.lottie.model.content;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f11962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f11963b;

    public c(float[] fArr, int[] iArr) {
        this.f11962a = fArr;
        this.f11963b = iArr;
    }

    public int[] a() {
        return this.f11963b;
    }

    public float[] b() {
        return this.f11962a;
    }

    public int c() {
        return this.f11963b.length;
    }

    public void d(c cVar, c cVar2, float f8) {
        if (cVar.f11963b.length == cVar2.f11963b.length) {
            for (int i7 = 0; i7 < cVar.f11963b.length; i7++) {
                this.f11962a[i7] = com.airbnb.lottie.utils.i.j(cVar.f11962a[i7], cVar2.f11962a[i7], f8);
                this.f11963b[i7] = com.airbnb.lottie.utils.d.c(f8, cVar.f11963b[i7], cVar2.f11963b[i7]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f11963b.length + " vs " + cVar2.f11963b.length + ")");
    }
}
