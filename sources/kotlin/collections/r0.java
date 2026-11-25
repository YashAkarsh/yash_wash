package kotlin.collections;

/* JADX INFO: loaded from: classes2.dex */
public final class r0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f34612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f34613b;

    public r0(int i7, T t7) {
        this.f34612a = i7;
        this.f34613b = t7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ r0 d(r0 r0Var, int i7, Object obj, int i8, Object obj2) {
        if ((i8 & 1) != 0) {
            i7 = r0Var.f34612a;
        }
        if ((i8 & 2) != 0) {
            obj = r0Var.f34613b;
        }
        return r0Var.c(i7, obj);
    }

    public final int a() {
        return this.f34612a;
    }

    public final T b() {
        return this.f34613b;
    }

    @a7.d
    public final r0<T> c(int i7, T t7) {
        return new r0<>(i7, t7);
    }

    public final int e() {
        return this.f34612a;
    }

    public boolean equals(@a7.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r0)) {
            return false;
        }
        r0 r0Var = (r0) obj;
        return this.f34612a == r0Var.f34612a && kotlin.jvm.internal.l0.g(this.f34613b, r0Var.f34613b);
    }

    public final T f() {
        return this.f34613b;
    }

    public int hashCode() {
        int i7 = this.f34612a * 31;
        T t7 = this.f34613b;
        return i7 + (t7 == null ? 0 : t7.hashCode());
    }

    @a7.d
    public String toString() {
        return "IndexedValue(index=" + this.f34612a + ", value=" + this.f34613b + ')';
    }
}
