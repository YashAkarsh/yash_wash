package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends c1<byte[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final byte[] f34887d;

    public p(int i7) {
        super(i7);
        this.f34887d = new byte[i7];
    }

    public final void h(byte b8) {
        byte[] bArr = this.f34887d;
        int iB = b();
        e(iB + 1);
        bArr[iB] = b8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@a7.d byte[] bArr) {
        l0.p(bArr, "<this>");
        return bArr.length;
    }

    @a7.d
    public final byte[] j() {
        return g(this.f34887d, new byte[f()]);
    }
}
