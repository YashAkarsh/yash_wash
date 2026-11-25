package kotlin.ranges;

import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends kotlin.ranges.a implements g<Character> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    public static final a f35018e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private static final c f35019f = new c(1, 0);

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        @a7.d
        public final c a() {
            return c.f35019f;
        }

        private a() {
        }
    }

    public c(char c8, char c9) {
        super(c8, c9, 1);
    }

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable) {
        return m(((Character) comparable).charValue());
    }

    @Override // kotlin.ranges.a
    public boolean equals(@a7.e Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (g() != cVar.g() || h() != cVar.h()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + h();
    }

    @Override // kotlin.ranges.a, kotlin.ranges.g
    public boolean isEmpty() {
        return l0.t(g(), h()) > 0;
    }

    public boolean m(char c8) {
        return l0.t(g(), c8) <= 0 && l0.t(c8, h()) <= 0;
    }

    @Override // kotlin.ranges.g
    @a7.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Character f() {
        return Character.valueOf(h());
    }

    @Override // kotlin.ranges.g
    @a7.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Character d() {
        return Character.valueOf(g());
    }

    @Override // kotlin.ranges.a
    @a7.d
    public String toString() {
        return g() + ".." + h();
    }
}
