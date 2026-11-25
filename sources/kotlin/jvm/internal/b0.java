package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends c1<float[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final float[] f34836d;

    public b0(int i7) {
        super(i7);
        this.f34836d = new float[i7];
    }

    public final void h(float f8) {
        float[] fArr = this.f34836d;
        int iB = b();
        e(iB + 1);
        fArr[iB] = f8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@a7.d float[] fArr) {
        l0.p(fArr, "<this>");
        return fArr.length;
    }

    @a7.d
    public final float[] j() {
        return g(this.f34836d, new float[f()]);
    }
}
