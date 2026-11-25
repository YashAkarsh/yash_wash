package kotlin.ranges;

import kotlin.a2;
import kotlin.g1;
import kotlin.o2;
import kotlin.q2;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.5")
@q2(markerClass = {kotlin.t.class})
public final class w extends u implements g<a2> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    public static final a f35064e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private static final w f35065f = new w(-1, 0, null);

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        @a7.d
        public final w a() {
            return w.f35065f;
        }

        private a() {
        }
    }

    public /* synthetic */ w(long j7, long j8, kotlin.jvm.internal.w wVar) {
        this(j7, j8);
    }

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable) {
        return l(((a2) comparable).g0());
    }

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ Comparable d() {
        return a2.b(n());
    }

    @Override // kotlin.ranges.u
    public boolean equals(@a7.e Object obj) {
        if (obj instanceof w) {
            if (!isEmpty() || !((w) obj).isEmpty()) {
                w wVar = (w) obj;
                if (g() != wVar.g() || h() != wVar.h()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ Comparable f() {
        return a2.b(m());
    }

    @Override // kotlin.ranges.u
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((int) a2.h(g() ^ a2.h(g() >>> 32))) * 31) + ((int) a2.h(h() ^ a2.h(h() >>> 32)));
    }

    @Override // kotlin.ranges.u, kotlin.ranges.g
    public boolean isEmpty() {
        return o2.g(g(), h()) > 0;
    }

    public boolean l(long j7) {
        return o2.g(g(), j7) <= 0 && o2.g(j7, h()) <= 0;
    }

    public long m() {
        return h();
    }

    public long n() {
        return g();
    }

    @Override // kotlin.ranges.u
    @a7.d
    public String toString() {
        return ((Object) a2.b0(g())) + ".." + ((Object) a2.b0(h()));
    }

    private w(long j7, long j8) {
        super(j7, j8, 1L, null);
    }
}
