package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 extends c1<int[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final int[] f34864d;

    public k0(int i7) {
        super(i7);
        this.f34864d = new int[i7];
    }

    public final void h(int i7) {
        int[] iArr = this.f34864d;
        int iB = b();
        e(iB + 1);
        iArr[iB] = i7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@a7.d int[] iArr) {
        l0.p(iArr, "<this>");
        return iArr.length;
    }

    @a7.d
    public final int[] j() {
        return g(this.f34864d, new int[f()]);
    }
}
