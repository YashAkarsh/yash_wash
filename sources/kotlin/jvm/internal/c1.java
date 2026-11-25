package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f34842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final T[] f34844c;

    public c1(int i7) {
        this.f34842a = i7;
        this.f34844c = (T[]) new Object[i7];
    }

    private static /* synthetic */ void d() {
    }

    public final void a(@a7.d T spreadArgument) {
        l0.p(spreadArgument, "spreadArgument");
        T[] tArr = this.f34844c;
        int i7 = this.f34843b;
        this.f34843b = i7 + 1;
        tArr[i7] = spreadArgument;
    }

    protected final int b() {
        return this.f34843b;
    }

    protected abstract int c(@a7.d T t7);

    protected final void e(int i7) {
        this.f34843b = i7;
    }

    protected final int f() {
        int iC = 0;
        kotlin.collections.u0 it = new kotlin.ranges.k(0, this.f34842a - 1).iterator();
        while (it.hasNext()) {
            T t7 = this.f34844c[it.b()];
            iC += t7 != null ? c(t7) : 1;
        }
        return iC;
    }

    @a7.d
    protected final T g(@a7.d T values, @a7.d T result) {
        l0.p(values, "values");
        l0.p(result, "result");
        kotlin.collections.u0 it = new kotlin.ranges.k(0, this.f34842a - 1).iterator();
        int i7 = 0;
        int i8 = 0;
        while (it.hasNext()) {
            int iB = it.b();
            T t7 = this.f34844c[iB];
            if (t7 != null) {
                if (i7 < iB) {
                    int i9 = iB - i7;
                    System.arraycopy(values, i7, result, i8, i9);
                    i8 += i9;
                }
                int iC = c(t7);
                System.arraycopy(t7, 0, result, i8, iC);
                i8 += iC;
                i7 = iB + 1;
            }
        }
        int i10 = this.f34842a;
        if (i7 < i10) {
            System.arraycopy(values, i7, result, i8, i10 - i7);
        }
        return result;
    }
}
