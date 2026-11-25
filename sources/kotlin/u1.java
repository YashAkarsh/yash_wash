package kotlin;

/* JADX INFO: loaded from: classes2.dex */
public final class u1 {
    @g1(version = "1.3")
    @t
    @kotlin.internal.f
    private static final byte[] a(int i7, i5.l<? super Integer, s1> init) {
        kotlin.jvm.internal.l0.p(init, "init");
        byte[] bArr = new byte[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            bArr[i8] = init.z(Integer.valueOf(i8)).e0();
        }
        return t1.f(bArr);
    }

    @g1(version = "1.3")
    @t
    @kotlin.internal.f
    private static final byte[] b(byte... elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return elements;
    }
}
