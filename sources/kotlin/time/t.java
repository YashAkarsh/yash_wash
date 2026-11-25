package kotlin.time;

import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
@k
public final class t<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f35485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f35486b;

    public /* synthetic */ t(Object obj, long j7, w wVar) {
        this(obj, j7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ t d(t tVar, Object obj, long j7, int i7, Object obj2) {
        if ((i7 & 1) != 0) {
            obj = tVar.f35485a;
        }
        if ((i7 & 2) != 0) {
            j7 = tVar.f35486b;
        }
        return tVar.c(obj, j7);
    }

    public final T a() {
        return this.f35485a;
    }

    public final long b() {
        return this.f35486b;
    }

    @a7.d
    public final t<T> c(T t7, long j7) {
        return new t<>(t7, j7, null);
    }

    public final long e() {
        return this.f35486b;
    }

    public boolean equals(@a7.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return l0.g(this.f35485a, tVar.f35485a) && d.n(this.f35486b, tVar.f35486b);
    }

    public final T f() {
        return this.f35485a;
    }

    public int hashCode() {
        T t7 = this.f35485a;
        return ((t7 == null ? 0 : t7.hashCode()) * 31) + d.V(this.f35486b);
    }

    @a7.d
    public String toString() {
        return "TimedValue(value=" + this.f35485a + ", duration=" + ((Object) d.q0(this.f35486b)) + ')';
    }

    private t(T t7, long j7) {
        this.f35485a = t7;
        this.f35486b = j7;
    }
}
