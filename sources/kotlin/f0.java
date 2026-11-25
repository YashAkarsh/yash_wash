package kotlin;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class f0 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34723a;

        static {
            int[] iArr = new int[h0.values().length];
            iArr[h0.SYNCHRONIZED.ordinal()] = 1;
            iArr[h0.PUBLICATION.ordinal()] = 2;
            iArr[h0.NONE.ordinal()] = 3;
            f34723a = iArr;
        }
    }

    @a7.d
    public static <T> d0<T> a(@a7.d i5.a<? extends T> initializer) {
        kotlin.jvm.internal.l0.p(initializer, "initializer");
        return new m1(initializer, null, 2, null);
    }

    @a7.d
    public static final <T> d0<T> b(@a7.e Object obj, @a7.d i5.a<? extends T> initializer) {
        kotlin.jvm.internal.l0.p(initializer, "initializer");
        return new m1(initializer, obj);
    }

    @a7.d
    public static final <T> d0<T> c(@a7.d h0 mode, @a7.d i5.a<? extends T> initializer) {
        kotlin.jvm.internal.l0.p(mode, "mode");
        kotlin.jvm.internal.l0.p(initializer, "initializer");
        int i7 = a.f34723a[mode.ordinal()];
        if (i7 == 1) {
            return new m1(initializer, null, 2, null);
        }
        if (i7 == 2) {
            return new f1(initializer);
        }
        if (i7 == 3) {
            return new m2(initializer);
        }
        throw new j0();
    }
}
