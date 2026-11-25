package kotlin;

/* JADX INFO: loaded from: classes2.dex */
public final class y1 {
    @g1(version = "1.3")
    @t
    @kotlin.internal.f
    private static final int[] a(int i7, i5.l<? super Integer, w1> init) {
        kotlin.jvm.internal.l0.p(init, "init");
        int[] iArr = new int[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            iArr[i8] = init.z(Integer.valueOf(i8)).g0();
        }
        return x1.f(iArr);
    }

    @g1(version = "1.3")
    @t
    @kotlin.internal.f
    private static final int[] b(int... elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return elements;
    }
}
