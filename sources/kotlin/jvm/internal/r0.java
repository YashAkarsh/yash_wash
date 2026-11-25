package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 extends c1<long[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final long[] f34918d;

    public r0(int i7) {
        super(i7);
        this.f34918d = new long[i7];
    }

    public final void h(long j7) {
        long[] jArr = this.f34918d;
        int iB = b();
        e(iB + 1);
        jArr[iB] = j7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@a7.d long[] jArr) {
        l0.p(jArr, "<this>");
        return jArr.length;
    }

    @a7.d
    public final long[] j() {
        return g(this.f34918d, new long[f()]);
    }
}
