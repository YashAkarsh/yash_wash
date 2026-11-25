package kotlinx.coroutines.internal;

import kotlinx.coroutines.internal.o0;

/* JADX INFO: loaded from: classes3.dex */
@h5.f
public final class p0<S extends o0<S>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private final Object f37015a;

    private /* synthetic */ p0(Object obj) {
        this.f37015a = obj;
    }

    public static final /* synthetic */ p0 a(Object obj) {
        return new p0(obj);
    }

    @a7.d
    public static <S extends o0<S>> Object b(@a7.e Object obj) {
        return obj;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof p0) && kotlin.jvm.internal.l0.g(obj, ((p0) obj2).j());
    }

    public static final boolean d(Object obj, Object obj2) {
        return kotlin.jvm.internal.l0.g(obj, obj2);
    }

    public static /* synthetic */ void e() {
    }

    @a7.d
    public static final S f(Object obj) {
        if (obj == g.f36983b) {
            throw new IllegalStateException("Does not contain segment".toString());
        }
        if (obj != null) {
            return (S) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean h(Object obj) {
        return obj == g.f36983b;
    }

    public static String i(Object obj) {
        return "SegmentOrClosed(value=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f37015a, obj);
    }

    public int hashCode() {
        return g(this.f37015a);
    }

    public final /* synthetic */ Object j() {
        return this.f37015a;
    }

    public String toString() {
        return i(this.f37015a);
    }
}
