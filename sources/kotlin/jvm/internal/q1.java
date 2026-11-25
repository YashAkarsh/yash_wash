package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class q1 extends c1<short[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final short[] f34906d;

    public q1(int i7) {
        super(i7);
        this.f34906d = new short[i7];
    }

    public final void h(short s7) {
        short[] sArr = this.f34906d;
        int iB = b();
        e(iB + 1);
        sArr[iB] = s7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@a7.d short[] sArr) {
        l0.p(sArr, "<this>");
        return sArr.length;
    }

    @a7.d
    public final short[] j() {
        return g(this.f34906d, new short[f()]);
    }
}
