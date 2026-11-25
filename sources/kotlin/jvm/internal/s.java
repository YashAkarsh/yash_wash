package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends c1<char[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final char[] f34920d;

    public s(int i7) {
        super(i7);
        this.f34920d = new char[i7];
    }

    public final void h(char c8) {
        char[] cArr = this.f34920d;
        int iB = b();
        e(iB + 1);
        cArr[iB] = c8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@a7.d char[] cArr) {
        l0.p(cArr, "<this>");
        return cArr.length;
    }

    @a7.d
    public final char[] j() {
        return g(this.f34920d, new char[f()]);
    }
}
