package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends c1<double[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final double[] f34956d;

    public y(int i7) {
        super(i7);
        this.f34956d = new double[i7];
    }

    public final void h(double d8) {
        double[] dArr = this.f34956d;
        int iB = b();
        e(iB + 1);
        dArr[iB] = d8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@a7.d double[] dArr) {
        l0.p(dArr, "<this>");
        return dArr.length;
    }

    @a7.d
    public final double[] j() {
        return g(this.f34956d, new double[f()]);
    }
}
