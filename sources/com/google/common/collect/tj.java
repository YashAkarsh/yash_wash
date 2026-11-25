package com.google.common.collect;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class tj<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Comparator<? super T> f21141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final T[] f21142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f21143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private T f21144e;

    private tj(Comparator<? super T> comparator, int i7) {
        this.f21141b = (Comparator) com.google.common.base.e0.F(comparator, "comparator");
        this.f21140a = i7;
        com.google.common.base.e0.k(i7 >= 0, "k must be nonnegative, was %s", i7);
        this.f21142c = (T[]) new Object[i7 * 2];
        this.f21143d = 0;
        this.f21144e = null;
    }

    public static <T extends Comparable<? super T>> tj<T> b(int i7) {
        return c(i7, td.A());
    }

    public static <T> tj<T> c(int i7, Comparator<? super T> comparator) {
        return new tj<>(td.i(comparator).F(), i7);
    }

    public static <T extends Comparable<? super T>> tj<T> d(int i7) {
        return e(i7, td.A());
    }

    public static <T> tj<T> e(int i7, Comparator<? super T> comparator) {
        return new tj<>(comparator, i7);
    }

    private int i(int i7, int i8, int i9) {
        T[] tArr = this.f21142c;
        T t7 = tArr[i9];
        tArr[i9] = tArr[i8];
        int i10 = i7;
        while (i7 < i8) {
            if (this.f21141b.compare(this.f21142c[i7], t7) < 0) {
                j(i10, i7);
                i10++;
            }
            i7++;
        }
        T[] tArr2 = this.f21142c;
        tArr2[i8] = tArr2[i10];
        tArr2[i10] = t7;
        return i10;
    }

    private void j(int i7, int i8) {
        T[] tArr = this.f21142c;
        T t7 = tArr[i7];
        tArr[i7] = tArr[i8];
        tArr[i8] = t7;
    }

    private void l() {
        int i7 = (this.f21140a * 2) - 1;
        int iP = com.google.common.math.d.p(i7 + 0, RoundingMode.CEILING) * 3;
        int iMax = 0;
        int i8 = 0;
        int i9 = 0;
        while (iMax < i7) {
            int i10 = i(iMax, i7, ((iMax + i7) + 1) >>> 1);
            int i11 = this.f21140a;
            if (i10 <= i11) {
                if (i10 >= i11) {
                    break;
                }
                iMax = Math.max(i10, iMax + 1);
                i9 = i10;
            } else {
                i7 = i10 - 1;
            }
            i8++;
            if (i8 >= iP) {
                Arrays.sort(this.f21142c, iMax, i7, this.f21141b);
                break;
            }
        }
        this.f21143d = this.f21140a;
        this.f21144e = this.f21142c[i9];
        while (true) {
            i9++;
            if (i9 >= this.f21140a) {
                return;
            }
            if (this.f21141b.compare(this.f21142c[i9], this.f21144e) > 0) {
                this.f21144e = this.f21142c[i9];
            }
        }
    }

    tj<T> a(tj<T> tjVar) {
        for (int i7 = 0; i7 < tjVar.f21143d; i7++) {
            f(tjVar.f21142c[i7]);
        }
        return this;
    }

    public void f(T t7) {
        int i7 = this.f21140a;
        if (i7 == 0) {
            return;
        }
        int i8 = this.f21143d;
        if (i8 == 0) {
            this.f21142c[0] = t7;
            this.f21144e = t7;
            this.f21143d = 1;
            return;
        }
        if (i8 < i7) {
            T[] tArr = this.f21142c;
            this.f21143d = i8 + 1;
            tArr[i8] = t7;
            if (this.f21141b.compare(t7, this.f21144e) > 0) {
                this.f21144e = t7;
                return;
            }
            return;
        }
        if (this.f21141b.compare(t7, this.f21144e) < 0) {
            T[] tArr2 = this.f21142c;
            int i9 = this.f21143d;
            int i10 = i9 + 1;
            this.f21143d = i10;
            tArr2[i9] = t7;
            if (i10 == this.f21140a * 2) {
                l();
            }
        }
    }

    public void g(Iterable<? extends T> iterable) {
        h(iterable.iterator());
    }

    public void h(Iterator<? extends T> it) {
        while (it.hasNext()) {
            f(it.next());
        }
    }

    public List<T> k() {
        Arrays.sort(this.f21142c, 0, this.f21143d, this.f21141b);
        int i7 = this.f21143d;
        int i8 = this.f21140a;
        if (i7 > i8) {
            T[] tArr = this.f21142c;
            Arrays.fill(tArr, i8, tArr.length, (Object) null);
            int i9 = this.f21140a;
            this.f21143d = i9;
            this.f21144e = this.f21142c[i9 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.f21142c, this.f21143d)));
    }
}
