package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.SparseLongArray;
import c.t0;
import kotlin.collections.u0;
import kotlin.collections.v0;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes.dex */
public final class f0 {

    public static final class a extends u0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SparseLongArray f6364b;

        a(SparseLongArray sparseLongArray) {
            this.f6364b = sparseLongArray;
        }

        @Override // kotlin.collections.u0
        public int b() {
            SparseLongArray sparseLongArray = this.f6364b;
            int i7 = this.f6363a;
            this.f6363a = i7 + 1;
            return sparseLongArray.keyAt(i7);
        }

        public final int d() {
            return this.f6363a;
        }

        public final void e(int i7) {
            this.f6363a = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6363a < this.f6364b.size();
        }
    }

    public static final class b extends v0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SparseLongArray f6366b;

        b(SparseLongArray sparseLongArray) {
            this.f6366b = sparseLongArray;
        }

        @Override // kotlin.collections.v0
        public long b() {
            SparseLongArray sparseLongArray = this.f6366b;
            int i7 = this.f6365a;
            this.f6365a = i7 + 1;
            return sparseLongArray.valueAt(i7);
        }

        public final int d() {
            return this.f6365a;
        }

        public final void e(int i7) {
            this.f6365a = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6365a < this.f6366b.size();
        }
    }

    @t0(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean a(@a7.d SparseLongArray sparseLongArray, int i7) {
        l0.p(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i7) >= 0;
    }

    @t0(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean b(@a7.d SparseLongArray sparseLongArray, int i7) {
        l0.p(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i7) >= 0;
    }

    @t0(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean c(@a7.d SparseLongArray sparseLongArray, long j7) {
        l0.p(sparseLongArray, "<this>");
        return sparseLongArray.indexOfValue(j7) >= 0;
    }

    @t0(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final void d(@a7.d SparseLongArray sparseLongArray, @a7.d i5.p<? super Integer, ? super Long, l2> action) {
        l0.p(sparseLongArray, "<this>");
        l0.p(action, "action");
        int size = sparseLongArray.size();
        for (int i7 = 0; i7 < size; i7++) {
            action.a0(Integer.valueOf(sparseLongArray.keyAt(i7)), Long.valueOf(sparseLongArray.valueAt(i7)));
        }
    }

    @t0(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long e(@a7.d SparseLongArray sparseLongArray, int i7, long j7) {
        l0.p(sparseLongArray, "<this>");
        return sparseLongArray.get(i7, j7);
    }

    @t0(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long f(@a7.d SparseLongArray sparseLongArray, int i7, @a7.d i5.a<Long> defaultValue) {
        l0.p(sparseLongArray, "<this>");
        l0.p(defaultValue, "defaultValue");
        int iIndexOfKey = sparseLongArray.indexOfKey(i7);
        return iIndexOfKey >= 0 ? sparseLongArray.valueAt(iIndexOfKey) : defaultValue.invoke().longValue();
    }

    @t0(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final int g(@a7.d SparseLongArray sparseLongArray) {
        l0.p(sparseLongArray, "<this>");
        return sparseLongArray.size();
    }

    @t0(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean h(@a7.d SparseLongArray sparseLongArray) {
        l0.p(sparseLongArray, "<this>");
        return sparseLongArray.size() == 0;
    }

    @t0(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean i(@a7.d SparseLongArray sparseLongArray) {
        l0.p(sparseLongArray, "<this>");
        return sparseLongArray.size() != 0;
    }

    @a7.d
    @t0(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final u0 j(@a7.d SparseLongArray sparseLongArray) {
        l0.p(sparseLongArray, "<this>");
        return new a(sparseLongArray);
    }

    @a7.d
    @t0(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final SparseLongArray k(@a7.d SparseLongArray sparseLongArray, @a7.d SparseLongArray other) {
        l0.p(sparseLongArray, "<this>");
        l0.p(other, "other");
        SparseLongArray sparseLongArray2 = new SparseLongArray(sparseLongArray.size() + other.size());
        l(sparseLongArray2, sparseLongArray);
        l(sparseLongArray2, other);
        return sparseLongArray2;
    }

    @t0(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final void l(@a7.d SparseLongArray sparseLongArray, @a7.d SparseLongArray other) {
        l0.p(sparseLongArray, "<this>");
        l0.p(other, "other");
        int size = other.size();
        for (int i7 = 0; i7 < size; i7++) {
            sparseLongArray.put(other.keyAt(i7), other.valueAt(i7));
        }
    }

    @t0(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean m(@a7.d SparseLongArray sparseLongArray, int i7, long j7) {
        l0.p(sparseLongArray, "<this>");
        int iIndexOfKey = sparseLongArray.indexOfKey(i7);
        if (iIndexOfKey < 0 || j7 != sparseLongArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(iIndexOfKey);
        return true;
    }

    @t0(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final void n(@a7.d SparseLongArray sparseLongArray, int i7, long j7) {
        l0.p(sparseLongArray, "<this>");
        sparseLongArray.put(i7, j7);
    }

    @a7.d
    @t0(18)
    @SuppressLint({"ClassVerificationFailure"})
    public static final v0 o(@a7.d SparseLongArray sparseLongArray) {
        l0.p(sparseLongArray, "<this>");
        return new b(sparseLongArray);
    }
}
