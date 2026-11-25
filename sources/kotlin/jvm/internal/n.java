package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends c1<boolean[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final boolean[] f34881d;

    public n(int i7) {
        super(i7);
        this.f34881d = new boolean[i7];
    }

    public final void h(boolean z7) {
        boolean[] zArr = this.f34881d;
        int iB = b();
        e(iB + 1);
        zArr[iB] = z7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@a7.d boolean[] zArr) {
        l0.p(zArr, "<this>");
        return zArr.length;
    }

    @a7.d
    public final boolean[] j() {
        return g(this.f34881d, new boolean[f()]);
    }
}
