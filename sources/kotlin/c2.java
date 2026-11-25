package kotlin;

/* JADX INFO: loaded from: classes2.dex */
public final class c2 {
    @g1(version = "1.3")
    @t
    @kotlin.internal.f
    private static final long[] a(int i7, i5.l<? super Integer, a2> init) {
        kotlin.jvm.internal.l0.p(init, "init");
        long[] jArr = new long[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            jArr[i8] = init.z(Integer.valueOf(i8)).g0();
        }
        return b2.f(jArr);
    }

    @g1(version = "1.3")
    @t
    @kotlin.internal.f
    private static final long[] b(long... elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return elements;
    }
}
