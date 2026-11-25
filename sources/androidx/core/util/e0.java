package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.collections.u0;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes.dex */
public final class e0 {

    public static final class a extends u0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SparseIntArray f6360b;

        a(SparseIntArray sparseIntArray) {
            this.f6360b = sparseIntArray;
        }

        @Override // kotlin.collections.u0
        public int b() {
            SparseIntArray sparseIntArray = this.f6360b;
            int i7 = this.f6359a;
            this.f6359a = i7 + 1;
            return sparseIntArray.keyAt(i7);
        }

        public final int d() {
            return this.f6359a;
        }

        public final void e(int i7) {
            this.f6359a = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6359a < this.f6360b.size();
        }
    }

    public static final class b extends u0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SparseIntArray f6362b;

        b(SparseIntArray sparseIntArray) {
            this.f6362b = sparseIntArray;
        }

        @Override // kotlin.collections.u0
        public int b() {
            SparseIntArray sparseIntArray = this.f6362b;
            int i7 = this.f6361a;
            this.f6361a = i7 + 1;
            return sparseIntArray.valueAt(i7);
        }

        public final int d() {
            return this.f6361a;
        }

        public final void e(int i7) {
            this.f6361a = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6361a < this.f6362b.size();
        }
    }

    public static final boolean a(@a7.d SparseIntArray sparseIntArray, int i7) {
        l0.p(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i7) >= 0;
    }

    public static final boolean b(@a7.d SparseIntArray sparseIntArray, int i7) {
        l0.p(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i7) >= 0;
    }

    public static final boolean c(@a7.d SparseIntArray sparseIntArray, int i7) {
        l0.p(sparseIntArray, "<this>");
        return sparseIntArray.indexOfValue(i7) >= 0;
    }

    public static final void d(@a7.d SparseIntArray sparseIntArray, @a7.d i5.p<? super Integer, ? super Integer, l2> action) {
        l0.p(sparseIntArray, "<this>");
        l0.p(action, "action");
        int size = sparseIntArray.size();
        for (int i7 = 0; i7 < size; i7++) {
            action.a0(Integer.valueOf(sparseIntArray.keyAt(i7)), Integer.valueOf(sparseIntArray.valueAt(i7)));
        }
    }

    public static final int e(@a7.d SparseIntArray sparseIntArray, int i7, int i8) {
        l0.p(sparseIntArray, "<this>");
        return sparseIntArray.get(i7, i8);
    }

    public static final int f(@a7.d SparseIntArray sparseIntArray, int i7, @a7.d i5.a<Integer> defaultValue) {
        l0.p(sparseIntArray, "<this>");
        l0.p(defaultValue, "defaultValue");
        int iIndexOfKey = sparseIntArray.indexOfKey(i7);
        return iIndexOfKey >= 0 ? sparseIntArray.valueAt(iIndexOfKey) : defaultValue.invoke().intValue();
    }

    public static final int g(@a7.d SparseIntArray sparseIntArray) {
        l0.p(sparseIntArray, "<this>");
        return sparseIntArray.size();
    }

    public static final boolean h(@a7.d SparseIntArray sparseIntArray) {
        l0.p(sparseIntArray, "<this>");
        return sparseIntArray.size() == 0;
    }

    public static final boolean i(@a7.d SparseIntArray sparseIntArray) {
        l0.p(sparseIntArray, "<this>");
        return sparseIntArray.size() != 0;
    }

    @a7.d
    public static final u0 j(@a7.d SparseIntArray sparseIntArray) {
        l0.p(sparseIntArray, "<this>");
        return new a(sparseIntArray);
    }

    @a7.d
    public static final SparseIntArray k(@a7.d SparseIntArray sparseIntArray, @a7.d SparseIntArray other) {
        l0.p(sparseIntArray, "<this>");
        l0.p(other, "other");
        SparseIntArray sparseIntArray2 = new SparseIntArray(sparseIntArray.size() + other.size());
        l(sparseIntArray2, sparseIntArray);
        l(sparseIntArray2, other);
        return sparseIntArray2;
    }

    public static final void l(@a7.d SparseIntArray sparseIntArray, @a7.d SparseIntArray other) {
        l0.p(sparseIntArray, "<this>");
        l0.p(other, "other");
        int size = other.size();
        for (int i7 = 0; i7 < size; i7++) {
            sparseIntArray.put(other.keyAt(i7), other.valueAt(i7));
        }
    }

    public static final boolean m(@a7.d SparseIntArray sparseIntArray, int i7, int i8) {
        l0.p(sparseIntArray, "<this>");
        int iIndexOfKey = sparseIntArray.indexOfKey(i7);
        if (iIndexOfKey < 0 || i8 != sparseIntArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final void n(@a7.d SparseIntArray sparseIntArray, int i7, int i8) {
        l0.p(sparseIntArray, "<this>");
        sparseIntArray.put(i7, i8);
    }

    @a7.d
    public static final u0 o(@a7.d SparseIntArray sparseIntArray) {
        l0.p(sparseIntArray, "<this>");
        return new b(sparseIntArray);
    }
}
