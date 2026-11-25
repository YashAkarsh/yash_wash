package kotlin.ranges;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends l implements g<Long> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    public static final a f35044e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private static final n f35045f = new n(1, 0);

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        @a7.d
        public final n a() {
            return n.f35045f;
        }

        private a() {
        }
    }

    public n(long j7, long j8) {
        super(j7, j8, 1L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable) {
        return m(((Number) comparable).longValue());
    }

    @Override // kotlin.ranges.l
    public boolean equals(@a7.e Object obj) {
        if (obj instanceof n) {
            if (!isEmpty() || !((n) obj).isEmpty()) {
                n nVar = (n) obj;
                if (g() != nVar.g() || h() != nVar.h()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.l
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (g() ^ (g() >>> 32))) + (h() ^ (h() >>> 32)));
    }

    @Override // kotlin.ranges.l, kotlin.ranges.g
    public boolean isEmpty() {
        return g() > h();
    }

    public boolean m(long j7) {
        return g() <= j7 && j7 <= h();
    }

    @Override // kotlin.ranges.g
    @a7.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Long f() {
        return Long.valueOf(h());
    }

    @Override // kotlin.ranges.g
    @a7.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Long d() {
        return Long.valueOf(g());
    }

    @Override // kotlin.ranges.l
    @a7.d
    public String toString() {
        return g() + ".." + h();
    }
}
