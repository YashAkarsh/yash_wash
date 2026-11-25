package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.collections.u0;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    public static final class a extends u0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SparseArray<T> f6352b;

        a(SparseArray<T> sparseArray) {
            this.f6352b = sparseArray;
        }

        @Override // kotlin.collections.u0
        public int b() {
            SparseArray<T> sparseArray = this.f6352b;
            int i7 = this.f6351a;
            this.f6351a = i7 + 1;
            return sparseArray.keyAt(i7);
        }

        public final int d() {
            return this.f6351a;
        }

        public final void e(int i7) {
            this.f6351a = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6351a < this.f6352b.size();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> implements Iterator<T>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SparseArray<T> f6354b;

        b(SparseArray<T> sparseArray) {
            this.f6354b = sparseArray;
        }

        public final int a() {
            return this.f6353a;
        }

        public final void b(int i7) {
            this.f6353a = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6353a < this.f6354b.size();
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArray<T> sparseArray = this.f6354b;
            int i7 = this.f6353a;
            this.f6353a = i7 + 1;
            return sparseArray.valueAt(i7);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final <T> boolean a(@a7.d SparseArray<T> sparseArray, int i7) {
        l0.p(sparseArray, "<this>");
        return sparseArray.indexOfKey(i7) >= 0;
    }

    public static final <T> boolean b(@a7.d SparseArray<T> sparseArray, int i7) {
        l0.p(sparseArray, "<this>");
        return sparseArray.indexOfKey(i7) >= 0;
    }

    public static final <T> boolean c(@a7.d SparseArray<T> sparseArray, T t7) {
        l0.p(sparseArray, "<this>");
        return sparseArray.indexOfValue(t7) >= 0;
    }

    public static final <T> void d(@a7.d SparseArray<T> sparseArray, @a7.d i5.p<? super Integer, ? super T, l2> action) {
        l0.p(sparseArray, "<this>");
        l0.p(action, "action");
        int size = sparseArray.size();
        for (int i7 = 0; i7 < size; i7++) {
            action.a0(Integer.valueOf(sparseArray.keyAt(i7)), sparseArray.valueAt(i7));
        }
    }

    public static final <T> T e(@a7.d SparseArray<T> sparseArray, int i7, T t7) {
        l0.p(sparseArray, "<this>");
        T t8 = sparseArray.get(i7);
        return t8 == null ? t7 : t8;
    }

    public static final <T> T f(@a7.d SparseArray<T> sparseArray, int i7, @a7.d i5.a<? extends T> defaultValue) {
        l0.p(sparseArray, "<this>");
        l0.p(defaultValue, "defaultValue");
        T t7 = sparseArray.get(i7);
        return t7 == null ? defaultValue.invoke() : t7;
    }

    public static final <T> int g(@a7.d SparseArray<T> sparseArray) {
        l0.p(sparseArray, "<this>");
        return sparseArray.size();
    }

    public static final <T> boolean h(@a7.d SparseArray<T> sparseArray) {
        l0.p(sparseArray, "<this>");
        return sparseArray.size() == 0;
    }

    public static final <T> boolean i(@a7.d SparseArray<T> sparseArray) {
        l0.p(sparseArray, "<this>");
        return sparseArray.size() != 0;
    }

    @a7.d
    public static final <T> u0 j(@a7.d SparseArray<T> sparseArray) {
        l0.p(sparseArray, "<this>");
        return new a(sparseArray);
    }

    @a7.d
    public static final <T> SparseArray<T> k(@a7.d SparseArray<T> sparseArray, @a7.d SparseArray<T> other) {
        l0.p(sparseArray, "<this>");
        l0.p(other, "other");
        SparseArray<T> sparseArray2 = new SparseArray<>(sparseArray.size() + other.size());
        l(sparseArray2, sparseArray);
        l(sparseArray2, other);
        return sparseArray2;
    }

    public static final <T> void l(@a7.d SparseArray<T> sparseArray, @a7.d SparseArray<T> other) {
        l0.p(sparseArray, "<this>");
        l0.p(other, "other");
        int size = other.size();
        for (int i7 = 0; i7 < size; i7++) {
            sparseArray.put(other.keyAt(i7), other.valueAt(i7));
        }
    }

    public static final <T> boolean m(@a7.d SparseArray<T> sparseArray, int i7, T t7) {
        l0.p(sparseArray, "<this>");
        int iIndexOfKey = sparseArray.indexOfKey(i7);
        if (iIndexOfKey < 0 || !l0.g(t7, sparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final <T> void n(@a7.d SparseArray<T> sparseArray, int i7, T t7) {
        l0.p(sparseArray, "<this>");
        sparseArray.put(i7, t7);
    }

    @a7.d
    public static final <T> Iterator<T> o(@a7.d SparseArray<T> sparseArray) {
        l0.p(sparseArray, "<this>");
        return new b(sparseArray);
    }
}
