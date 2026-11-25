package kotlin.ranges;

import kotlin.g1;
import kotlin.o2;
import kotlin.q2;
import kotlin.w1;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.5")
@q2(markerClass = {kotlin.t.class})
public final class t extends r implements g<w1> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    public static final a f35054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private static final t f35055f;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        @a7.d
        public final t a() {
            return t.f35055f;
        }

        private a() {
        }
    }

    static {
        kotlin.jvm.internal.w wVar = null;
        f35054e = new a(wVar);
        f35055f = new t(-1, 0, wVar);
    }

    public /* synthetic */ t(int i7, int i8, kotlin.jvm.internal.w wVar) {
        this(i7, i8);
    }

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable) {
        return l(((w1) comparable).g0());
    }

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ Comparable d() {
        return w1.b(n());
    }

    @Override // kotlin.ranges.r
    public boolean equals(@a7.e Object obj) {
        if (obj instanceof t) {
            if (!isEmpty() || !((t) obj).isEmpty()) {
                t tVar = (t) obj;
                if (g() != tVar.g() || h() != tVar.h()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ Comparable f() {
        return w1.b(m());
    }

    @Override // kotlin.ranges.r
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + h();
    }

    @Override // kotlin.ranges.r, kotlin.ranges.g
    public boolean isEmpty() {
        return o2.c(g(), h()) > 0;
    }

    public boolean l(int i7) {
        return o2.c(g(), i7) <= 0 && o2.c(i7, h()) <= 0;
    }

    public int m() {
        return h();
    }

    public int n() {
        return g();
    }

    @Override // kotlin.ranges.r
    @a7.d
    public String toString() {
        return ((Object) w1.b0(g())) + ".." + ((Object) w1.b0(h()));
    }

    private t(int i7, int i8) {
        super(i7, i8, 1, null);
    }
}
