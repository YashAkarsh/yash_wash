package kotlin.ranges;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends i implements g<Integer> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    public static final a f35034e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private static final k f35035f = new k(1, 0);

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        @a7.d
        public final k a() {
            return k.f35035f;
        }

        private a() {
        }
    }

    public k(int i7, int i8) {
        super(i7, i8, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable) {
        return m(((Number) comparable).intValue());
    }

    @Override // kotlin.ranges.i
    public boolean equals(@a7.e Object obj) {
        if (obj instanceof k) {
            if (!isEmpty() || !((k) obj).isEmpty()) {
                k kVar = (k) obj;
                if (g() != kVar.g() || h() != kVar.h()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + h();
    }

    @Override // kotlin.ranges.i, kotlin.ranges.g
    public boolean isEmpty() {
        return g() > h();
    }

    public boolean m(int i7) {
        return g() <= i7 && i7 <= h();
    }

    @Override // kotlin.ranges.g
    @a7.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Integer f() {
        return Integer.valueOf(h());
    }

    @Override // kotlin.ranges.g
    @a7.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Integer d() {
        return Integer.valueOf(g());
    }

    @Override // kotlin.ranges.i
    @a7.d
    public String toString() {
        return g() + ".." + h();
    }
}
