package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public enum x0 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37363a;

        static {
            int[] iArr = new int[x0.values().length];
            iArr[x0.DEFAULT.ordinal()] = 1;
            iArr[x0.ATOMIC.ordinal()] = 2;
            iArr[x0.UNDISPATCHED.ordinal()] = 3;
            iArr[x0.LAZY.ordinal()] = 4;
            f37363a = iArr;
        }
    }

    @j2
    public static /* synthetic */ void e() {
    }

    @j2
    public final <T> void b(@a7.d i5.l<? super kotlin.coroutines.d<? super T>, ? extends Object> lVar, @a7.d kotlin.coroutines.d<? super T> dVar) throws Throwable {
        int i7 = a.f37363a[ordinal()];
        if (i7 == 1) {
            r5.a.c(lVar, dVar);
            return;
        }
        if (i7 == 2) {
            kotlin.coroutines.f.h(lVar, dVar);
        } else if (i7 == 3) {
            r5.b.a(lVar, dVar);
        } else if (i7 != 4) {
            throw new kotlin.j0();
        }
    }

    @j2
    public final <R, T> void c(@a7.d i5.p<? super R, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar, R r7, @a7.d kotlin.coroutines.d<? super T> dVar) throws Throwable {
        int i7 = a.f37363a[ordinal()];
        if (i7 == 1) {
            r5.a.f(pVar, r7, dVar, null, 4, null);
            return;
        }
        if (i7 == 2) {
            kotlin.coroutines.f.i(pVar, r7, dVar);
        } else if (i7 == 3) {
            r5.b.b(pVar, r7, dVar);
        } else if (i7 != 4) {
            throw new kotlin.j0();
        }
    }

    public final boolean d() {
        return this == LAZY;
    }
}
