package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.LongSparseArray;
import c.t0;
import java.util.Iterator;
import kotlin.collections.v0;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    public static final class a extends v0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LongSparseArray<T> f6378b;

        a(LongSparseArray<T> longSparseArray) {
            this.f6378b = longSparseArray;
        }

        @Override // kotlin.collections.v0
        @SuppressLint({"ClassVerificationFailure"})
        public long b() {
            LongSparseArray<T> longSparseArray = this.f6378b;
            int i7 = this.f6377a;
            this.f6377a = i7 + 1;
            return longSparseArray.keyAt(i7);
        }

        public final int d() {
            return this.f6377a;
        }

        public final void e(int i7) {
            this.f6377a = i7;
        }

        @Override // java.util.Iterator
        @SuppressLint({"ClassVerificationFailure"})
        public boolean hasNext() {
            return this.f6377a < this.f6378b.size();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> implements Iterator<T>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LongSparseArray<T> f6380b;

        b(LongSparseArray<T> longSparseArray) {
            this.f6380b = longSparseArray;
        }

        public final int a() {
            return this.f6379a;
        }

        public final void b(int i7) {
            this.f6379a = i7;
        }

        @Override // java.util.Iterator
        @SuppressLint({"ClassVerificationFailure"})
        public boolean hasNext() {
            return this.f6379a < this.f6380b.size();
        }

        @Override // java.util.Iterator
        @SuppressLint({"ClassVerificationFailure"})
        public T next() {
            LongSparseArray<T> longSparseArray = this.f6380b;
            int i7 = this.f6379a;
            this.f6379a = i7 + 1;
            return longSparseArray.valueAt(i7);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @t0(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean a(@a7.d LongSparseArray<T> longSparseArray, long j7) {
        l0.p(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j7) >= 0;
    }

    @t0(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean b(@a7.d LongSparseArray<T> longSparseArray, long j7) {
        l0.p(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j7) >= 0;
    }

    @t0(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean c(@a7.d LongSparseArray<T> longSparseArray, T t7) {
        l0.p(longSparseArray, "<this>");
        return longSparseArray.indexOfValue(t7) >= 0;
    }

    @t0(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> void d(@a7.d LongSparseArray<T> longSparseArray, @a7.d i5.p<? super Long, ? super T, l2> action) {
        l0.p(longSparseArray, "<this>");
        l0.p(action, "action");
        int size = longSparseArray.size();
        for (int i7 = 0; i7 < size; i7++) {
            action.a0(Long.valueOf(longSparseArray.keyAt(i7)), longSparseArray.valueAt(i7));
        }
    }

    @t0(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> T e(@a7.d LongSparseArray<T> longSparseArray, long j7, T t7) {
        l0.p(longSparseArray, "<this>");
        T t8 = longSparseArray.get(j7);
        return t8 == null ? t7 : t8;
    }

    @t0(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> T f(@a7.d LongSparseArray<T> longSparseArray, long j7, @a7.d i5.a<? extends T> defaultValue) {
        l0.p(longSparseArray, "<this>");
        l0.p(defaultValue, "defaultValue");
        T t7 = longSparseArray.get(j7);
        return t7 == null ? defaultValue.invoke() : t7;
    }

    @t0(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> int g(@a7.d LongSparseArray<T> longSparseArray) {
        l0.p(longSparseArray, "<this>");
        return longSparseArray.size();
    }

    @t0(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean h(@a7.d LongSparseArray<T> longSparseArray) {
        l0.p(longSparseArray, "<this>");
        return longSparseArray.size() == 0;
    }

    @t0(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean i(@a7.d LongSparseArray<T> longSparseArray) {
        l0.p(longSparseArray, "<this>");
        return longSparseArray.size() != 0;
    }

    @a7.d
    @t0(16)
    public static final <T> v0 j(@a7.d LongSparseArray<T> longSparseArray) {
        l0.p(longSparseArray, "<this>");
        return new a(longSparseArray);
    }

    @a7.d
    @t0(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> LongSparseArray<T> k(@a7.d LongSparseArray<T> longSparseArray, @a7.d LongSparseArray<T> other) {
        l0.p(longSparseArray, "<this>");
        l0.p(other, "other");
        LongSparseArray<T> longSparseArray2 = new LongSparseArray<>(longSparseArray.size() + other.size());
        l(longSparseArray2, longSparseArray);
        l(longSparseArray2, other);
        return longSparseArray2;
    }

    @t0(16)
    public static final <T> void l(@a7.d LongSparseArray<T> longSparseArray, @a7.d LongSparseArray<T> other) {
        l0.p(longSparseArray, "<this>");
        l0.p(other, "other");
        int size = other.size();
        for (int i7 = 0; i7 < size; i7++) {
            longSparseArray.put(other.keyAt(i7), other.valueAt(i7));
        }
    }

    @t0(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> boolean m(@a7.d LongSparseArray<T> longSparseArray, long j7, T t7) {
        l0.p(longSparseArray, "<this>");
        int iIndexOfKey = longSparseArray.indexOfKey(j7);
        if (iIndexOfKey < 0 || !l0.g(t7, longSparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(iIndexOfKey);
        return true;
    }

    @t0(16)
    @SuppressLint({"ClassVerificationFailure"})
    public static final <T> void n(@a7.d LongSparseArray<T> longSparseArray, long j7, T t7) {
        l0.p(longSparseArray, "<this>");
        longSparseArray.put(j7, t7);
    }

    @a7.d
    @t0(16)
    public static final <T> Iterator<T> o(@a7.d LongSparseArray<T> longSparseArray) {
        l0.p(longSparseArray, "<this>");
        return new b(longSparseArray);
    }
}
