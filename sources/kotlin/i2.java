package kotlin;

/* JADX INFO: loaded from: classes2.dex */
public final class i2 {
    @g1(version = "1.3")
    @t
    @kotlin.internal.f
    private static final short[] a(int i7, i5.l<? super Integer, g2> init) {
        kotlin.jvm.internal.l0.p(init, "init");
        short[] sArr = new short[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            sArr[i8] = init.z(Integer.valueOf(i8)).e0();
        }
        return h2.f(sArr);
    }

    @g1(version = "1.3")
    @t
    @kotlin.internal.f
    private static final short[] b(short... elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return elements;
    }
}
